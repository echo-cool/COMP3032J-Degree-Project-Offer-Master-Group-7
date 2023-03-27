import request from "@/utils/request"

export default{

    // get top popular programs by degree
    getPopularPrograms(degree, limit){
        return request({
            url: `/api/program/public/get-popular-programs/${degree}/${limit}`,
            method: 'get'
        })
    },

    // get programs by a query obj (likes, degree, major, ...)
    getProgramsByQuery(queryObj, limit){
        return request({
            url: `/api/program/public/get-programs-by-query/${limit}`,
            method: 'post',
            data: queryObj
        })
    },

    // like a program
    likeProgram(programId){
        return request({
            url: `/api/program/like-program/${programId}`,
            method: 'post'
        })
    }
}
