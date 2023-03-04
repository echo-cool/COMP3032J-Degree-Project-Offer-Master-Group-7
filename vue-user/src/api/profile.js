import request from "@/utils/request"

export default{

    // for uploading avatar
    uploadAvatar(form){
        return request({
            url: `/user/uploadAvatar`,
            method: 'post',
            headers: {
                'Content-Type': 'multipart/form-data'
            },
            data: form
        })
    }

}