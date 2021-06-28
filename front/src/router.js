const routers = [
    {
        path: '/',
        meta: {
            title: ''
        },
        component: (resolve) => require(['./views/index.vue'], resolve)
    },

    {
        path: '/query',
        meta: {
            title: '查询'
        },
        component: (resolve) => require(['./views/query.vue'], resolve)
    }
];
export default routers;
