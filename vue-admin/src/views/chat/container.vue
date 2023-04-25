<template>
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
      <div v-if="item.sender === username" class="word">
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
          <p class="time">{{ receiverInfo.username }} {{ item.createdAt }}</p>
          <div class="info-content" v-html="item.content" />
        </div>
        <img :src="`/backend/static/` + receiverInfo.avatar">
      </div>
    </div>
    <tinymce ref="content" v-model="content" :height="200" />
    <el-button type="success" round @click="send()">Send</el-button>
  </div>
</template>
<script>
import { getChatInfo, sendChat, getInfo } from '@/api/chat'
import Tinymce from '@/components/Tinymce'

import { mapGetters } from 'vuex'

export default {
  name: 'Container',
  components: { Tinymce },
  data() {
    return {
      senderInfo: {},
      receiverInfo: {},
      recordContent: {},
      username: '',
      vHeight: 10,
      content: '',
      id: '',
      txt1: true, // 回到顶部
      txt2: true // 回到底部
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
      this.init()
    }
  },
  created() {
    this.init()
  },
  mounted() {
    // 页面渲染之后执行
    // this.timer1 = setInterval(() => {
    //   this.getChatInfo()
    // }, 3000)
  },
  beforeDestroy() {
    clearInterval(this.timer1)
  },
  methods: {
    send() {
      var Obj = {
        staffId: this.staffInfo.id,
        userId: this.userInfo.id,
        content: this.content
      }
      // console.log(Obj)

      sendChat(Obj).then((response) => {
        // console.log(222)
        this.init()
        this.$refs.content.setContent('')
      })
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
          console.log('refreshing')
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

