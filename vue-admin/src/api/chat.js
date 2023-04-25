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

