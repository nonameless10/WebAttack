import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import qs from 'qs'
import global from './components/Global'
import xss from 'xss'

// 引入核心组件
import ElementUI from 'element-ui'
// 引入依赖的样式
import 'element-ui/lib/theme-chalk/index.css'

import VueDOMPurifyHTML from 'vue-dompurify-html'
Vue.use(VueDOMPurifyHTML)

Vue.use(ElementUI)
Vue.prototype.$qs = qs
Vue.prototype.$global = global
Vue.config.productionTip = false

Object.defineProperty(Vue.prototype, '$xss', {
  value: xss
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
