import Cookies from 'js-cookie';
import Store from '@/store';
import http from "./http";
import api from "../api";

const TOKEN_KEY = 'token';

const USER_KEY = 'user';


class Auth {

    cookieExpires = 1;

    constructor(cookieExpires) {
        if(cookieExpires){
            this.cookieExpires = cookieExpires;
        }
    }

    getToken = () => {
        const token = Cookies.get(TOKEN_KEY);
        if (token) {
            Store.commit('setUserToken', token);
            return token;
        } else {
            return false
        }
    }

    
    setToken = (token) => {
        Cookies.set(TOKEN_KEY, token, {expires: this.cookieExpires || 1});
        Store.commit('setUserToken', token);
    }

    setUserInfo = (data) => {
        Cookies.set(USER_KEY, data, {expires: this.cookieExpires || 1});
        Store.commit('setUserInfo', data);

    }

    getUserInfo = () => {
        let info = Cookies.get(USER_KEY);
        info = JSON.parse(info);
        Store.commit('setUserInfo', info);
        return info;
    }

    /**
     * 初始化
     *
     * @param token
     * @returns {Promise<string>}
     */
    initUserInfo = (token) => {
        this.setToken(token);
        return http.get(api.userInfo).then(r=>{
            this.setUserInfo(JSON.stringify(r.result));
            return '/';
        })
    }

    /**
     * loginOut
     *
     * @returns {Promise<unknown>}
     */
    loginOut() {
        return http.post(api.userLoginOut).then(response => {
            if(response){
                console.log("remove cookie");
                this.removeCookie();
            }
        });
    }

    /**
     *  removeCookie
     *
     * @returns {boolean}
     */
    removeCookie() {
        let arr = [TOKEN_KEY, USER_KEY];
        for (let i in arr) {
            Cookies.remove(arr[i]);
        }
        return true;
    }
}

export default new Auth();