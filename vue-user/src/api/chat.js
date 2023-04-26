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
    }
}
