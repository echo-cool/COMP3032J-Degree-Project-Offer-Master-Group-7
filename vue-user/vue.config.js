module.exports = {
    chainWebpack: (config) => {
        config.resolve.alias.set('vue', '@vue/compat')

        config.module
            .rule('vue')
            .use('vue-loader')
            .tap((options) => {
                return {
                    ...options,
                    compilerOptions: {
                        compatConfig: {
                            MODE: 2
                        }
                    }
                }
            })
    },
    // 选项...
    // devtool: 'eval-source-map',//开发调试
    devServer: {
        headers: {
            "Cache-Control": "no-cache, no-store, must-revalidate",
            "Access-Control-Allow-Origin": "*"
        },
        port: 8080,
        proxy:{
            '/backend': {//代理api
                target: "http://127.0.0.1:8080",//服务器api地址
                changeOrigin: true,//是否跨域
                pathRewrite: {//重写路径
                    "^/backend": ''
                }
            }
        }
    },

}
