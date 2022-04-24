<template>
  <h3>{{ msg }}</h3>

  <h4 v-if="error !== ''" style="color: red">{{ error }}</h4>

  <div v-if="data">
    {{ data }}
  </div>
</template>

<script>
import { defineComponent, ref } from 'vue'
import xapi from '@/services'

export default defineComponent({
  name: 'HelloWorld',
  props: {
    msg: {
      type: String,
      required: true
    }
  },
  setup() {
    const data = ref(null)

    const error = ref('')

    xapi.get('catalog')
      .then(r => {
        data.value = r.data
      })
      .catch(() => {
        error.value = 'Unable to get data from webservice'
      })
    return { data, error }
  }
})
</script>