<template>
  <div id="app">
    <family></family>
  </div>
</template>

<script>
  import Family from './components/Family.vue'
  import Keycloak from 'keycloak-js';

  var auth = {};

  export default {
    name: 'app',
    components: {
      Family
    },
    created: function () {
      var keycloak = new Keycloak('keycloak.json');
      auth.loggedIn = false;

      keycloak.init({ onLoad: 'login-required' }).success(function () {
        console.log('here login');
        auth.loggedIn = true;
        auth.authz = keycloakAuth;
        auth.logoutUrl = keycloakAuth.authServerUrl + "/realms/" + keycloakAuth.realm + "/protocol/openid-connect/logout?redirect_uri=http://localhost:8089/index.html"
      }).error(function () {
        alert("failed to login");
      });
    }
  }
</script>

