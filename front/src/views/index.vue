<style scoped lang="less">
    .index{
        width: 100%;
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        text-align: center;
        h1{
            height: 150px;
            img{
                height: 100%;
            }
        }
        h2{
            color: #666;
            margin-bottom: 200px;
            p{
                margin: 0 0 50px;
            }
        }
        .ivu-row-flex{
            height: 100%;
        }
    }
</style>
<template>
    <div class="index">
        <Row type="flex" justify="center" align="middle">
            <Col span="24">
                <h1>
                    <img src="../images/logo.png">
                </h1>
                <div>
                    <p>Welcome to your View UI app!</p>
                    <Button type="success" @click="successResult">模拟调用成功的情况</Button> <br/>
                    <br/>
                    调用成功时返回的数据结构如下, http 返回码为 2xx <br/>
                    <Input type="textarea" v-model="success_text" :rows="9" style="width:500px;">
                    </Input>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>

                    <Button type="error" @click="errorResult">模拟调用失败的情况</Button> <br/>
                    <br/>
                    <Input type="textarea" :rows="9" style="width:500px;" :value="error_text">
                    </Input>

                    <br/>
                    <br/>

                    <Button to="/query">to Query page</Button>
                </div>
            </Col>
        </Row>
    </div>
</template>
<script>

    export default {
        data: function () {

            return {
                success_text: "{\n" +
                    "  \"code\": 0,  //0 表示没有错误\n" +
                    "  \"data\": {\n" +
                    "\n" +
                    "  //业务结果放在 data 里面返回\n" +
                    "\n" +
                    "  },\n" +
                    "  \"message\": \"操作成功\"\n" +
                    "}",

                error_text: "调用失败时会自动弹窗显示错误信息并抛出异常，接口返回的数据在 exception 中获取，同时会打到浏览器控制台。\n" +
                    "http 返回码不为 2xx 时进入 error 处理"
            }
        },
        methods: {
            async successResult () {
                // this.$Modal.info({
                //     title: 'Bravo',
                //     content: 'Now, enjoy the convenience of View UI.'
                // });

                let res = await this.$http.post("https://keepapi.kuaizaixuetang.com/wx/share");

                this.success_text = JSON.stringify(res);

                alert(res.data.app_id);

            },

            async errorResult() {
                console.log(12);
            }
        }
    }
</script>
