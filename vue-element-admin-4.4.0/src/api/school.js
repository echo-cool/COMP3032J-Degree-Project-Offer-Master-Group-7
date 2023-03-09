import request from '@/utils/request'
import { getToken } from '@/utils/auth'

export function fetchList(query) {
  return request({
    url: '/backend/rest/schools',
    method: 'get',
    headers: {
      'Authorization': getToken()
    },
    params: {
      'page': query['page'] - 1,
      'size': query['size']
    }
  })
}

export function deleteSchool(schoolID) {
  console.log(schoolID)
  return request({
    url: 'backend/rest/schools/' + schoolID,
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

export function createSchool(data) {
  console.log(data)
  return request({
    url: '/backend/rest/schools',
    method: 'post',
    data,
    headers: {
      'Authorization': getToken()
    }
  })
}

export function updateSchool(data) {
  console.log(data)
  return request({
    url: '/backend/rest/schools/' + data.id,
    method: 'put',
    data: {
      'name': data.name
    },
    headers: {
      'Authorization': getToken()
    }
  })
}
