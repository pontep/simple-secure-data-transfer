export default {
  // Global page headers (https://go.nuxtjs.dev/config-head)
  head: {
    title: "frontend",
    meta: [
      { charset: "utf-8" },
      { name: "viewport", content: "width=device-width, initial-scale=1" },
      { hid: "description", name: "description", content: "" },
    ],
    link: [{ rel: "icon", type: "image/x-icon", href: "/favicon.ico" }],
  },

  // Global CSS (https://go.nuxtjs.dev/config-css)
  css: ["~/css/main.css"],

  // Plugins to run before rendering page (https://go.nuxtjs.dev/config-plugins)
  plugins: [],

  // Auto import components (https://go.nuxtjs.dev/config-components)
  components: true,

  // Modules for dev and build (recommended) (https://go.nuxtjs.dev/config-modules)
  buildModules: [
    // https://go.nuxtjs.dev/eslint
    // Simple usage
    "@nuxtjs/vuetify",
    "@nuxtjs/eslint-module",
    [
      "@nuxtjs/firebase",
      {
        config: {
          apiKey: "<apiKey>",
          authDomain: "<authDomain>",
          databaseURL: "<databaseURL>",
          projectId: "<projectId>",
          storageBucket: "<storageBucket>",
          messagingSenderId: "<messagingSenderId>",
          appId: "<appId>",
          measurementId: "<measurementId>",
        },
        services: {
          auth: true, // Just as example. Can be any other service.
        },
      },
    ],
  ],

  // Modules (https://go.nuxtjs.dev/config-modules)
  modules: [
    // https://go.nuxtjs.dev/axios
    "@nuxtjs/axios",
  ],

  // Axios module configuration (https://go.nuxtjs.dev/config-axios)
  axios: {
    baseURL: "http://localhost:9000/api",
  },

  // Build Configuration (https://go.nuxtjs.dev/config-build)
  build: {},
}
