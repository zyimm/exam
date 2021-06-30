import Vue from 'vue';
import ViewUI from 'view-design';
import VueRouter from 'vue-router';
import router from './router';
import App from './app.vue';
import 'view-design/dist/styles/iview.css';
import animated from 'animate.css';
import http from './libs/http';
import store from './store';

import Api from './api';
import Auth from './libs/auth';


Vue.use(VueRouter);
Vue.use(ViewUI);
Vue.use(animated);


Vue.prototype.$http = http;

Vue.prototype.$api = Api;

Vue.prototype.$auth = Auth;

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
