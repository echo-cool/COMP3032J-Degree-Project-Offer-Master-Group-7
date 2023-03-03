import request from '@/utils/request'
import { getToken } from '@/utils/auth'

export function getRoutes() {
  return request({
    url: '/vue-element-admin/routes',
    method: 'get'
  })
}

export function getRoles(userList) {
  for (let i = 0; i < userList.length; i++) {
    const user = userList[i]
    user['roles'] = []
    request({
      url: '/backend/rest/users/' + user['id'] + '/roles',
      method: 'get',
      headers: {
        'Authorization': getToken()
      }
    }).then(roleResponse => {
      const roles = roleResponse['_embedded']['roles']
      for (const index in roles) {
        user['roles'].push(roles[index]['name'])
      }
    })
  }
}

export function addRole(data) {
  return request({
    url: '/vue-element-admin/role',
    method: 'post',
    data
  })
}

export function updateRole(id, data) {
  return request({
    url: `/vue-element-admin/role/${id}`,
    method: 'put',
    data
  })
}

export function deleteRole(id) {
  return request({
    url: `/vue-element-admin/role/${id}`,
    method: 'delete'
  })
}
