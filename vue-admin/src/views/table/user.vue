<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input v-model="listQuery.username" placeholder="Username" style="width: 200px;" class="filter-item" @keyup.enter.native="handleFilter" />
      <!--      <el-input v-model="listQuery.password" placeholder="Password" style="width: 200px;" class="filter-item" @keyup.enter.native="handleFilter" />-->
      <el-input v-model="listQuery.email" placeholder="Email" style="width: 200px;" class="filter-item" @keyup.enter.native="handleFilter" />
      <!--      <el-select v-model="listQuery.roles" placeholder="Role" clearable style="width: 90px" class="filter-item">-->
      <!--        <el-option v-for="item in roles" :key="item" :label="item" :value="item" />-->
      <!--      </el-select>-->
      <!--      <el-select v-model="listQuery.type" placeholder="Type" clearable class="filter-item" style="width: 130px">-->
      <!--        <el-option v-for="item in calendarTypeOptions" :key="item.key" :label="item.display_name+'('+item.key+')'" :value="item.key" />-->
      <!--      </el-select>-->
      <el-select v-model="listQuery.sort" style="width: 140px" class="filter-item" @change="handleFilter">
        <el-option v-for="item in sortOptions" :key="item.key" :label="item.label" :value="item.key" />
      </el-select>
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
        Search
      </el-button>
      <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-edit" @click="handleCreate">
        Add
      </el-button>
      <el-button v-waves :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download" @click="handleDownload">
        Export
      </el-button>
    </div>

    <el-table
      :key="tableKey"
      v-loading="listLoading"
      :data="list"
      border
      fit
      highlight-current-row
      style="width: 100%;"
      @sort-change="sortChange"
    >
      <el-table-column label="Username" width="150px" align="center">
        <template slot-scope="{row}">
          <span>{{ row.username }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Created At" width="150px" align="center">
        <template slot-scope="{row}">
          <span>{{ row.createdAt | parseTime('{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Password" width="150px">
        <template slot-scope="{row}">
          <!--          <span class="link-type" @click="handleUpdate(row)">{{ row.title }}</span>-->
          <span>{{ row.password }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Role" width="180px" align="center">
        <template slot-scope="{row}">
          <el-tag v-for="role in row.roles" :key="role">{{ role }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="Email" width="110px" align="center">
        <template slot-scope="{row}">
          <span>{{ row.email }}</span>
        </template>
      </el-table-column>
      <!--      <el-table-column v-if="showReviewer" label="Reviewer" width="110px" align="center">-->
      <!--        <template slot-scope="{row}">-->
      <!--          <span style="color:red;">{{ row.reviewer }}</span>-->
      <!--        </template>-->
      <!--      </el-table-column>-->
      <!--      <el-table-column label="Imp" width="80px">-->
      <!--        <template slot-scope="{row}">-->
      <!--          <svg-icon v-for="n in + row.importance" :key="n" icon-class="star" class="meta-item__icon" />-->
      <!--        </template>-->
      <!--      </el-table-column>-->
      <!--      <el-table-column label="Readings" align="center" width="95">-->
      <!--        <template slot-scope="{row}">-->
      <!--          <span v-if="row.pageviews" class="link-type" @click="handleFetchPv(row.pageviews)">{{ row.pageviews }}</span>-->
      <!--          <span v-else>0</span>-->
      <!--        </template>-->
      <!--      </el-table-column>-->
      <!--      <el-table-column label="Status" class-name="status-col" width="100">-->
      <!--        <template slot-scope="{row}">-->
      <!--          <el-tag :type="row.status | statusFilter">-->
      <!--            {{ row.status }}-->
      <!--          </el-tag>-->
      <!--        </template>-->
      <!--      </el-table-column>-->
      <el-table-column label="Actions" align="center" min-width="230" class-name="small-padding fixed-width">
        <template slot-scope="{row,$index}">
          <router-link class="rl" :to="'/table/application/' + row.id">
            <el-button type="primary" size="mini">
              Applications
            </el-button>
          </router-link>

          <el-button type="primary" size="mini" @click="handleUpdate(row)">
            Edit
          </el-button>
          <el-button size="mini" type="danger" @click="handleDelete(row,$index)">
            Delete
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.size" @pagination="getList" />

    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form ref="dataForm" :rules="rules" :model="temp" label-position="left" label-width="100px" style="width: 400px; margin-left:50px;">
        <el-form-item label="Username" prop="username">
          <el-input v-model="temp.username" />
        </el-form-item>
        <el-form-item label="Password" prop="password">
          <el-input v-model="temp.password" />
        </el-form-item>
        <el-form-item label="Email" prop="email">
          <el-input v-model="temp.email" />
        </el-form-item>
        <el-form-item label="Role" prop="roles">
          <el-checkbox-group v-model="temp.roles" class="filter-item" placeholder="Please select">
            <el-checkbox v-for="item in roles" :key="item" :label="item" :value="item">{{ item }}</el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <!--        <el-form-item label="Date" prop="timestamp">-->
        <!--          <el-date-picker v-model="temp.timestamp" type="datetime" placeholder="Please pick a date" />-->
        <!--        </el-form-item>-->
        <!--        <el-form-item label="Title" prop="title">-->
        <!--          <el-input v-model="temp.title" />-->
        <!--        </el-form-item>-->
        <!--        <el-form-item label="Status">-->
        <!--          <el-select v-model="temp.status" class="filter-item" placeholder="Please select">-->
        <!--            <el-option v-for="item in statusOptions" :key="item" :label="item" :value="item" />-->
        <!--          </el-select>-->
        <!--        </el-form-item>-->
        <!--        <el-form-item label="Imp">-->
        <!--          <el-rate v-model="temp.importance" :colors="['#99A9BF', '#F7BA2A', '#FF9900']" :max="3" style="margin-top:8px;" />-->
        <!--        </el-form-item>-->
        <!--        <el-form-item label="Remark">-->
        <!--          <el-input v-model="temp.remark" :autosize="{ minRows: 2, maxRows: 4}" type="textarea" placeholder="Please input" />-->
        <!--        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">
          Cancel
        </el-button>
        <el-button type="primary" @click="dialogStatus==='create'?createData():updateData()">
          Confirm
        </el-button>
      </div>
    </el-dialog>

    <el-dialog :visible.sync="dialogPvVisible" title="Reading statistics">
      <el-table :data="pvData" border fit highlight-current-row style="width: 100%">
        <el-table-column prop="key" label="Channel" />
        <el-table-column prop="pv" label="Pv" />
      </el-table>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogPvVisible = false">Confirm</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { fetchPv, deleteUser, createUser, updateUser, pageUserListCondition } from '@/api/article'
import waves from '@/directive/waves' // waves directive
import Pagination from '@/components/Pagination'
// secondary package based on el-pagination

const calendarTypeOptions = [
  { key: 'CN', display_name: 'China' },
  { key: 'US', display_name: 'USA' },
  { key: 'JP', display_name: 'Japan' },
  { key: 'EU', display_name: 'Eurozone' }
]

// arr to obj, such as { CN : "China", US : "USA" }
const calendarTypeKeyValue = calendarTypeOptions.reduce((acc, cur) => {
  acc[cur.key] = cur.display_name
  return acc
}, {})

export default {
  name: 'User',
  components: { Pagination },
  directives: { waves },
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'info',
        deleted: 'danger'
      }
      return statusMap[status]
    },
    typeFilter(type) {
      return calendarTypeKeyValue[type]
    }
  },
  data() {
    return {
      tableKey: 0,
      list: null,
      total: 0,
      listLoading: true,
      listQuery: {
        page: 1,
        size: 20,
        username: '',
        // password: undefined,
        email: '',
        // roles: undefined,
        sort: 'username,asc'
      },
      roles: ['ROLE_USER', 'ROLE_ADMIN', 'ROLE_MODERATOR'],
      calendarTypeOptions,
      sortOptions: [{ label: 'Username Ascending', key: 'username,asc' }, { label: 'Username Descending', key: 'username,desc' }],
      statusOptions: ['published', 'draft', 'deleted'],
      showReviewer: false,
      temp: {
        username: '',
        password: '',
        // createdAt: new Date(),
        email: '',
        roles: []
      },
      dialogFormVisible: false,
      dialogStatus: '',
      textMap: {
        update: 'Edit',
        create: 'Create'
      },
      dialogPvVisible: false,
      pvData: [],
      rules: {
        username: [{ required: true, message: 'username is required', trigger: 'blur' }],
        password: [{ required: true, message: 'password is required', trigger: 'blur' }],
        email: [{ required: true, message: 'email is required', trigger: 'blur' }],
        roles: [{ required: true, message: 'role is required', trigger: 'change' }]
      },
      downloadLoading: false,
      roleMap: {},
      roleLinkMap: {}
    }
  },
  created() {
    this.getList()
    // this.getRoleMap()
  },
  methods: {
    getList() {
      this.listLoading = true

      console.log(this.listQuery)
      const userQuery = {}
      userQuery.username = this.listQuery.username
      userQuery.email = this.listQuery.email
      userQuery.sort = this.listQuery.sort !== 'username,desc'

      this.listLoading = true
      pageUserListCondition(this.listQuery.page, this.listQuery.size, userQuery)
        .then(response => {
          this.list = response.data.data.content
          this.total = response['data']['data']['totalElements']

          for (let i = 0; i < this.list.length; i++) {
            const user = this.list[i]
            user['roles'] = this.roleToName(user)
          }

          this.listLoading = false
        })
        .catch(error => {
          console.log(error)
        })
      // fetchList(this.listQuery).then(response => {
      //   this.list = response['_embedded']['users']
      //   this.total = response['page']['totalElements']
      //
      //   // eslint-disable-next-line no-unused-vars
      //   let finished = 0
      //
      //   for (let i = 0; i < this.list.length; i++) {
      //     const user = this.list[i]
      //     user['roles'] = []
      //     getRoles(user['id']).then(roleResponse => {
      //       const roles = roleResponse['_embedded']['roles']
      //       for (const index in roles) {
      //         user['roles'].push(roles[index]['name'])
      //       }
      //       if (finished === this.list.length - 1) {
      //         this.listLoading = false
      //         this.tableKey += 1
      //       } else {
      //         finished += 1
      //       }
      //     })
      //   }

      // Just to simulate the time of the request
      // setTimeout(() => {
      //   this.listLoading = false
      //   this.tableKey = 1
      // }, 1.5 * 1000)
      // })
    },
    // getRoleMap() {
    //   getAllRoles().then(response => {
    //     const roles = response['_embedded']['roles']
    //     for (let i = 0; i < roles.length; i++) {
    //       const role = roles[i]
    //       this.roleMap[role['name']] = role['_links']['self']['href']
    //       this.roleLinkMap[role['_links']['self']['href']] = role['name']
    //     }
    //   })
    // },
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    handleModifyStatus(row, status) {
      this.$message({
        message: '操作Success',
        type: 'success'
      })
      row.status = status
    },
    sortChange(data) {
      const { prop, order } = data
      if (prop === 'id') {
        this.sortByID(order)
      }
    },
    sortByID(order) {
      if (order === 'ascending') {
        this.listQuery.sort = 'id,asc'
      } else {
        this.listQuery.sort = 'id,desc'
      }
      this.handleFilter()
    },
    resetTemp() {
      this.temp = {
        username: '',
        password: '',
        // createdAt: new Date(),
        email: '',
        roles: []
      }
    },
    handleCreate() {
      this.resetTemp()
      this.dialogStatus = 'create'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    roleToName(user) {
      const roleNames = []
      const userRoles = user['roles']
      for (let i = 0; i < userRoles.length; i++) {
        roleNames.push(userRoles[i]['name'])
      }
      return roleNames
    },
    // linkToRole(roleLinks) {
    //   const roleNames = []
    //   for (let i = 0; i < roleLinks.length; i++) {
    //     roleNames.push(this.roleLinkMap[roleLinks[i]])
    //   }
    //   return roleNames
    // },
    createData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          createUser(this.temp).then(response => {
            this.temp.id = response['data']['data']['id']
            this.temp.createdAt = response['data']['data']['createdAt']
            this.temp.roles = this.roleToName(response['data']['data'])
            this.list.unshift(this.temp)
            this.dialogFormVisible = false
            this.$notify({
              title: 'Success',
              message: 'Created Successfully',
              type: 'success',
              duration: 2000
            })
          })
        }
      })
    },
    handleUpdate(row) {
      this.temp = Object.assign({}, row) // copy obj
      // this.temp.timestamp = new Date(this.temp.timestamp)
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    updateData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          // const tempData = Object.assign({}, this.temp)
          // tempData.timestamp = +new Date(tempData.timestamp) // change Thu Nov 30 2017 16:41:05 GMT+0800 (CST) to 1512031311464
          updateUser(this.temp).then(response => {
            const index = this.list.findIndex(v => v.id === this.temp.id)
            this.temp.roles = this.roleToName(response['data']['data'])

            this.temp.password = response['data']['data']['password']
            this.list.splice(index, 1, this.temp)
            this.dialogFormVisible = false
            this.$notify({
              title: 'Success',
              message: 'Update Successfully',
              type: 'success',
              duration: 2000
            })
          })
        }
      })
    },
    handleDelete(row, index) {
      deleteUser(row.id)
      this.$notify({
        title: 'Success',
        message: 'Delete Successfully',
        type: 'success',
        duration: 2000
      })
      this.list.splice(index, 1)
    },
    handleFetchPv(pv) {
      fetchPv(pv).then(response => {
        this.pvData = response.data.pvData
        this.dialogPvVisible = true
      })
    },
    handleDownload() {
      this.downloadLoading = true
      import('@/vendor/Export2Excel').then(excel => {
        const tHeader = ['Username', 'Created At', 'Password', 'Role', 'Email']
        const filterVal = ['username', 'createdAt', 'password', 'roles', 'email']
        const data = this.formatJson(filterVal)
        excel.export_json_to_excel({
          header: tHeader,
          data,
          filename: 'table-list'
        })
        this.downloadLoading = false
      })
    },
    formatJson(filterVal) {
      return this.list.map(v => filterVal.map(j => {
        return v[j]
      }))
    },
    getSortClass: function(key) {
      const sort = this.listQuery.sort
      return sort === `+${key}` ? 'ascending' : 'descending'
    }
  }
}
</script>
