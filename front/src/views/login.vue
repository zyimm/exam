<style scoped>
    .login {
        width: 100%;
        height: 100%;
        background-size: cover;
        background-position: center;
        position: fixed;
        background-image: url("http://img.zyimm.com/img/bg.6b2b7a05.jpg");
    }

    .login-con {

        width: 360px;
        margin: 10% auto;

    }

    .login-tip {
        font-size: 10px;
        text-align: center;
        color: #c3c3c3;
    }
</style>

<template>
    <div class="login">
        <div class="login-con">
            <Card icon="log-in" title="欢迎登录">
                <Form ref="loginForm" :model="form" :rules="rules" @keydown.enter.native="handleSubmit">
                    <FormItem prop="userName">
                        <label>
                            <Input v-model="form.account" placeholder="请输入用户名">
                                    <span slot="prepend">
                                      <Icon :size="16" type="ios-person"></Icon>
                                    </span>
                            </Input>
                        </label>
                    </FormItem>
                    <FormItem prop="password">
                        <label>
                            <Input type="password" v-model="form.password" placeholder="请输入密码">
                                    <span slot="prepend">
                                      <Icon :size="14" type="md-lock"></Icon>
                                    </span>
                            </Input>
                        </label>
                    </FormItem>
                    <FormItem>
                        <Button @click="handleSubmit" type="primary" long>登录</Button>
                    </FormItem>
                </Form>
                <p class="login-tip">请输入用户名和密码登录</p>
                <div class="clear-both"></div>
            </Card>
        </div>
        <div class="clear-both"></div>
    </div>


</template>

<script>


    export default {
        data() {
            return {
                form: {
                    account: 'zyimm',
                    password: null
                },
                accountRules: [
                    {
                        required: true, message: '账号不能为空', trigger: 'blur'
                    }
                ],
                passwordRules: [
                    {
                        required: true, message: '密码不能为空', trigger: 'blur'
                    }
                ]
            }
        },
        computed: {
            rules() {
                return {
                    email: this.emailRules,
                    password: this.passwordRules
                }
            }
        },
        methods: {
            handleSubmit() {
                this.$refs.loginForm.validate((valid) => {
                    if (valid) {
                        this.$Message.loading({
                            content: '正在登陆中...',
                            duration: 1
                        })
                        this.$http.post(this.$api.userLogin, this.form).then(response => {
                            console.log(response)
                            let result = response.result;
                            if (result.accessToken) {
                                let user = this.$auth;
                                user.initUserInfo(result.accessToken).then(result => {
                                    this.$router.push({path: result})
                                });

                            }
                        });

                    }
                });
            }
        }
    }
</script>
