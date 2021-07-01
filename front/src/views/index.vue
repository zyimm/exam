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
                <Menu theme="dark" width="auto" :class="menuitemClasses" :active-name=activeMenu >
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
                <Content>
                    <div class="sys-content ivu-layout-content">
                        <div class="tag-nav-wrapper">
                            <tags-nav :value="$route"  @input="handleClick" :list="this.$store.state.tagNavList" @on-close="handleCloseTag"/>
                        </div>

                        <div class="content-wrapper"><router-view/></div>

                    </div>
                </Content>

            </Layout>
        </Layout>
        <Footer class="layout-footer-center"><strong>@CopyRight</strong> https://www.zyimm.com 2013~2021</Footer>
    </div>
</template>
<script>
    import menu from "@/store/menu";
    import TagsNav from '@/components/tags-nav'
    import { mapMutations} from 'vuex'
    import { routeEqual } from '@/libs/util'

    export default {
        name: "index",
        components: {
            TagsNav
        },
        data() {
            return {
                isCollapsed: false,
                collapsedWidth: 78,
                activeMenu:this.$route.name
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
            ...mapMutations([
                'addTag',
                'closeTag',
                'setTagNavList'

            ]),
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
            },
            handleCloseTag (res, type, route) {
                if (type !== 'others') {
                    if (type === 'all') {
                        this.turnToPage(this.$config.homeName)
                    } else {
                        if (routeEqual(this.$route, route)) {
                            this.closeTag(route)
                        }
                    }
                }
                this.setTagNavList(res)
            },
            turnToPage (route) {
                let { name, params, query } = {}
                if (typeof route === 'string') {
                    name = route
                } else {
                    name = route.name
                    params = route.params
                    query = route.query
                }
                if (name.indexOf('isTurnByHref_') > -1) {
                    window.open(name.split('_')[1])
                    return
                }
                this.$router.push({
                    name,
                    params,
                    query
                })
            },
            handleClick:function (item) {
                this.turnToPage(item)
            }

        },
        beforeCreate() {
            this.$store.commit('setUserInfo', this.$auth.getUserInfo());
            //初始化tag nav
            this.$store.commit('getTagNavList');

        },
        watch: {
            '$route' (newRoute) {
                const { name, query, params, meta } = newRoute
                this.addTag({
                    route: { name, query, params, meta },
                    type: 'push'
                })
                this.activeMenu = this.$route.name
            }
        }
    }
</script>