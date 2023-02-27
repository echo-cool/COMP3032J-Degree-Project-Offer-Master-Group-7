import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/backend/api/login',
    method: 'post',
    data: {
      "loginName": username,
      "password": password
    }
  })
}

export function getInfo(token) {
  return request({
    url: '/backend/secure/user',
    method: 'get',
    headers: {"Authorization": token}
  })
}

export function logout() {
  return request({
    url: '/admin/user/logout',
    method: 'post'
  })
}


