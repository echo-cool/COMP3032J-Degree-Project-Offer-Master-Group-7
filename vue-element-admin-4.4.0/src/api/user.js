import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/backend/api/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
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
