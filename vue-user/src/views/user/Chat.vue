<template>
    <layout>
        <breadcrumb title="Chat" current="Chat"/>
        <!-- recordContent 聊天记录数组-->
        <div class="chat-content" show>
        <!-- <el-backtop target=".chat-content" :visibility-height="vHeight">
            <i class="el-icon-caret-top"></i>
        </el-backtop> -->
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
        <form class="mt--20" action="#" id="comment-form" onsubmit="return false">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-12">
                    <div class="rnform-group">
                        <grammarly-editor-plugin :config="{
                            activation: 'focus',
                            autocomplete: 'on',
                            underlines: 'on',
                            toneDetector: 'on'
                        }" clientId="client_FB5htQfgvMprDoEMqvDsLw">
                        <textarea ref="content" v-model="content" placeholder="Start Chatting" />
                        <grammarly-button />
                        </grammarly-editor-plugin>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="blog-btn" v-on:click="send()">
                        <a class="btn btn-primary-alta btn-large w-100" href="#">
                            <span>Send</span>
                        </a>
                    </div>
                </div>
            </div>
        </form>
        </div>
    </layout>
</template>
<script>
import Layout from '@/components/layouts/Layout'
import Breadcrumb from '@/components/breadcrumb/Breadcrumb'
import request from "@/utils/request";
import SalScrollAnimationMixin from '@/mixins/SalScrollAnimationMixin'
// import SockJS from 'sockjs-client'
import { GrammarlyEditorPlugin, GrammarlyButton } from "@grammarly/editor-sdk-vue"
// import Stomp from 'webstomp-client'
import cookie from "js-cookie"
import chatApi from "@/api/chat"
import Toastify from "toastify-js";
import router from "@/router";

export default {
  name: 'Chat',
  components: { Breadcrumb, Layout, GrammarlyEditorPlugin, GrammarlyButton},
  mixins: [SalScrollAnimationMixin],
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
      txt2: true, // 回到底部
    }
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
  },
  beforeDestroy() {
    this.myDestory()
  },
  methods: {
    getCurrentUser(){
        let userTemp = cookie.get("current_user")
        // console.log(userTemp)
        if (userTemp){
            this.user = JSON.parse(userTemp);
            this.username = this.user.username
            // console.log(userTemp.id)
            this.senderInfo.id = Number(this.user.id)
            this.senderInfo.username = this.user.username
            this.senderInfo.avatar = this.user.avatar
            console.log(this.senderInfo)
        }
        else{
            // TODO 反之要求登陆
            Toastify({
              text: "You should login first!",
              duration: 3000,
              close: false,
              // avatar:"/img/logo-dark.44b49d43.png",
              gravity: "top", // `top` or `bottom`
              position: "right", // `left`, `center` or `right`
              stopOnFocus: false, // Prevents dismissing of toast on hover
              style: {
                "font-size": "large",
                "font-family":"\"Roboto\", sans-serif",
                background: "linear-gradient(to right, #00b09b, #96c93d)",
              },
              onClick: function(){} // Callback after click
            }).showToast();
            // window.alert("You should login first!");
            router.push({path: '/login'});
        }       
    },
    myDestory() {
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
      console.log(this.content)
      chatApi.sendChat(tmp)
        .then(response => {
          this.init()
          this.$refs['content'].setContent('')
        })
    },
    init() {
      this.content = ''
      this.receiverInfo.id = Number(this.$route.params.id)
      console.log("111")
      this.getCurrentUser()
    //   console.log(this.senderInfo)
    //   console.log(this.receiverInfo)
      this.getChatInfo()
      chatApi.getReceiverInfo(this.receiverInfo.id).then((response) => {
        // console.log(response.data)
        this.receiverInfo = response.data.receiverInfo
      })
    },

    getChatInfo() {
      // 调用根据id查询的方法
      // console.log('222')
      // console.log(this.userInfo
    //   console.log(this.receiverInfo.id, this.senderInfo.id)
      chatApi.getChatInfoById(this.receiverInfo.id, this.senderInfo.id)
        .then(response => {
        //   console.log(response)
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

