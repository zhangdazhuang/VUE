//main.js在渲染的时候会被webpack引入变成app.js文件
// webpack打包资源时候的起点。
// 该文件可以包含需要依赖的资源，供项目使用。
// 告诉打包好的资源，最后挂载到哪里
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// import http from '@/api/config.js'

// import ElementUI from 'element-ui';
// import 'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false

// Vue.use(ElementUI)
// Vue.prototype.$http = http

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
