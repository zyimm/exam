import axios from 'axios'
import config from '@/config'
import store from '@/store'
import ViewUI from 'view-design'
import router from '@/router'
import Auth from "./auth";

const baseUrl = config.getBaseUrl();

const http = {

    response: {},

    isSuccess: false,

    getUrl: function (api) {
        return baseUrl + api;
    },
    getAccessToken: function () {

        if (!store.state.token) {
            Auth.getToken();
        }
        return store.state.token;
    },
    /**
     * get
     *
     * @param api
     * @param data
     * @returns {Promise<unknown>}
     */
    get: function (api, data = {}) {
        return this.request(this.getUrl(api), 'get', {}, data);
    },

    /**
     * post
     *
     * @param api
     * @param data
     * @returns {Promise<unknown>}
     */
    post: function (api, data = {}) {
        return this.request(this.getUrl(api), 'post', data);
    },

    /**
     * patch
     *
     * @param api
     * @param data
     * @returns {Promise<unknown>}
     */
    patch: function (api, data = {}) {
        return this.request(this.getUrl(api), 'patch', data);
    },

    /**
     * request
     *
     * @param url
     * @param method
     * @param data
     * @param params
     * @returns {Promise<unknown>}
     */
    request: async function (url, method, data = {}, params = {}) {
        //console.log('请求参数:',params, data);

        return await axios({
            url: url,
            method,
            data,
            params,
            headers: {'Authorization': 'Bearer ' + this.getAccessToken()}
        }).catch(e => {
            console.log(e);
            throw new Error('网络异常:' + e)
        }).then(res => {
            console.log('请求返回:', res);
            return this.handleResponse(res.data);
        });
    },
    handleResponse(response) {
        if (response.error_code !== 0) {
            this.isSuccess = false;
            ViewUI.Message.error(response.error_msg);
            if (response.error_code === 302) {
                Auth.removeCookie();
                router.push({
                    path: 'login'
                });
            }
        } else {
            this.isSuccess = true;
        }
        this.response = response;
        return this.response;
    }

};


export default http