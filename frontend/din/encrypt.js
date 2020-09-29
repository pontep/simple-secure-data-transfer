const CryptoJS = require("crypto-js")

function encrypt(data) {
  const key = CryptoJS.enc.Latin1.parse("1234567812345678")
  const iv = CryptoJS.enc.Latin1.parse("1234567812345678")
  const encrypted = CryptoJS.AES.encrypt(data, key, {
    iv,
    mode: CryptoJS.mode.CBC,
    padding: CryptoJS.pad.ZeroPadding,
  })
  return encrypted
  // console.log("encrypted: " + encrypted)
  // const decrypted = CryptoJS.AES.decrypt(encrypted, key, {
  //   iv,
  //   padding: CryptoJS.pad.ZeroPadding,
  // })
  // console.log("decrypted: " + decrypted.toString(CryptoJS.enc.Utf8))
}

export { encrypt }
