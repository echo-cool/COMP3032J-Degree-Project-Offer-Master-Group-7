import request from '@/utils/request'
import { getToken } from '@/utils/auth'

export function fetchList(query) {
  return request({
    url: '/backend/rest/users',
    method: 'get',
    headers: {
      'Authorization': getToken()
    },
    params: {
      'page': query['page'],
      'size': query['size']
    }
    // params: {
    //   'page': query['page'] - 1,
    //   'size': query['size']
    // }
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
    method: 'delete',
    headers: {
      'Authorization': getToken()
    }
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

export function createUser(data, roleMap) {
  const roleLinks = []
  const roles = data['roles']
  for (let i = 0; i < roles.length; i++) {
    roleLinks.push(roleMap[roles[i]])
  }
  data['roles'] = roleLinks
  console.log(data)
  return request({
    url: '/backend/rest/users',
    method: 'post',
    data,
    headers: {
      'Authorization': getToken()
    }
  })
}

export function updateUser(data, roleMap) {
  const roleLinks = []
  const roles = data['roles']
  for (let i = 0; i < roles.length; i++) {
    roleLinks.push(roleMap[roles[i]])
  }
  data['roles'] = roleLinks
  console.log(data)
  return request({
    url: '/backend/rest/users/' + data.id,
    method: 'patch',
    data: {
      'username': data.username,
      'password': data.password,
      'email': data.email,
      'roles': data.roles
    },
    headers: {
      'Authorization': getToken()
    }
  })
}
