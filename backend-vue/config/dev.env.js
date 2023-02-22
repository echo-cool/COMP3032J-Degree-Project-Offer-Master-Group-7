'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  BASE_API: '"http://localhost:8080/"',
  OSS_PATH: ' "https://qintong-edu.oss-cn-beijing.aliyuncs.com"'
})
