import request from '@/utils/request'
import { getToken } from '@/utils/auth'

export function getBasicInfo() {
  return request({
    url: '/backend/api/dashboard/getBasicInfo',
    method: 'get',
    headers: {
      'Authorization': getToken()
    }
  })
}
