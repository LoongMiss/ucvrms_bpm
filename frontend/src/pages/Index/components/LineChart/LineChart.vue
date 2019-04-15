<template>
  <div className="line-chart">
    <basic-container>
      <ve-line :data="chartData" :settings="chartSettings"></ve-line>
    </basic-container>
  </div>
</template>

<script>
import VeLine from 'v-charts/lib/line'
import BasicContainer from '@vue-materials/basic-container'
import { getDataNum } from '../../../../api/process/bpmn';

export default {
  components: { VeLine, BasicContainer },
  name: 'LineChart',

  data () {
    return {
      chartData: {
        columns: ['startDate', 'processDataSum', 'bpmnNum', 'dmnNum', 'cmmnNum'],
        rows: [
          { 'processDataSum': 1523, 'startDate': '1月1日', 'bpmnNum': 200, 'dmnNum': 45, 'cmmnNum': 43 }
        ]
      },

      chartSettings: {
        metrics: ['processDataSum', 'bpmnNum', 'dmnNum', 'cmmnNum'],
        dimension: ['startDate']
      }
    }
  },

  created () {

  },
  mounted () {
    getDataNum({}).then(res => {
      this.chartData.rows = res
    })
  }
}

</script>

<style>
  .line-chart {

  }
</style>
