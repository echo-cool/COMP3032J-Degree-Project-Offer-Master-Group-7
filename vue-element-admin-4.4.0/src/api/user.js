import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/backend/api/auth/signin',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  console.log(token)
  return request({
    url: '/backend/secure/getUser',
    method: 'get',
    headers: {
      'Authorization': token
    }
  })
}

export function logout() {
  return request({
    url: '/vue-element-admin/user/logout',
    method: 'post'
  })
}
