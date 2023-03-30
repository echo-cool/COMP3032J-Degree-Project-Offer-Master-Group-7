import request from "@/utils/request"

export default{

    // get top ranked schools using specific rank rule
    getTopRankedSchools(rankRule, limit){
        return request({
            url: `/api/school/public/get-top-ranked-schools/${rankRule}/${limit}`,
            method: 'get'
        })
    },

    getAllSchools() {
        return request(({
            url: `/api/school/public/getAllSchools`,
            method: 'get'
        }))
    },
    
    getById(id) {
        return request(({
            url: `/api/school/public/getById/${id}`,
            method: 'get'
        }))
    }
}
