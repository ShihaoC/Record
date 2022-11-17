import Vue from 'vue'
import VueRouter from 'vue-router'
import loginView from '@/views/login'
import manageView from '@/views/RecordManage'
import EmployeeManage from "@/views/EmployeeManage";
import test from '../views/test'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'login',
        component: loginView,
        meta: {
            title: '登录',
            keepAlive: true
        }
    },
    {
        path: '/manage',
        name: 'manage',
        component: manageView,
        meta: {
            title: '管理',
            keepAlive: false
        },
    }, {
        path: '/EmployeeManage',
        name: 'EmployeeManage',
        component: EmployeeManage,
        meta: {
            title: '员工管理',
            keepAlive: false
        }
    },
    {
        path: "/test",
        name: "test",
        component: test
    }

]


const router = new VueRouter({
    routes
})


export default router


router.beforeEach((to, from, next) => {
    if (to.meta.title) {
        document.title = to.meta.title
    }
    next();
})