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
    getInfo(name, id) {
        return request({
          url: `/api/chat/getInfo/${name}/${id}`,
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
    getChatInfoById(id1, id2) {
        return request({
          url: `/api/chat/getChatInfoById/${id1}/${id2}`,
          method: 'get',
        })
      }
    
}
