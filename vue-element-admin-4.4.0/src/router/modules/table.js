/** When your routing table is too long, you can split it into small modules **/

import Layout from '@/layout'

const tableRouter = {
  path: '/table',
  component: Layout,
  redirect: '/table/complex-table',
  name: 'Management',
  meta: {
    title: 'Management',
    icon: 'table'
  },
  children: [
    // {
    //   path: 'dynamic-table',
    //   component: () => import('@/views/table/dynamic-table/index'),
    //   name: 'DynamicTable',
    //   meta: { title: 'Dynamic Table' }
    // },
    // {
    //   path: 'drag-table',
    //   component: () => import('@/views/table/drag-table'),
    //   name: 'DragTable',
    //   meta: { title: 'Drag Table' }
    // },
    // {
    //   path: 'inline-edit-table',
    //   component: () => import('@/views/table/inline-edit-table'),
    //   name: 'InlineEditTable',
    //   meta: { title: 'Inline Edit' }
    // },
    {
      path: 'user',
      component: () => import('@/views/table/user'),
      name: 'User',
      meta: { title: 'User' }
    },
    {
      path: 'school',
      component: () => import('@/views/table/school'),
      name: 'School',
      meta: { title: 'School' }
    },
    {
      path: 'program/:id',
      component: () => import('@/views/table/program'),
      name: 'Program',
      meta: { title: 'Program' },
      hidden: true
    },
    {
      path: 'application/:id',
      component: () => import('@/views/table/application'),
      name: 'Application',
      meta: { title: 'Application' },
      hidden: true
    }
  ]
}
export default tableRouter
