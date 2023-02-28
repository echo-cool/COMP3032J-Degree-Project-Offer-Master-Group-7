import request from '@/request/index'

export default {
    getUserById(userId) {
        return request({
            url: `/rest/users/${userId}`,
            method: 'get'
        })
    }
}
