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

export function getPost(postID) {
    return request({
        url: `/api/post/getPost/` + postID,
        method: 'get'
    })
}

export function getPostsByCategory(category) {
    return request({
        url: `/api/post/getPostsByCategory/` + category,
        method: 'get'
    })
}
