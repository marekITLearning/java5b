<template>
  <h3>{{ title }}</h3>
</template>

<script>
import { defineComponent } from 'vue'

export default defineComponent({
  name: 'MovieDatabase',
  setup () {
      const title = 'Imdb Movie Database'
    return { title }
  }
})
</script>