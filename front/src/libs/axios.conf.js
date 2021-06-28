import axios from 'axios';

axios.defaults.baseURL = "";

// 请求超时时间
axios.defaults.timeout = 100000;

// post请求头
//axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';
axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8';

// 响应拦截器
axios.interceptors.response.use(
    response => {
        if (response.status >= 200 && response.status < 300) {
            return Promise.resolve(response);
        } else {
            debugger;
            return Promise.reject(response);
        }
    },

    error => {

        //如果有 response
        if (error.response) {

            var errorStr = JSON.stringify(error.response);
            console.error(errorStr);

            var data;
            //如果有 response.data.code 说明是业务代码返回的结果，直接使用
            if (error.response.data && typeof (error.response.data.error) != "undefined") {
                data = error.response.data;
            } else if (error.response.data) { //如果没有 response.data.error， 只有 response.data，则将整个 data 作为 message
                data = {};
                data.message = JSON.stringify(error.response.data);
                data.code = -1;
                data.error = 1;
            }

            // 如果没有获取到 data，则将整个 error 作为 message
            if (!data) {
                data = {};
                data.message = JSON.stringify(error);
                data.code = -1;
                data.error = 1;
            }

            //如果 message 太长，只保留前 200 个字符，其它的打在控制台
            if (data.message && data.message.length > 200) {
                console.error(data.message);
                data.message = data.message.substring(0, 200);
            }

            return Promise.reject(data);

        } else {  //如果没有 response，可能网络错误或超时

            var errorStr = JSON.stringify(error);
            console.error(errorStr);

            var data = {};
            if (error.message) {
                data.message = error.message;
                !!error.status && (data.message = data.message + ", status:" + error.status);
            } else {
                data.message = errorStr;
            }

            if (data.message && data.message.length > 200) {
                console.error(data.message);
                data.message = data.message.substring(0, 200);
            }

            data.code = -1;
            data.error = 1;

            return Promise.reject(data);
        }
    }
);

const http = {
    //post 方式调用， obj 为一个对象，后端用 json 方式将 obj 接收到一个对象中
    async post(url, obj) {
        return new Promise((resolve, reject) => {
            axios.post(url, obj)
                .then(res => {
                    resolve(res.data);
                })
                .catch(err => {
                    alert(err.message);
                })
        });
    },

    // post 方式调用， params 为键值对，后端用参数方式将 params 中的各个值接收到若干个变量中
    async postParams(url, params) {
        return new Promise((resolve, reject) => {
            axios.post(url, Qs.stringify(params),
                {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                })
                .then(res => {
                    resolve(res.data);
                })
                .catch(err => {
                    alert(err.message);
                })
        });
    },

    async put(url, obj) {
        return new Promise((resolve, reject) => {
            axios.put(url, obj)
                .then(res => {
                    resolve(res.data);
                })
                .catch(err => {
                    alert(err.message);
                })
        });
    },

    async putParams(url, params) {
        return new Promise((resolve, reject) => {
            axios.put(url, Qs.stringify(params),
                {
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                })
                .then(res => {
                    resolve(res.data);
                })
                .catch(err => {
                    alert(err.message);
                })
        });
    },

    async get(url, params) {
        return new Promise((resolve, reject) => {
            axios.get(url, {
                params: params
            })
                .then(res => {
                    resolve(res.data);
                })
                .catch(err => {
                    alert(err.message);
                })
        });
    },

    async delParams(url, params) {
        return new Promise((resolve, reject) => {
            axios.delete(url, {
                params: params
            })
                .then(res => {
                    resolve(res.data);
                })
                .catch(err => {
                    alert(err.message);
                })
        });
    },
};

export default http;
