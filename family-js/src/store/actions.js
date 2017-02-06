import * as types from './mutation-types'
import Keycloak from 'keycloak-js';

export default {
  checkUserIsLogin({commit, state}) {
    if(state.auth.loggedIn) {
      var keycloakAuth = new Keycloak('keycloak.json');
      keycloakAuth.init({ onLoad: 'login-required' }).success(function () {
        commit(types.CHECK_USER_IS_LOGIN, keycloakAuth)
      }).error(function () {
        alert("failed to login");
      });
    }
  }
};
