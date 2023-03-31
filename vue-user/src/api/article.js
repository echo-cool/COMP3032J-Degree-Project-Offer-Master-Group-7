import request from "@/utils/request"

export default{
    getById(id) {
        return request(({
            url: `/api/article/public/getById/${id}`,
            method: 'get'
        }))
    },
    getByUserId(id) {
        return request(({
            url: `/api/article/public/getByUserId/${id}`,
            method: 'get'
        }))
    }
}
