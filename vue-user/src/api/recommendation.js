import request from "@/utils/request"

export function getRecommendedProgramsByKNN() {
    return request({
        url: `/api/recommendation/program-recommendation-knn`,
        method: 'get'
    })
}

export function getRecommendedProgramsByCF() {
    return request({
        url: `/api/recommendation/program-recommendation-cf`,
        method: 'get'
    })
}