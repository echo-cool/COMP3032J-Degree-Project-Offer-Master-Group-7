import request from "@/utils/request"

export default{

    // get top ranked schools using specific rank rule
    getPopularPrograms(degree, limit){
        return request({
            url: `/api/program/public/get-popular-programs/${degree}/${limit}`,
            method: 'get'
        })
    }

}
