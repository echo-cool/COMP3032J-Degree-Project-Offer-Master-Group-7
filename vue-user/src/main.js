//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖保佑             永无BUG
//          佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？
import {createApp} from 'vue'
import App from './App.vue'
import Vue from 'vue'
import router from './router'
import 'animate.css'
import './assets/css/feature.css'
import './assets/scss/style.scss'
import 'bootstrap'
import axios from "axios";
import Loading from 'vue3-loading-screen'
// import VueGoogleMaps from '@fawmi/vue-google-maps'
import $ from 'jquery'
// createApp(App).use(router).use(VueGoogleMaps, {
//     load: {
//         key: 'AIzaSyDJ7ELJuZaigtiB50_buOhvcjyGvOTk5MY',
//     },
// }).mount('#app')
// import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
/* import the fontawesome core */
import { library } from '@fortawesome/fontawesome-svg-core'

/* import font awesome icon component */
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

/* import specific icons */
import { faUserSecret } from '@fortawesome/free-solid-svg-icons'


/* add icons to the library */
library.add(faUserSecret)

// Import Bootstrap and BootstrapVue CSS files (order is important)
// import 'bootstrap/dist/css/bootstrap.css'
// import 'bootstrap-vue/dist/bootstrap-vue.css'


const cors = require('cors')
axios.defaults.headers.get['Access-Control-Allow-Origin'] = '*'
let app = createApp(App)
app.component('font-awesome-icon', FontAwesomeIcon)


// Make BootstrapVue available throughout your project
// app.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
// app.use(IconsPlugin)
app.use(router)
// app.use(Loading, {
//     bg: '#41b883ad',
//     slot: `
//     <div class="px-5 py-3 bg-gray-800 rounded">
//       <h1 class="text-3xl text-white"><i class="fas fa-spinner fa-spin"></i> Loading...</h1>
//     </div>
//   `
// })

import Chat from 'vue-beautiful-chat'
Vue.use(Chat)

import VueFileAgent from 'vue-file-agent';
import VueFileAgentStyles from 'vue-file-agent/dist/vue-file-agent.css';
app.use(VueFileAgent);

import Paginate from "vuejs-paginate-next";
app.use(Paginate);

// import APlayer from '@moefe/vue-aplayer';
//
// app.use(APlayer, {
//     defaultCover: 'https://github.com/u3u.png', // set the default cover
//     productionTip: false, // disable console output
// });

app.mount('#app')
