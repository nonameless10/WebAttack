import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import("../views/Home"),
    redirect: '/sql',
    children: [
      {
        path: '/sql',
        component: () => import("../views/SQL")
      },
      {
        path: '/xss',
        component: () => import("../views/XSS")
      },
      {
        path: '/upload-file',
        component: () => import("../views/UploadFile")
      },
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
