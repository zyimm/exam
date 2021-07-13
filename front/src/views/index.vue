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
                <Menu theme="dark" width="auto" :class="menuitemClasses" :active-name=activeMenu>
                    <MenuItem v-for="(menu,menuIndex) in menuList" :key="menuIndex" :name=menu.name :to=menu.to>
                        <Icon :type="menu.icon"/>
                        <span>{{menu.title}}</span>
                    </MenuItem>
                </Menu>
            </Sider>
            <Layout ref="sideRight" :class="sideClass">
                <Header class="layout-header-bar" :class="headerStyle" ref="layoutHeaderBar">
                    <Row>
                        <Col span="1">
                            <Icon @click.native="collapsedSider" :class="rotateIcon" :style="{margin: '0 20px'}"
                                  type="md-menu" size="24"></Icon>
                        </Col>
                        <Col span="18">
                            <Breadcrumb>
                                <BreadcrumbItem v-for="(item,index) in this.$store.state.crumb" :key="index"
                                                :to="item.path">
                                    {{item.title}}
                                </BreadcrumbItem>
                            </Breadcrumb>
                        </Col>
                        <Col span="5">
                            <div class="user-name">
                                <Dropdown>
                                    <a href="javascript:void(0)">
                                        {{this.$store.state.userInfo.name}}
                                        <Icon type="ios-arrow-down"></Icon>
                                    </a>
                                    <DropdownMenu slot="list">
                                        <DropdownItem @click.native="signOut">退出登录</DropdownItem>
                                    </DropdownMenu>
                                </Dropdown>
                            </div>
                            <div class="user-notifications">
                                <Badge class="user-notifications-badge">
                                    <Icon class="user-notifications-badge-icon" type="md-notifications-outline"/>
                                    <sup class="ivu-badge-dot"></sup>
                                </Badge>

                            </div>
                            <div class="user-avatar">
                                <Avatar icon="ios-person" :src="this.$store.state.userInfo.avatar"
                                        size="large"/>
                            </div>
                            <div class="full-screen">
                                <full-screen v-model="isFullscreen"/>
                            </div>
                        </Col>
                    </Row>
                </Header>
                <div class="tag-nav-wrapper">
                    <tags-nav :value="$route" @input="handleClick" :list="this.$store.state.tagNavList"
                              @on-close="handleCloseTag"/>
                    <div class="clear-fix"></div>
                </div>
                <Content class="content-wrapper ivu-layout-content sys-content">
                    <keep-alive>
                        <router-view v-if="$route.meta.keepAlive"></router-view>
                    </keep-alive>
                    <router-view v-if="!$route.meta.keepAlive"></router-view>
                </Content>
            </Layout>
        </Layout>
    </div>
</template>
<script>
    import menu from "@/store/menu";
    import TagsNav from '@/components/tags-nav'
    import FullScreen from '@/components/full-screen'
    import {mapMutations} from 'vuex'
    import {routeEqual} from '@/libs/util'

    export default {
        name: "personal-space",
        components: {
            TagsNav,
            FullScreen
        },
        data() {
            return {
                isCollapsed: false,
                collapsedWidth: 78,
                activeMenu: this.$route.name,
                isFullscreen: false,
                tagNavWrapper: {
                    marginTop: "58px"
                }
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
            sysLogo() {
                return [
                    'sys-logo',
                    this.isCollapsed ? 'sys-logo-transition' : ''
                ];
            },
            menuList() {
                return menu;
            },
            headerStyle() {
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
                if (this.isCollapsed) {
                    this.headerStyle.left = this.collapsedWidth + 'px';
                } else {
                    this.headerStyle.left = 200 + 'px';
                }

            },
            signOut() {
                this.$Message.loading({
                    content: '退出登陆中...',
                    duration: 1
                })
                this.$store.commit('loginOut');
            },
            handleCloseTag(res, type, route) {
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
            turnToPage(route) {
                let {name, params, query} = {}
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
                if (this.$route.name !== name) {
                    this.$router.push({
                        name,
                        params,
                        query
                    })
                }

            },
            handleClick: function (item) {
                this.turnToPage(item)
            },
            fixedSideRightHeight: function () {
                let bodyHeight = document.body.clientHeight;
                this.$refs.sideRight.$el.style.height = bodyHeight + 'px'
            }

        },
        beforeCreate() {
            this.$store.commit('setUserInfo', this.$auth.getUserInfo());
            //初始化tag nav
            this.$store.commit('getTagNavList');
        },
        watch: {
            '$route'(newRoute) {
                const {name, query, params, meta} = newRoute
                this.addTag({
                    route: {name, query, params, meta},
                    type: 'push'
                })
                this.activeMenu = this.$route.name
            }
        },
        mounted() {
            this.$nextTick(() => { // 页面渲染完成后的回调
                this.fixedSideRightHeight()
            })
        }
    }
</script>