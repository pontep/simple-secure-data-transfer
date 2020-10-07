<template>
  <div class="container">
    <div>
      <Logo />
      <h1 class="title">Firebase - Vue - Nuxtjs</h1>
      <div>
        <v-text-field label="E-mail" v-model="email"></v-text-field>
        <v-text-field
          label="Enter your password"
          hint="At least 8 characters"
          v-model="password"
        ></v-text-field>
        <v-btn color="success" @click="createUser()"> createUser </v-btn>
      </div>
    </div>
  </div>
</template>

<script>
import * as firebase from "firebase/app"
import "firebase/auth"

export default {
  data() {
    return {
      email: "",
      password: "",
    }
  },
  methods: {
    createUser() {
      firebase
        .auth()
        .createUserWithEmailAndPassword(this.email, this.password)
        .then((data) => {
          console.log(data)
        })
    },
  },
}
</script>

<style></style>
