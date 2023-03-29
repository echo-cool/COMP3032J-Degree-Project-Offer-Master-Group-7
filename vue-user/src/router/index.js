import {createRouter, createWebHistory} from 'vue-router'

import Login from '../views/auth/Login.vue'
import Signup from '../views/auth/Signup.vue'
import EditProfilePage from '../views/user/EditProfilePage.vue'
import ProgramSelection from "@/views/SchoolPrograms/ProgramSelection.vue";
import HomePage from "@/views/HomePage.vue";
import SchoolDetails from "@/views/Schools/SchoolDetails.vue";
import SchoolDetailsTestMap from "@/views/Schools/SchoolDetailsTestMap.vue";
import About from '../views/About'
import Explore from "@/views/Explore/Explore";
import Community from "@/views/Community/Community";
import PostDetails from "@/views/Community/PostDetails";
import CreatePost from "@/views/Community/CreatePost";

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

    // ------------------------------ school & program ------------------------------
    {
        path: '/school-details/:id',
        name: 'SchoolDetails',
        component: SchoolDetails,
        meta: {
            title: 'School Details || OfferMaster',
        },
    },
    {
        path: '/school-details-test-map/:id',
        name: 'SchoolDetailsTestMap',
        component: SchoolDetailsTestMap,
        meta: {
            title: 'School Details Test Map || OfferMaster',
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
    {
        path: '/explore',
        name: 'Explore',
        component: Explore,
        meta: {
            title: 'Explore || OfferMaster',
        },
    },
    {
        path: '/community',
        name: 'Community',
        component: Community,
        meta: {
            title: 'Community || OfferMaster',
        },
    },
    {
        path: '/post-details/:id',
        name: 'PostDetails',
        component: PostDetails,
        meta: {
            title: 'Post Details || OfferMaster',
        },
    },
    {
        path: '/create-post',
        name: 'CreatePost',
        component: CreatePost,
        meta: {
            title: 'Create Post || OfferMaster',
        },
    }
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
