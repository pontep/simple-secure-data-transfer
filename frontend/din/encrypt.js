/* eslint-disable import/no-mutable-exports */
const CryptoJS = require("crypto-js")

const encrypt = {
  encrypt(data) {
    const key = CryptoJS.enc.Utf8.parse("1234567890123456")
    const encrypted = CryptoJS.AES.encrypt(data, key, {
      mode: CryptoJS.mode.ECB,
      padding: CryptoJS.pad.NoPadding,
    })
    // console.log("encrypted: " + encrypted)
    return encrypted.toString()
    // const decrypted = CryptoJS.AES.decrypt(encrypted, key, {
    //   iv,
    //   padding: CryptoJS.pad.ZeroPadding,
    // })
    // console.log("decrypted: " + decrypted.toString(CryptoJS.enc.Utf8))
  },
}
export default encrypt
