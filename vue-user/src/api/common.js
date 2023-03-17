import request from "@/utils/request"

export default{

    // get a program, school, user, application, etc. by rest url "/rest/..."
    getByRestURL(url){
        return request({
            url: url,
            method: 'get'
        })
    }

}
