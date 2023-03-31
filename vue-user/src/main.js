import {createApp} from 'vue'
import App from './App.vue'
import Vue from 'vue'
import router from './router'
import 'animate.css'
import './assets/css/feature.css'
import './assets/scss/style.scss'
import 'bootstrap'
import axios from "axios";
// import VueGoogleMaps from '@fawmi/vue-google-maps'

// createApp(App).use(router).use(VueGoogleMaps, {
//     load: {
//         key: 'AIzaSyDJ7ELJuZaigtiB50_buOhvcjyGvOTk5MY',
//     },
// }).mount('#app')
// import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

// Import Bootstrap and BootstrapVue CSS files (order is important)
// import 'bootstrap/dist/css/bootstrap.css'
// import 'bootstrap-vue/dist/bootstrap-vue.css'


const cors = require('cors')
axios.defaults.headers.get['Access-Control-Allow-Origin'] = '*'
let app = createApp(App)
// Make BootstrapVue available throughout your project
// app.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
// app.use(IconsPlugin)
app.use(router)
app.mount('#app')
