<template>
  <div class="app-container">
    <!-- recordContent 聊天记录数组-->
    <div class="chat-content" show>
      <!-- <el-backtop target=".chat-content" :visibility-height="vHeight">
        <i class="el-icon-caret-top"></i>
      </el-backtop> -->
      <a
        style="
          width: 39px;
          height: 39px;
          position: fixed;
          bottom: 119px;
          right: 3px;
          z-index: 999;
        "
        @mouseover="changeActive($event)"
        @mouseout="removeActive($event)"
        @click="backTOP"
      >
        <!-- style="width: 100%;height: 39px;position: absolute;bottom: 80px;z-index: 9000px;" -->
        <el-image
          v-show="txt1"
          :src="require('@/assets/up.png')"
          style="width: 39px; height: 39px; margin-right: 20%"
        />
        <span
          v-show="!txt1"
          class="show-txt"
          style="width: 100%; height: 39px; display: block"
        ><font color="#889AA4">回到顶部</font></span>
      </a>
      <a
        style="
          width: 39px;
          height: 39px;
          position: fixed;
          bottom: 70px;
          right: 3px;
          z-index: 999;
        "
        @mouseover="changeActive2($event)"
        @mouseout="removeActive2($event)"
        @click="toBottom"
      >
        <!-- position: absolute;bottom: 40px; -->
        <el-image
          v-show="txt2"
          :src="require('@/assets/down.png')"
          style="width: 39px; height: 39px; margin-right: 20%"
        />
        <span
          v-show="!txt2"
          class="show-txt2"
          style="width: 100%; height: 39px; display: block"
        ><font color="#889AA4">回到底部</font></span>
      </a>
      <!-- <el-backtop :visibility-height="0">UP</el-backtop>  -->
      <!-- recordContent 聊天记录数组-->
      <div v-for="(item, index) in recordContent" :key="index">
        <!-- 对方 -->
        <div v-if="item.receiver === username" class="word">
          <!-- {{item.status}} -->
          <img :src="`/backend/static/` + receiverInfo.avatar">
          <div class="info">
            <p class="time">{{ receiverInfo.username }} {{ item.createdAt }}</p>
            <div class="info-content" v-html="item.content" />
          </div>
        </div>
        <!-- 我的 -->
        <div v-else class="word-my">
          <!-- {{item.status}} -->
          <div class="info">
            <p class="time">{{ senderInfo.username }} {{ item.createdAt }}</p>
            <div class="info-content" v-html="item.content" />
          </div>
          <img :src="`/backend/static/` + senderInfo.avatar">
        </div>
      </div>
      <tinymce ref="content" v-model="content" :height="200" />
      <el-button type="success" round @click="send()">Send</el-button>
    </div>
  </div>
</template>
<script>
import { getChatInfo, sendChat, getInfo } from '@/api/chat'
import Tinymce from '@/components/Tinymce'
import waves from '@/directive/waves' // waves directive
// import SockJS from 'sockjs-client'
// import Stomp from 'webstomp-client'
import { mapGetters } from 'vuex'
const calendarTypeOptions = [
  { key: 'CN', display_name: 'China' },
  { key: 'US', display_name: 'USA' },
  { key: 'JP', display_name: 'Japan' },
  { key: 'EU', display_name: 'Eurozone' }
]

// arr to obj, such as { CN : "China", US : "USA" }
const calendarTypeKeyValue = calendarTypeOptions.reduce((acc, cur) => {
  acc[cur.key] = cur.display_name
  return acc
}, {})

export default {
  name: 'Container',
  components: { Tinymce },
  directives: { waves },
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'info',
        deleted: 'danger'
      }
      return statusMap[status]
    },
    typeFilter(type) {
      return calendarTypeKeyValue[type]
    }
  },
  data() {
    return {
      senderInfo: {},
      receiverInfo: {},
      recordContent: {},
      calendarTypeOptions,
      username: '',
      vHeight: 10,
      content: '',
      id: '',
      txt1: true, // 回到顶部
      txt2: true, // 回到底部
      stompClient: null,
      timeout: 28 * 1000, // 30秒一次心跳
      timeoutObj: null, // 心跳心跳倒计时
      serverTimeoutObj: null, // 心跳倒计时
      timeoutnum: null, // 断开 重连倒计时
      websocket: null
      // up: ""
    }
  },
  computed: {
    ...mapGetters([
      'sidebar',
      'avatar',
      'device',
      'name'
    ])
  },
  watch: {
    // 监听
    $route(to, from) {
      // 路由变化方式，路由发生变化，方法就会执行
      this.myDestory()
      this.init()
    }
  },
  created() {
    this.init()
  },
  mounted() {
    // 页面渲染之后执行
    this.timer = setInterval(() => {
      this.getChatInfo()
    }, 3000)
    // this.initWebSocket()
  },
  beforeDestroy() {
    this.myDestory()
  },
  methods: {
    myDestory() {
      this.disconnect()
      clearInterval(this.timer)
    },
    send() {
      var tmp = { sender: this.senderInfo.username,
        receiver: this.receiverInfo.username,
        senderId: this.senderInfo.id,
        receiverId: this.receiverInfo.id,
        content: this.content
      }
      // this.websocketsend(this.content)
      console.log(tmp)
      sendChat(tmp)
        .then(response => {
          // console.log(222)
          this.init()
          this.$refs.content.setContent('')
        })
    },
    initWebSocket() {
      const url = `ws://localhost:8080/webSocket/${this.id}`
      this.websocket = new WebSocket(url)
      // 连接错误
      this.websocket.onerror = this.setErrorMessage
      // 连接成功
      this.websocket.onopen = this.setOnopenMessage
      // 收到消息的回调
      this.websocket.onmessage = this.setOnmessageMessage
      // 连接关闭的回调
      this.websocket.onclose = this.setOncloseMessage
    },
    reconnect() { // 重新连接
      if (this.lockReconnect) return
      this.lockReconnect = true
      // 没连接上会一直重连，设置延迟避免请求过多
      this.timeoutnum && clearTimeout(this.timeoutnum)
      this.timeoutnum = setTimeout(() => {
        // 新连接
        this.initWebSocket()
        this.lockReconnect = false
      }, 5000)
    },
    reset() { // 重置心跳
      // 清除时间
      clearTimeout(this.timeoutObj)
      clearTimeout(this.serverTimeoutObj)
      // 重启心跳
      this.start()
    },
    start() { // 开启心跳
      this.timeoutObj && clearTimeout(this.timeoutObj)
      this.serverTimeoutObj && clearTimeout(this.serverTimeoutObj)
      this.timeoutObj = setTimeout(() => {
        // 这里发送一个心跳，后端收到后，返回一个心跳消息，
        if (this.websocket && this.websocket.readyState === 1) { // 如果连接正常
          this.websocketsend('heartbeat')
        } else { // 否则重连
          this.reconnect()
        }
        this.serverTimeoutObj = setTimeout(() => {
          // 超时关闭
          this.websocket.close()
        }, this.timeout)
      }, this.timeout)
    },
    setOnmessageMessage(event) {
      const obj = JSON.parse(event.data)
      console.log('obj', obj)
      switch (obj.type) {
        case 'heartbeat':
          // 收到服务器信息，心跳重置
          this.reset()
          break
        case 'sendMessage':
          this.data = obj.data
          console.log('接收到的服务器消息：', obj.data)
      }
    },
    setErrorMessage() {
      // 重连
      this.reconnect()
      console.log('WebSocket连接发生错误' + '   状态码：' + this.websocket.readyState)
    },
    setOnopenMessage() {
      // 开启心跳
      this.start()
      console.log('WebSocket连接成功' + '   状态码：' + this.websocket.readyState)
    },
    setOncloseMessage() {
      // 重连
      this.reconnect()
      console.log('WebSocket连接关闭' + '   状态码：' + this.websocket.readyState)
    },
    onbeforeunload() {
      this.closeWebSocket()
    },
    // websocket发送消息
    websocketsend(message) {
      console.log('send Message', message)
      this.websocket.send(message)
    },
    closeWebSocket() { // 关闭websocket
      this.websocket.close()
    },
    init() {
      this.content = ''
      this.id = this.$route.params.id
      this.username = this.name
      this.getChatInfo()
      getInfo(this.username, this.id).then((response) => {
        console.log(response.data)
        this.senderInfo = response.data.senderInfo
        this.receiverInfo = response.data.receiverInfo
      })
      // var userInfo = getPugeUserInfo()
      // if (userInfo) {
      //   userInfo = JSON.parse(userInfo)
      //   this.staffInfo = userInfo
      // }
      // chat.getUserInfo(id).then((response) => {
      //   this.userInfo = response.data.user

      // // })
    },

    getChatInfo() {
      // 调用根据id查询的方法
      // console.log('222')
      // console.log(this.userInfo
      getChatInfo(this.id)
        .then(response => {
          console.log(response)
          this.recordContent = response.data.list
          console.log(this.recordContent)
        })
    },
    // 鼠标移入加入class
    changeActive(/* $event */) {
      // debugger
      this.txt1 = false
      // this.$event.currentTarget.className="active";
    },
    removeActive($event) {
      // debugger
      this.txt1 = true
      // $event.currentTarget.className="";
    },
    // 鼠标移入加入class
    changeActive2(/* $event */) {
      // debugger
      this.txt2 = false
      // this.$event.currentTarget.className="active";
    },
    removeActive2($event) {
      // debugger
      this.txt2 = true
      // $event.currentTarget.className="";
    },
    // 点击回到页面顶端
    backTOP() {
      document.body.scrollTop = document.documentElement.scrollTop = 0
    },
    // 点击回到页面底部
    toBottom(i) {
      const clientHeight = document.documentElement.clientHeight || document.body.clientHeight
      const scrollHeight = document.documentElement.scrollHeight
      const rollheight = scrollHeight - clientHeight // 超出窗口上界的值就是底部的scrolTop的值
      document.documentElement.scrollTop += 200
      if (document.documentElement.scrollTop + 1 <= rollheight) {
        // 之所以+1，可以打印这两个值的日志就知道了，下面+1也是同理
        var c = setTimeout(() => this.toBottom(i), 10) // 调用setTimeout是为了“回到底部”这过程不是一瞬间
      } else {
        clearTimeout(c)
      }
    }
  }

}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.chat-content {
  width: 100%;
  padding: 30px;
  .word {
    display: flex;
    margin-bottom: 20px;
    img {
      width: 40px;
      height: 40px;
      border-radius: 50%;
    }
    .info {
      margin-left: 10px;
      .time {
        font-size: 12px;
        color: rgba(51, 51, 51, 0.8);
        margin: 0;
        height: 20px;
        line-height: 20px;
        margin-top: -5px;
      }
      .info-content {
        padding: 10px;
        font-size: 14px;
        background: rgb(235, 219, 219);
        position: relative;
        margin-top: 8px;
      }
      //小三角形
      .info-content::before {
        position: absolute;
        left: -8px;
        top: 8px;
        content: "";
        border-right: 10px solid rgb(235, 219, 219);
        border-top: 8px solid transparent;
        border-bottom: 8px solid transparent;
      }
    }
  }

  .word-my {
    display: flex;
    justify-content: flex-end;
    margin-bottom: 20px;
    img {
      width: 40px;
      height: 40px;
      border-radius: 50%;
    }
    .info {
      width: 90%;
      margin-left: 10px;
      text-align: right;
      .time {
        font-size: 12px;
        color: rgba(51, 51, 51, 0.8);
        margin: 0;
        height: 20px;
        line-height: 20px;
        margin-top: -5px;
        margin-right: 10px;
      }
      .info-content {
        max-width: 70%;
        padding: 10px;
        font-size: 14px;
        float: right;
        margin-right: 10px;
        position: relative;
        margin-top: 8px;
        background: #a3c3f6;
        text-align: left;
      }
      //小三角形
      .info-content::after {
        position: absolute;
        right: -8px;
        top: 8px;
        content: "";
        border-left: 10px solid #a3c3f6;
        border-top: 8px solid transparent;
        border-bottom: 8px solid transparent;
      }
    }
  }
  .show-txt {
    /* 回到顶部 */
    display: none;
  }
}
</style>

