import * as types from './mutation-types'
import Keycloak from 'keycloak-js';

export default {
  [types.CHECK_USER_IS_LOGIN] (state) {
    if(!state.auth.loggedIn) {
      var keycloakAuth = new Keycloak('keycloak.json');
      keycloakAuth.init({ onLoad: 'login-required' }).success(function () {
        state.auth.loggedIn = true;
        state.auth.authz = keycloakAuth;
        state.auth.logoutUrl = keycloakAuth.authServerUrl + "/realms/" + keycloakAuth.realm + "/protocol/openid-connect/logout?redirect_uri=http://localhost:8089/index.html"
      }).error(function () {
        alert("failed to login");
      });
    }
  }
};
