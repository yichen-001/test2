import Vue from 'vue'
import VueRouter from 'vue-router'

import Hello from '../components/HelloWorld.vue'
import FlinkChart from '../components/FlinkChart.vue'
import Dashboard from '../components/Dashboard'
import Wholepage from '../components/wholepage.vue'

Vue.use(VueRouter)

export default new VueRouter({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/flink-chart',
      name: 'FlinkChart',
      component: FlinkChart
    },
    {
      path: '/dashboard',
      name: 'Dashboard',
      component: Dashboard
    },
    {
      path: '/wholepage',
      name: 'Wholepage',
      component: Wholepage
    }
  ]
})