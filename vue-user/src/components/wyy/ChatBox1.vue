<template>
    <div>
        <beautiful-chat
                :participants="participants"
                :titleImageUrl="titleImageUrl"
                :onMessageWasSent="onMessageWasSent"
                :messageList="messageList"
                :newMessagesCount="newMessagesCount"
                :isOpen="isChatOpen"
                :close="closeChat"
                :icons="icons"
                :open="openChat"
                :showEmoji="true"
                :showFile="true"
                :showEdition="true"
                :showDeletion="true"
                :showTypingIndicator="showTypingIndicator"
                :showLauncher="true"
                :showCloseButton="true"
                :colors="colors"
                :alwaysScrollToBottom="alwaysScrollToBottom"
                :disableUserListToggle="false"
                :messageStyling="messageStyling"
                @onType="handleOnType"
                @edit="editMessage" />
    </div>
</template>
<script>
import cookie from "js-cookie"
import chatApi from "@/api/chat"

export default {
    name: 'app',
    data() {
        return {
            user: "",
            // cssWord: "z-index: 9999",
            participants: [
                {
                    id: 2,
                    name: 'Jinfeng Xu',
                    imageUrl: "/backend/static/default/default-avatar.jpg"
                    // imageUrl: 'https://avatars3.githubusercontent.com/u/37018832?s=200&v=4'
                },
                {
                    id: 'user2',
                    name: 'me',
                    imageUrl: 'https://avatars3.githubusercontent.com/u/37018832?s=200&v=4'
                }
            ], // the list of all the participant of the conversation. `name` is the user name, `id` is used to establish the author of a message, `imageUrl` is supposed to be the user avatar.
            titleImageUrl: 'https://a.slack-edge.com/66f9/img/avatars-teams/ava_0001-34.png',
            messageList: [
                { type: 'text', author: 2, data: { text: `Connecting......` } },
                { type: 'text', author: 2, data: { text: 'Can I help you?' } },
                // { type: 'text', author: 'me', data: { text: "Sure!" } },
                //  { type: 'text', author: 2, data: { text: `Can I help you2?` } }
            ], // the list of the messages to show, can be paginated and adjusted dynamically
            newMessagesCount: 0,
            isChatOpen: false, // to determine whether the chat window should be open or closed
            showTypingIndicator: '', // when set to a value matching the participant.id it shows the typing indicator for the specific user
            colors: {
                header: {
                    bg: '#4e8cff',
                    text: '#ffffff'
                },
                launcher: {
                    bg: '#4e8cff'
                },
                messageList: {
                    bg: '#ffffff'
                },
                sentMessage: {
                    bg: '#4e8cff',
                    text: '#ffffff'
                },
                receivedMessage: {
                    bg: '#eaeaea',
                    text: '#222222'
                },
                userInput: {
                    bg: '#f4f7f9',
                    text: '#565867'
                }
            }, // specifies the color scheme for the component
            alwaysScrollToBottom: false, // when set to true always scrolls the chat to the bottom when new events are in (new message, user starts typing...)
            messageStyling: true // enables *bold* /emph/ _underline_ and such (more info at github.com/mattezza/msgdown)
        }
    },
    mounted(){
        // 页面渲染之后执行
        this.timer = setInterval(() => {
            this.getChatInfo()
        }, 3000)
    },
    beforeDestroy() {
        clearInterval(this.timer)
    },
    created(){
        // this.getCurrentUser()
    },
    methods: {
        getCurrentUser(){
            let userTemp = cookie.get("current_user")
            // console.log(userTemp)
            if (userTemp != null){
                this.user = JSON.parse(userTemp);
                // console.log(userTemp.id)
                this.participants[1].id = this.user.id
                this.participants[1].name = 'me'
                this.participants[1].imageUrl = "/backend/static/" + this.user.avatar
                console.log(this.participants)
            }
            else{
                // TODO 反之要求登陆
            }
        },
        sendMessage(text) {
            // console.log(1212)
            if (text.length > 0) {
                this.newMessagesCount = this.isChatOpen ? this.newMessagesCount : this.newMessagesCount + 1
                this.onMessageWasSent({ type: 'text', author: 'me', data: { text } })
            }
        },
        onMessageWasSent (message) {
            // called when the user sends a message
            // console.log(message)
            // var tmpT = message.data
            var tmp = { 
                    sender: this.user.username,
                    receiver: this.participants[0].name,
                    senderId: this.participants[1].id,
                    receiverId: this.participants[0].id,
                    content: ""
            }
            tmp.content = message.data.text
            console.log(tmp)
            chatApi.sendChat(tmp).then(response => {
                // console.log("666")
                this.messageList = [ ...this.messageList, message ]
                console.log(this.messageList)
            })
            console.log("777")
            
        },
        getChatInfo(){
            this.getCurrentUser()
            chatApi.getInfoById(this.participants[1].id, this.participants[0].id).then(response => {
                const listTmp = response.data.list
                this.messageList = [
                        { type: 'text', author: 2, data: { text: `Connecting......` } },
                        { type: 'text', author: 2, data: { text: 'Can I help you?' } }
                    ]
                for (const tmp of listTmp) {
                    let t = { type: '', author: '', data: { text: "" } }
                    t.type = tmp.type
                    console.log(tmp)
                    if (tmp.author != '2' && tmp.author != 2){
                        t.author = 'me'
                    }else{
                        t.author = tmp.author
                    }
                    t.data.text = tmp.content.replace(/<\/?[^>]+(>|$)/g, "")
                    this.messageList = [ ...this.messageList, t ]
                    console.log(this.messageList)
                }
                // this.
                // this.isChatOpen = true
            })
        },
        openChat () {
            this.isChatOpen = true
            this.newMessagesCount = 0
        },
        closeChat () {
            // called when the user clicks on the botton to close the chat
            this.messageList = []
            console.log(this.messageList)
            this.messageList = [
                { type: 'text', author: 2, data: { text: `Connecting......` } },
                { type: 'text', author: 2, data: { text: 'Can I help you?' } }
            ]
            this.isChatOpen = false
        },
        handleScrollToTop () {
            // called when the user scrolls message list to top
            // leverage pagination for loading another page of messages
        },
        handleOnType () {
            console.log('Emit typing event')
        },
        editMessage(message){
            const m = this.messageList.find(m=>m.id === message.id);
            m.isEdited = true;
            m.data.text = message.data.text;
        }
    }
}
</script>

