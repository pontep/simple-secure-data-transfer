<template>
  <div class="container">
    <div>
      <Logo />
      <h1 class="title">
        Firebase - Vue - Nuxtjs
      </h1>
      <div>
        <v-btn color="success" @click="createUser()">
          createUser
        </v-btn>
      </div>
    </div>
  </div>
</template>

<script>
import handleError from '../din/handleError'
export default {
  mounted() {},
   methods: {
    async createUser() {
      try {
        await this.$fireAuth.createUserWithEmailAndPassword(
          'foo@foo.foo',
          'test'
        )
      } catch (e) {
        handleError.handleError(e)
      }
    }
  },
}
</script>

<style></style>
