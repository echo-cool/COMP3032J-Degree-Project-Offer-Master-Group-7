import request from '@/utils/request'
import { getToken } from '@/utils/auth'

// export function getProgramList(page, size, sort) {
//   return request({
//     url: `/rest/programs/${page}/${size}/${sort}`,
//     method: 'post'
//   })
// }

export function getPrograms(schoolID) {
  return request({
    url: '/backend/rest/schools/' + schoolID + '/programs',
    method: 'get',
    headers: {
      'Authorization': getToken()
    }
  })
}

export function fetchList(query) {
  console.log(query)
  return request({
    url: '/backend/rest/programs',
    method: 'get',
    headers: {
      'Authorization': getToken()
    }
    // params: query
  })
}

export function deleteSchool(programID) {
  console.log(programID)
  return request({
    url: 'backend/rest/programs/' + programID,
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

export function createProgram(data) {
  console.log(data)
  return request({
    url: '/backend/rest/programs',
    method: 'post',
    data,
    headers: {
      'Authorization': getToken()
    }
  })
}

export function updateProgram(data) {
  console.log(data)
  return request({
    url: '/backend/rest/programs/' + data.id,
    method: 'put',
    data: {
      'name': data.name
    },
    headers: {
      'Authorization': getToken()
    }
  })
}
