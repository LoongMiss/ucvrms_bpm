<template>
  <d2-container>
    <el-row>
      <el-button-group>
        <el-button type="primary" @click="add">新建</el-button>
        <el-button type="success">修改</el-button>
        <el-button type="info">详情</el-button>
        <el-button type="warning">回滚</el-button>
        <el-button type="danger">删除</el-button>
      </el-button-group>
    </el-row>
    <el-row style="margin-top: 10px">
      <el-table v-bind:data="tableData"  border highlight-current-row @current-change="handleCurrentChange" style="width: 100%">
        <el-table-column prop="id" label="流程ID"></el-table-column>
        <el-table-column prop="key" label="流程标识"></el-table-column>
        <el-table-column prop="description" label="流程描述"></el-table-column>
        <el-table-column prop="name" label="流程名称"></el-table-column>
        <el-table-column prop="version" label="流程版本" width="80px">
          <template slot-scope="scope">
            <el-tag :type="primary" disable-transitions>{{scope.row.version}}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="deploymentId" label="部署流程ID" width="100px"></el-table-column>
        <el-table-column prop="diagram" label="流程图"></el-table-column>
        <el-table-column prop="suspended" label="流程挂起" width="80px">
          <template slot-scope="scope">
            <el-tag
              :type="scope.row.suspended === true ? 'primary' : 'success'"
              disable-transitions>{{scope.row.suspended}}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="tenantId" label="tenantId"></el-table-column>
      </el-table>
    </el-row>
    <el-row style="margin-top: 10px">
      <el-pagination
        @size-change="handlePageSizeChange"
        @current-change="handlePageCurrentChange"
        :current-page="pageIndex"
        :page-sizes="[20, 50, 100, 200]"
        :page-size="20"
        layout="total, sizes, prev, pager, next, jumper"
        :total="400">
      </el-pagination>
    </el-row>
  </d2-container>
</template>

<script>
import { processDefinition } from '@/api/process/bpmn'

export default {
  // 如果需要缓存页面
  // name 字段需要设置为和本页路由 name 字段一致
  name: 'bpmn',
  data () {
    return {
      pageIndex: 1,
      tableData: [],
      selectData: {}
    }
  },

  methods: {
    handlePageSizeChange (val) {
      this.pageIndex = 1
      this.query()
    },
    handlePageCurrentChange (val) {
      this.query()
    },
    handleCurrentChange (val) {
      this.selectData = val
    },
    query () {
      processDefinition({}).then(res => {
        this.tableData = res
      })
    },
    add () {
      this.$router.push('/definition/add')
    }
  },
  mounted () {
    processDefinition({}).then(res => {
      this.tableData = res
    })
  }
}
</script>
