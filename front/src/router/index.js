
import VueRouter from 'vue-router'
import index from '../views/index'
import login from "../views/login"
import ViewUI from 'view-design'
import Store from '../store'
import Auth from '../libs/auth'

// Vue.use(ViewUI);
// Vue.use(VueRouter)

const LOGIN_PAGE_NAME = 'login';

const routes = [
    {
        path: '/',
        name: '/',
        redirect: '/personal-space',
        component: index,
        children: [

            {
                path: '/personal-space',
                name: 'personal-space',
                title: "个人空间",
                meta:{
                    title:'个人空间'
                },
                component: () => import('../views/personal')
            },

            {
                path: '/exam-capsule',
                name: 'exam-capsule',
                title: "题库管理",
                meta:{
                    title:'题库管理'
                },
                component: () => import('../views/examCapsule')
            },

            {
                path: '/exam-manage',
                name: 'exam-manage',
                title: "考试管理",
                meta:{
                    title:'考试管理'
                },
                component: () => import('../views/examManage')
            },

            {
                path: '/user-manage',
                name: 'user-manage',
                title: "用户管理",
                meta:{
                    title:'用户管理'
                },
                component: () => import('../views/users')
            },

        ]
    },
    {
        path: '/login',
        name: 'login',
        component: login
    }
]

const router = new VueRouter({
    mode: 'history',
    //base: process.env.BASE_URL,
    routes
});



const getCrumb = function (path, route) {
    let crumb = [];
    for (let index in route) {
        if (route[index].path != path) {
            if (route[index].children) {
                getCrumb(path, route[index].children);
            }
        } else {
            crumb.push(route[index]);
        }
    }
    crumb.unshift({
        title: '主页',
        path: null
    })
    return crumb;
}

router.beforeEach((to, from, next) => {
    ViewUI.LoadingBar.start();
    const User = Auth;
    const token = User.getToken();
    if (!token && to.name !== LOGIN_PAGE_NAME) {
        // 未登录且要跳转的页面不是登录页
        next({
            name: LOGIN_PAGE_NAME // 跳转到登录页
        })
    }

    if (token && to.name === LOGIN_PAGE_NAME) {
        // 已登录且要跳转的页面是登录页
        next({
            // 跳转到homeName页
            name: '/'
        })
    }
    Store.commit('updateCrumb', getCrumb(to.path, routes[0].children));
    next();

})

router.afterEach(route => {
    console.log(route.name);
    ViewUI.LoadingBar.finish();
});


export default router
