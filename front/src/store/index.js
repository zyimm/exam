import Vue from 'vue'
import Vuex from 'vuex'
import Auth from '../libs/auth'
import Config from '../config'
import router from '@/router'
import {setTagNavListInLocalstorage ,getNextRoute, getTagNavListFromLocalstorage, routeEqual} from '../libs/util'

Vue.use(Vuex);

const closePage = (state, route) => {
    const nextRoute = getNextRoute(state.tagNavList, route)
    state.tagNavList = state.tagNavList.filter(item => {
        return !routeEqual(item, route)
    })

    if(Object.keys(nextRoute).length > 0){
        router.push(nextRoute)
    }else{
        router.push({
            path:'/'
        });
    }
}


export default new Vuex.Store({
    state: {
        crumb: [],
        userInfo: {},
        token: '',
        tagNavList:[]
    },
    mutations: {
        updateCrumb(state, data = []) {
            state.crumb = data;
        },
        setUserInfo(state, data = {}) {
            state.userInfo = data;
        },
        async loginOut(state) {
            await  Auth.loginOut();
            state.userInfo = {}
        },
        setUserToken: function (state, data = '') {
            state.token = data;
        },
        addTag:function (state, { route, type = 'unshift' }) {
            let router = route;
            for(let i in state.tagNavList){
                if(state.tagNavList[i].name === route.name){
                    return
                }
            }
            if (type === 'push') {
                state.tagNavList.push(router)
            } else {
                if (router.name === Config.homeName) {
                    state.tagNavList.unshift(router)
                } else {
                    state.tagNavList.splice(1, 0, router)
                }
            }
            setTagNavListInLocalstorage(state.tagNavList);
        },
        closeTag:function(state, route){
            let tags = state.tagNavList.filter(item => routeEqual(item, route))
            console.log(route, tags.length)
            closePage(state, route)
        },
        getTagNavList:function(state){
            state.tagNavList = getTagNavListFromLocalstorage()
            if(state.tagNavList.length <= 0){
                state.tagNavList = [
                    {
                        name:"personal-space",
                        meta:{
                            title:'个人空间'
                        }
                    }
                ];
            }
        },
        setTagNavList:function (state, routes) {
            state.tagNavList = routes;
            setTagNavListInLocalstorage(state.tagNavList);
        }
    },
    actions: {

    },
    modules: {}
})
