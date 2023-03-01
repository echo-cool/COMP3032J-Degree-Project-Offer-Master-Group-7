import request from '@/utils/request'

export default {
    getUserById(userId) {
        return request({
            url: `/rest/users/${userId}`,
            method: 'get'
        })
    }
}
