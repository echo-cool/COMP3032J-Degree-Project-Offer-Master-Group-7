import request from "@/utils/request"

export default{

    // for submitting the register form
    register(form){
        return request({
            url: `/api/register`,
            method: 'post',
            data: form
        })
    }

}