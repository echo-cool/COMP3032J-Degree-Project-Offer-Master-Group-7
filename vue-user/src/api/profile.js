import request from "@/utils/request"

export default{

    // for uploading avatar
    uploadAvatar(form){
        return request({
            url: `/api/user/uploadAvatar`,
            method: 'post',
            headers: {
                'Content-Type': 'multipart/form-data'
            },
            data: form
        })
    },

    // for changing password
    changePassword(params) {
        return request({
            url: `/api/user/changePassword`,
            method: 'post',
            data: params
        })
    }

}