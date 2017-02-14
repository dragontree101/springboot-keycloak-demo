import * as types from './mutation-types'

export default {
  checkUserIsLogin({commit, state}, keycloakAuth) {
    // if(!state.auth.loggedIn) {
    //   console.log("1234");
    //
    //
    // keycloakAuth
    //
    // .init({ onLoad: 'login-required' })
    //
    //
    //
    //
    // .success(function () {
    //     console.log("-----------");
        commit(types.CHECK_USER_IS_LOGIN, keycloakAuth)
      // })
    //
    //
    //
    //
    // .error(function () {
      //   alert("failed to login");
      // });
    // }
  },

  userLogout({commit}) {
    commit(types.USER_LOGOUT)
  }
};
