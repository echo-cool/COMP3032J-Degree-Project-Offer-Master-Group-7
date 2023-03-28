import request from "@/utils/request"

export function getAllPosts(){
    return request({
        url: `/api/post/public/getAllPosts`,
        method: 'get'
    })
}

export function getAllCategories() {
    return request({
        url: `/api/post/public/getAllCategories`,
        method: 'get'
    })
}
