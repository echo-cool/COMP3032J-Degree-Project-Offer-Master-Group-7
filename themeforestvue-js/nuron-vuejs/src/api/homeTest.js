import request from '@/request/index'

export default {
  testGetUser(page, size) {
    return request({
      url: `/rest/users`,
      method: 'get',
      params: {page, size}
    })
  }
}

export function login(data) {
  return request({
    url: '/vue-element-admin/user/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/vue-element-admin/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/vue-element-admin/user/logout',
    method: 'post'
  })
}
