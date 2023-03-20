import request from '@/utils/request'
import { getToken } from '@/utils/auth'

export function getApplications(schoolID) {
  return request({
    url: '/backend/rest/users/' + schoolID + '/applications',
    method: 'get',
    headers: {
      'Authorization': getToken()
    }
  })
}

export function deleteApplication(applicationID) {
  return request({
    url: 'backend/rest/applications/' + applicationID,
    method: 'delete',
    headers: {
      'Authorization': getToken()
    }
    // params: query
  })
}

export function createApplication(data) {
  console.log(data)
  return request({
    url: '/backend/rest/applications',
    method: 'post',
    data,
    headers: {
      'Authorization': getToken()
    }
  })
}

export function updateApplication(data) {
  console.log(data)
  return request({
    url: '/backend/rest/applications/' + data.id,
    method: 'put',
    data: {
      'user': data['_links']['user']['href'],
      'program': data['_links']['program']['href'],
      'degree': data.degree,
      'e_status': data.eStatus
    },
    headers: {
      'Authorization': getToken()
    }
  })
}

// export function addProgramToSchool(links, schoolID) {
//   request({
//     url: '/backend/rest/schools/' + schoolID,
//     method: 'patch',
//     headers: {
//       'Authorization': getToken()
//     },
//     data: {
//       'programs': links
//     }
//   })
// }

export function fetchPv(pv) {
  return request({
    url: '/vue-element-admin/article/pv',
    method: 'get',
    params: { pv }
  })
}

export function getApplicationUser(applicationID) {
  return request({
    url: '/backend/rest/schools/' + applicationID,
    method: 'get',
    headers: {
      'Authorization': getToken()
    }
  })
}
