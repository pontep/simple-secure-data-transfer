<template>
  <div class="container">
    <div>
      <Logo />
      <h1 class="title">Vote Candidate Now!</h1>
      <div class="text-center">
        <v-row>
          <v-col>
            <v-text-field v-model="username" label="Your name" />
            <v-text-field v-model="candidateName" label="Candidate name" />
            <v-btn primary @click="vote">Vote </v-btn>

            <!-- <p>msg: {{ plaintext }}</p>
            <p>pass: {{ password }}</p>
            <p>cipher: {{ cipher }}</p> -->
          </v-col>
          <!-- <v-col>
            <v-text-field v-model="cipher" label="Cipher text" />
            <v-text-field v-model="password" label="Password" />
            <v-btn primary @click="decrypting"> Decrypting! </v-btn>
            <p>cipher: {{ cipher }}</p>

            <p>pass: {{ password }}</p>
            <p>result: {{ result }}</p>
          </v-col> -->
        </v-row>
      </div>
    </div>
  </div>
</template>

<script>
import sha256 from "crypto-js/sha256"
import cryptoJs from "crypto-js"
const CryptoJS = require("crypto-js")

export default {
  data() {
    return {
      candidateName: "",
      username: "pontep",
      password: "pontep1234",
    }
  },
  methods: {
    async vote() {
      try {
        const body = {
          username: this.username,
          candidateName: this.candidateName,
        }
        body.hash = sha256(JSON.stringify(body)).toString()
        const encryptedBody = this.encrypting(JSON.stringify(body))
        const result = await this.$axios.$post("vote", { encryptedBody })
        console.log(result)
      } catch (e) {
        console.log(e)
      }
    },
    encrypting(item) {
      return CryptoJS.AES.encrypt(item, this.password).toString()
    },
    decrypting() {
      try {
        this.result = cryptoJs.AES.decrypt(this.cipher, this.password).toString(
          cryptoJs.enc.Utf8
        )
      } catch (e) {
        console.log(e)
      }
    },
    async testServer() {
      try {
        const data = await this.$axios.$get("test")
        console.log(data)
      } catch (e) {
        console.log(e)
      }
    },
  },
}
</script>

<style>
.container {
  margin: 0 auto;
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
}

.title {
  font-family: "Quicksand", "Source Sans Pro", -apple-system, BlinkMacSystemFont,
    "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
  display: block;
  font-weight: 300;
  font-size: 100px;
  color: #35495e;
  letter-spacing: 1px;
}

.subtitle {
  font-weight: 300;
  font-size: 42px;
  color: #526488;
  word-spacing: 5px;
  padding-bottom: 15px;
}

.links {
  padding-top: 15px;
}
</style>
