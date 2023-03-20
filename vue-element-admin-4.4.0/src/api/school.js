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

export function createSchool(school) {
  console.log(school)
  return request({
    url: '/backend/api/school/create',
    method: 'post',
    data: school,
    headers: {
      'Authorization': getToken()
    }
  })
}

export function updateSchool(id, school) {
  console.log(school)
  return request({
    url: `/backend/api/school/update/${id}`,
    method: 'post',
    data: school,
    headers: {
      'Authorization': getToken()
    }
  })
}
export function pageSchoolListCondition(current, limit, schoolQueryVo) {
  return request({
    url: `/backend/api/school/condition-query/${current}/${limit}`,
    method: 'post',
    data: schoolQueryVo,
    headers: {
      'Authorization': getToken()
    }
  })
}

