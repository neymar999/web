import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus';
import 'element-plus/theme-chalk/index.css';
import zhCn from 'element-plus/es/locale/lang/zh-cn'

import './assets/css/global.css'

createApp(App).use(store).use(router).use(ElementPlus,{locale: zhCn,size:'small'}).mount('#app')
