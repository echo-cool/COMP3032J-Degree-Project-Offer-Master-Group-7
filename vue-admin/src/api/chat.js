import request from '@/utils/request'
import { getToken } from '@/utils/auth'

export function getRelativeChat(name) {
  return request({
    url: '/backend/api/chat/getList/' + name,
    method: 'get',
    headers: {
      'Authorization': getToken()
    }
  })
}

export function getChatInfo(id) {
  return request({
    url: '/backend/api/chat/getChatInfo/' + id,
    method: 'get',
    headers: {
      'Authorization': getToken()
    }
  })
}

export function getInfo(name, id) {
  return request({
    url: `/backend/api/chat/getInfo/${name}/${id}`,
    method: 'get',
    headers: {
      'Authorization': getToken()
    }
  })
}

export function sendChat(tmp) {
  return request({
    url: `/backend/api/chat/sendChat`,
    method: 'post',
    data: tmp,
    headers: {
      'Authorization': getToken()
    }
  })
}
