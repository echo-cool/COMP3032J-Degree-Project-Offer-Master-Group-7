import request from "@/utils/request"

export default{

    // get top ranked schools using specific rank rule
    getTopRankedSchools(rankRule, limit){
        return request({
            url: `/api/school/get-top-ranked-schools/${rankRule}/${limit}`,
            method: 'get'
        })
    }

}
