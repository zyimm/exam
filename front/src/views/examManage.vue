<template>
    <div>
        <Card style="margin: 10px 0">
            <Form ref="formInline" :model="examSearch"
                  :label-width="88"
                  label-position="right" :rules="ruleInline" inline>
                <FormItem label="考试名称:" prop="examName">
                    <Input type="text" v-model="examSearch.examName" placeholder="考试名称" clearable/>
                </FormItem>

                <FormItem label="考试类型:" prop="examType">
                    <Select v-model="examSearch.examType" filterable clearable>
                        <Option v-for="item in examSearch.examTypeMap" :value="item.key" :key="item.key">{{ item.name
                            }}
                        </Option>
                    </Select>
                </FormItem>

                <FormItem label="考试状态:" prop="examStatus">
                    <Select v-model="examSearch.examStatus" filterable clearable>
                        <Option v-for="item in examSearch.examStatusMap" :value="item.key" :key="item.key">{{ item.name
                            }}
                        </Option>
                    </Select>
                </FormItem>

                <FormItem label="考试时间:" prop="examTimeRange">
                    <DatePicker type="datetimerange" v-model="examSearch.examTimeRange"
                                format="yyyy-MM-dd"></DatePicker>
                </FormItem>
            </Form>
        </Card>

        <Card ref="tableWrapper">
            <div slot="title">
                <Button type="primary" icon="ios-add-circle-outline"> 新增题库</Button>
            </div>
            <div>
                <Scroll :height="tableHeight" >
                    <Table border :columns="columns" :data="rows"></Table>
                </Scroll>
            </div>

            <div>
                <Page :total="100" show-total show-sizer />
            </div>
        </Card>

    </div>
</template>
<script>
    export default {
        data() {
            return {
                name: "examManage",
                examSearch: {
                    examName: '',
                    examType: 0,
                    examStatus: 0,
                    examTypeMap: [
                        {
                            key: 1,
                            name: "司法考试"
                        }
                    ],
                    examStatusMap: [{
                        key: 1,
                        name: "进行中"
                    }],
                    examTimeRange: []
                },
                ruleInline: {
                    user: [
                        {required: true, message: 'Please fill in the user name', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: 'Please fill in the password.', trigger: 'blur'},
                        {
                            type: 'string',
                            min: 6,
                            message: 'The password length cannot be less than 6 bits',
                            trigger: 'blur'
                        }
                    ]
                },
                columns: [
                    {
                        title: 'Name',
                        key: 'name'
                    },
                    {
                        title: 'Age',
                        key: 'age',
                        width: 100
                    },
                    {
                        title: 'Province',
                        key: 'province',
                        width: 100
                    },
                    {
                        title: 'City',
                        key: 'city'
                    },
                    {
                        title: 'Address',
                        key: 'address'
                    },
                    {
                        title: 'Postcode',
                        key: 'zip',
                        width: 100
                    },
                    {
                        title: 'Action',
                        key: 'action',
                        render: (h, params) => {
                            console.log(params)
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'text',
                                        size: 'small'
                                    }
                                }, 'View'),
                                h('Button', {
                                    props: {
                                        type: 'text',
                                        size: 'small'
                                    }
                                }, 'Edit')
                            ]);
                        }
                    }
                ],
                rows: [
                    {
                        name: 'John Brown',
                        age: 18,
                        address: 'New York No. 1 Lake Park',
                        province: 'America',
                        city: 'New York',
                        zip: 100000
                    },
                    {
                        name: 'Jim Green',
                        age: 24,
                        address: 'Washington, D.C. No. 1 Lake Park',
                        province: 'America',
                        city: 'Washington, D.C.',
                        zip: 100000
                    },
                    {
                        name: 'Joe Black',
                        age: 30,
                        address: 'Sydney No. 1 Lake Park',
                        province: 'Australian',
                        city: 'Sydney',
                        zip: 100000
                    },
                    {
                        name: 'Jon Snow',
                        age: 26,
                        address: 'Ottawa No. 2 Lake Park',
                        province: 'Canada',
                        city: 'Ottawa',
                        zip: 100000
                    },
                    {
                        name: 'John Brown',
                        age: 18,
                        address: 'New York No. 1 Lake Park',
                        province: 'America',
                        city: 'New York',
                        zip: 100000
                    },
                    {
                        name: 'John Brown',
                        age: 18,
                        address: 'New York No. 1 Lake Park',
                        province: 'America',
                        city: 'New York',
                        zip: 100000
                    },
                    {
                        name: 'John Brown',
                        age: 18,
                        address: 'New York No. 1 Lake Park',
                        province: 'America',
                        city: 'New York',
                        zip: 100000
                    },
                    {
                        name: 'John Brown',
                        age: 18,
                        address: 'New York No. 1 Lake Park',
                        province: 'America',
                        city: 'New York',
                        zip: 100000
                    },
                    {
                        name: 'John Brown',
                        age: 18,
                        address: 'New York No. 1 Lake Park',
                        province: 'America',
                        city: 'New York',
                        zip: 100000
                    },
                    {
                        name: 'John Brown',
                        age: 18,
                        address: 'New York No. 1 Lake Park',
                        province: 'America',
                        city: 'New York',
                        zip: 100000
                    },
                    {
                        name: 'John Brown',
                        age: 18,
                        address: 'New York No. 1 Lake Park',
                        province: 'America',
                        city: 'New York',
                        zip: 100000
                    }
                ]
            }
        },
        computed: {
            tableHeight() {
                console.log(document.body.offsetHeight);
                return 320;
            }
        },
        methods: {
            handleSubmit(name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.$Message.success('Success!');
                    } else {
                        this.$Message.error('Fail!');
                    }
                })
            }
        }
    }
</script>


<style scoped>

</style>