<style scoped src="../assets/style/index.css"></style>

<template>
    <div class="layout">
        <Layout>
            <Sider ref="side" hide-trigger collapsible :collapsed-width="collapsedWidth"
                   v-model="isCollapsed"
                   :style="{position:'fixed',height: '100vh', left: 0, overflow: 'auto'}">
                <div :class="sysLogo">
                    <strong class="sys-logo-red">Exam.</strong>
                    <strong class="sys-logo-blue">Capsule</strong>

                   <div> 
                        <strong class="sys-logo-red">Exam</strong>
                    </div>

                </div>
                <Menu theme="dark" width="auto" :class="menuitemClasses">
                    <MenuItem v-for="(menu,menuIndex) in menuList" :key="menuIndex" :name=menu.name :to=menu.to>
                        <Icon :type="menu.icon"/>
                        <span>{{menu.title}}</span>
                    </MenuItem>
                </Menu>
            </Sider>
            <Layout ref="side-right" :class="sideClass">
                <Header class="layout-header-bar" :class="headerStyle">
                    <Row>
                        <Col span="1">
                            <Icon @click.native="collapsedSider" :class="rotateIcon" :style="{margin: '0 20px'}"
                                  type="md-menu" size="24"></Icon>
                        </Col>
                        <Col span="19">
                            <Breadcrumb>
                                <BreadcrumbItem v-for="(item,index) in this.$store.state.crumb" :key="index"
                                                :to="item.path">
                                    {{item.title}}
                                </BreadcrumbItem>
                            </Breadcrumb>
                        </Col>
                        <Col span="4">
                            <Row>
                                <Col span="6" offset="8">
                                    <Avatar icon="ios-person" :src="this.$store.state.userInfo.avatar"
                                            size="large"/>
                                </Col>
                                <Col span="10">
                                    <Dropdown class="user-name">
                                        <a href="javascript:void(0)" >
                                            {{this.$store.state.userInfo.name}}
                                            <Icon type="ios-arrow-down"></Icon>
                                        </a>
                                        <DropdownMenu slot="list">
                                            <DropdownItem @click.native="signOut">退出登录</DropdownItem>
                                        </DropdownMenu>
                                    </Dropdown>
                                </Col>
                            </Row>
                        </Col>
                    </Row>
                </Header>

                <div class="sys-content">
                    <router-view/>
                </div>
            </Layout>
        </Layout>
        <Footer class="layout-footer-center"><strong>@CopyRight</strong> https://www.zyimm.com 2013~2021</Footer>
    </div>
</template>
<script>
    import menu from "@/store/menu";
    import Auth from "@/libs/auth";

    export default {
        name: "index",
        data() {
            return {
                isCollapsed: false,
                collapsedWidth: 78
            }
        },
        computed: {
            rotateIcon() {
                return [
                    'menu-icon',
                    this.isCollapsed ? 'rotate-icon' : ''
                ];
            },
            sideClass() {
                return !this.isCollapsed ? ['side-left'] : ['side-left-act'];
            },
            menuitemClasses() {
                return [
                    'menu-item',
                    this.isCollapsed ? 'collapsed-menu' : ''
                ]
            },
            sysLogo(){
                return [
                    'sys-logo',
                    this.isCollapsed ? 'sys-logo-transition' : ''
                ];
            },
            menuList() {
                return menu;
            },
            headerStyle(){
                return [
                    'header-style',
                    this.isCollapsed ? 'header-style-act' : ''
                ];
            }
        },
        methods: {
            collapsedSider() {
                this.$refs.side.toggleCollapse();
                if(this.isCollapsed){
                    this.headerStyle.left =  this.collapsedWidth + 'px';
                }else{
                    this.headerStyle.left = 200 + 'px';
                }

            },
            async signOut() {
                await this.$store.commit('loginOut');
                this.$router.push({
                    path: '/login'
                });
            }
        },
        beforeCreate() {
            this.$store.commit('setUserInfo', (new Auth()).getUserInfo());
        },
        watch: {}
    }
</script>