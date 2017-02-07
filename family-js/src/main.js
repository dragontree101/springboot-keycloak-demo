import Vue from 'vue'
import App from './App.vue'
import VueResource from 'vue-resource';
// import VueRouter from 'vue-router';
import store from './store'
// import Keycloak from 'keycloak-js';

Vue.use(VueResource);
// Vue.use(VueRouter);

// const routes = [{
//   path : '/app',
//   component : App
// }];

// const router = new VueRouter({
//   routes
// });

// const keycloakAuth = new Keycloak('../keycloak.json');

// router.beforeEach((next) => {
//   console.log("*** here");
//   store.dispatch('checkUserIsLogin', keycloakAuth);
//   next
// })

new Vue({
  el: '#app',
  // router,
  store,
  render: h => h(App)
})
