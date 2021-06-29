import Vue from 'vue'
import Vuex from 'vuex'
import Auth from "../libs/auth";

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        crumb: [],
        userInfo: {},
        token: ''
    },
    mutations: {
        updateCrumb(state, data = []) {
            state.crumb = data;
        },
        setUserInfo(state, data = {}) {
            state.userInfo = data;
        },
        async loginOut(state, data = {}) {
            let User = new Auth();
            await  User.loginOut();
            state.userInfo = {}
        },
        setUserToken: function (state, data = '') {
            state.token = data;
        }
    },
    actions: {

    },
    modules: {}
})
