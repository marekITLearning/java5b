<template>
  <HelloWorld msg="Value passed to component" />
</template>

<script>
import { defineComponent } from 'vue'
import HelloWorld from './components/HelloWorld.vue'

export default defineComponent({
  name: 'App',
  components: { HelloWorld },
  setup() {
    return {}
  }
})
</script>
