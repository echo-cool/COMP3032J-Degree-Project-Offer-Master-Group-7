import request from "@/utils/request"

export default{

    // for submitting the login form
    login(form){
        return request({
            url: `/api/login`,
            method: 'post',
            data: form
        })
    },

    // for getting the logged-in user info by their token
    getUserInfoByToken(){
        return request({
            url: `/api/getUserInfo`,
            method: "get"
        })
    }
}