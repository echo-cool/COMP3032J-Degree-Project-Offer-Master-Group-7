import {createRouter, createWebHistory} from 'vue-router'

import Login from '../views/auth/Login.vue'
import Signup from '../views/auth/Signup.vue'
import EditProfilePage from '../views/user/EditProfilePage.vue'
import ProgramSelection from "@/views/SchoolPrograms/ProgramSelection.vue";
import HomePage from "@/views/HomePage.vue";
import About from '../views/About'

const routes = [
    {
        path: '/',
        name: 'HomePageOne',
        component: HomePage,
        meta: {
            title: 'OfferMaster',
        },
    },

    // ------------------------------ auth ------------------------------
    {
        path: '/login',
        name: 'Login',
        component: Login,
        meta: {
            title: 'Login || OfferMaster',
        },
    },
    {
        path: '/sign-up',
        name: 'Signup',
        component: Signup,
        meta: {
            title: 'Signup || OfferMaster',
        },
    },

    // ------------------------------ user ------------------------------
    {
        path: '/edit-profile',
        name: 'EditProfilePage',
        component: EditProfilePage,
        meta: {
            title: 'Personal Profile || OfferMaster',
        },
    },

    // ------------------------------ school & program ------------------------------
    {
        path: '/program-selection',
        name: 'ProgramSelection',
        component: ProgramSelection,
        meta: {
            title: 'Program Selection || OfferMaster',
        },
    },
    {
        path: '/about',
        name: 'About',
        component: About,
        meta: {
            title: 'About || OfferMaster',
        },
    },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

router.beforeEach((to, from, next) => {
    document.title = to.meta.title;
    next();
    window.scrollTo(0, 0)
});

export default router
