import {createApp} from 'vue'
import App from './App.vue'
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
const cors = require('cors')
axios.defaults.headers.get['Access-Control-Allow-Origin'] = '*'
let app = createApp(App)
app.use(router)
app.mount('#app')
