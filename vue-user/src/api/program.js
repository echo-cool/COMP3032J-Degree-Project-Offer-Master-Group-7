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
    getProgramsByQuery(queryObj, limit, current){
        return request({
            url: `/api/program/public/get-programs-by-query/${limit}/${current}`,
            method: 'post',
            data: queryObj
        })
    },

    getAllPrograms() {
        return request(({
            url: `/api/program/public/getAllPrograms`,
            method: 'get'
        }))
    },

    // like a program
    likeProgram(programId){
        return request({
            url: `/api/program/like-program/${programId}`,
            method: 'post'
        })
    },

    getProgramById(programId){
        return request({
            url: `/api/program/public/getById/${programId}`,
            method: 'get'
        })
    },

    // whether the user liked a specific program
    isProgramLiked(programId){
        return request({
            url: `/api/program/is-program-liked/${programId}`,
            method: 'get'
        })
    },

    // for Offer-Timeline
    getWeeklyAdmissionCountByProgramId(programId){
        return request({
            url: `/api/program/public/get-weekly-ad-count/${programId}`,
            method: 'get'
        })
    },

    getAverageBackground(programId) {
        return request({
            url: `/api/program/public/getAverageMetricByProgramId/${programId}`,
            method: 'get'
        })
    }
}
