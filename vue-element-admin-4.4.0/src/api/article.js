import request from '@/utils/request'

export function fetchList(query) {
  console.log(query)
  return request({
    url: '/backend/rest/users',
    method: 'get'
    // params: query
  })
}

// export function deleteUser(username) {
//   // eslint-disable-next-line no-unused-vars
//   console.log(username)
//   request({
//     url: 'backend/rest/users/search/findByUsername',
//     method: 'get',
//     params: { 'username': username }
//   }).then(response => {
//     const userID = response['_links']['self']['href'].split('/').pop()
//     console.log(userID)
//     return request({
//       url: 'backend/rest/users/' + userID,
//       method: 'delete'
//       // params: query
//     })
//   })
// }

export function deleteUser(userID) {
  console.log(userID)
  return request({
    url: 'backend/rest/users/' + userID,
    method: 'delete'
    // params: query
  })
}

export function fetchArticle(id) {
  return request({
    url: '/vue-element-admin/article/detail',
    method: 'get',
    params: { id }
  })
}

export function fetchPv(pv) {
  return request({
    url: '/vue-element-admin/article/pv',
    method: 'get',
    params: { pv }
  })
}

export function createArticle(data) {
  return request({
    url: '/vue-element-admin/article/create',
    method: 'post',
    data
  })
}

export function updateArticle(data) {
  return request({
    url: '/vue-element-admin/article/update',
    method: 'post',
    data
  })
}
