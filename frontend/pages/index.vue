<template>
  <div class="container">
    <div>
      <Logo />
      <h1 class="title">Firebase - Vue - Nuxtjs</h1>
      <div>
        <v-btn color="success" @click="createUser()"> createUser </v-btn>
      </div>
    </div>
  </div>
</template>

<script>
import handleError from "../din/handleError"
export default {
  mounted() {},
  methods: {
    async createUser() {
      try {
        await this.$fireAuth.createUserWithEmailAndPassword(
          "foo@foo.foo",
          "test"
        )
      } catch (e) {
        handleError.handleError(e)
      }
    },
    async onAuthStateChangedAction({ commit, dispatch }, { authUser, claims }) {
      if (!authUser) {
        await dispatch("cleanupAction")

        return
      }

      // you can request additional fields if they are optional (e.g. photoURL)
      const { uid, email, emailVerified, displayName, photoURL } = authUser

      commit("SET_USER", {
        uid,
        email,
        emailVerified,
        displayName,
        photoURL, // results in photoURL being undefined for server auth
        // use custom claims to control access (see https://firebase.google.com/docs/auth/admin/custom-claims)
        isAdmin: claims.custom_claim,
      })
    },
  },
}
</script>

<style></style>
