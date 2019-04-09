<template>
  <el-row>
    <h1>Hello Time</h1>
    <el-button :onclick="goback" size="medium"></el-button>
  </el-row>
</template>

<script>
export default {

  methods: {
    goback() {
      alert("11111");
      alert("2222");
    }
  }
};
</script>
