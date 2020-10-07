import firebase from 'firebase/app'
import 'firebase/auth'

// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyBvX5efjvNerVuu03BnDxwcNmAiwCrq_4A",
    authDomain: "wd-wig.firebaseapp.com",
    databaseURL: "https://wd-wig.firebaseio.com",
    projectId: "wd-wig",
    storageBucket: "wd-wig.appspot.com",
    messagingSenderId: "292510319372",
    appId: "1:292510319372:web:9606b8bff36264bb7a3f29",
    measurementId: "G-SL473X06G8"
  };

let app = null
if (!firebase.app.length){
    app = firebase.initializeApp(firebaseConfig)
}

export default firebase