<template>
  <div
    v-if="loadingData"
    style="left: 2.5em; top: 0.5em;"
  >
    <q-spinner-ios
      color="primary"
      size="2em"
    />
    <span class="text-primary q-ml-sm">{{ t('$l.info.loadingData') }}</span>
  </div>

  <div
    v-if="loadingDataError"
    class=""
    style="left: 2.6em; top: 0.5em; white-space: normal; line-height: 0.8em;"
  >
    <span class="text-negative">{{ loadingDataError }}</span>
  </div>

  <template v-if="!loadingData">
    <div class="row text-caption align-start">
      <div
        v-for="option in options"
        :key="option.value"
        class="col-xs-12 col-sm-6 q-py-xs self-center"
        style="line-height: 1.2em;"
      >
        <q-checkbox
          v-model="checkBoxModel"
          :val="option.value"
          dense
          size="xs"
        >
          <b>{{ option.value }}</b>
          - {{ option.label }}
        </q-checkbox>
      </div>
    </div>
  </template>
</template>

<script lang="ts">
import { ref, defineComponent, computed, PropType } from 'vue'
import xapi from '@/services/axios'
import { useI18n } from 'vue-i18n'

export default defineComponent({
  name: 'DSTags',
  props: {
    modelValue: {
      type: Array as PropType<string[]>,
      required: true
    }
  },
  emits: ['update:modelValue'],
  setup (props, context) {
    const { t } = useI18n()

    const loadingData = ref(true)
    const loadingDataError = ref('')

    const checkBoxModel = computed({
      get: () => props.modelValue,
      set: (value) => context.emit('update:modelValue', value)
    })

    interface TagIntf {
      label: string,
      value: string
    }

    const options = ref([] as TagIntf[])

    xapi.get('business-handler/tags')
      .then(r => {
        const data = r.data as []
        data.forEach(e => {
          const o = e as { name: string, description: string }
          options.value.push({
            value: o.name,
            label: o.description
          })
        })
      }).catch(() => {
        loadingDataError.value = t('$l.info.initializationFailed')
      }).finally(() => {
        loadingData.value = false
      })

    return { loadingData, loadingDataError, t, checkBoxModel, options }
  }
})
</script>
