import request from "@/utils/request"

export default{
    getInfoById(id1, id2) {
        return request({
          url: `/api/chat/getInfoById/${id1}/${id2}`,
          method: 'get',
        })
    },
    sendChat(tmp) {
        return request({
          url: `/api/chat/sendChat`,
          method: 'post',
          data: tmp,
        })
    },
    getReceiverInfo(id) {
        return request({
          url: `/api/chat/getReceiverInfo/${id}`,
          method: 'get',
        })
    },
    getChatInfoById(id1, id2) {
        return request({
          url: `/api/chat/getChatInfoById/${id1}/${id2}`,
          method: 'get',
        })
    },
    getRelativeChatMember(id) {
        return request({
          url: '/api/chat/getRelativeChatMember/' + id,
          method: 'get',
        })
    }
    
}
