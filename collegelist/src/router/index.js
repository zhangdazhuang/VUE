import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path:'/welcome',    // path 跳转地址 //新增的测试
    name:'Welcome',     //路由的名称
    component: () => import('../views/Welcome.vue') //引入的组件
 }
 ,
 {
   path:'/test',   /* 新增的测试1 页面嵌套子路由 */
   name:'Test',
   component: () => import('../views/Test.vue'),
   children:[
    {
      path:'/h1',
      name:'H1',
      component:()=>import('../components/Test.vue')
    },
    {
      path:'/h2',
      name:'H2',
      component:()=>import('../components/Welcome.vue')
    }
   ]
}

]

const router = new VueRouter({
  routes
})

export default router
