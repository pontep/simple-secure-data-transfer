const cryptoJs = require("crypto-js")

const plainText = "Pontep Thaweesup"
const password = "dinza"

// Encrypt
const ciphertext = cryptoJs.AES.encrypt(plainText, password, {
  mode: cryptoJs.mode.ECB,
  padding: cryptoJs.pad.Pkcs7,
}).toString()

// Decrypt
const bytes = cryptoJs.AES.decrypt(ciphertext, password, {
  mode: cryptoJs.mode.ECB,
  padding: cryptoJs.pad.Pkcs7,
})
const originalText = bytes.toString(cryptoJs.enc.Utf8)

console.log(ciphertext)
console.log(originalText) // 'my message'
