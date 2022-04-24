
<template>
  <HelloWorld msg="You did it!" />
</template>

<script>
import { defineComponent } from 'vue'
import HelloWorld from './components/HelloWorld.vue'

export default defineComponent({
  name: 'MovieDatabase',
  components: {HelloWorld},
  setup () {
      const title = 'Imdb Movie Database'
    return { title }
  }
})
</script>
