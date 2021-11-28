import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../layout/Layout.vue'

const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect:"home",
    children:[
      {
        path: 'home',
        name: 'Home',
        component: ()=> import("../views/Home"),
      },
      {
        path: 'now',
        name: 'Now',
        component: ()=> import("../views/Now"),
      }
    ]
  },
  {
    path: '/login',
    name: 'Login ',
    component: () => import("../views/Login")
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
