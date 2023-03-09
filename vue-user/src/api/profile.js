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
    },

    editPersonalInfo(params){
        return request({
            url: `/api/user/editPersonalInfo`,
            method: 'post',
            data: params
        })
    },

    editApplyBackground(params){
        return request({
            url: `/api/user/editApplicationBackground`,
            method: 'post',
            data: params
        })
    },

    // for get selected program list of this user
    getSelectedPrograms(){
        return request({
            url: `/api/user/getSelectedPrograms`,
            method: 'get',
        })
    }

}
