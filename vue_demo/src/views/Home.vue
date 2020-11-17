<template>
  <div class="home">
    <el-row>
      <el-button @click="sql">sql 注入</el-button>
      <el-button @click="xss" type="primary">XSS 攻击</el-button>
      <el-button @click="uploadFile" type="success">文件上传漏洞</el-button>
    </el-row>
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  methods: {
    sql() {
      this.$router.push('/sql');
    },
    xss() {
      this.$router.push('/xss');
    },
    uploadFile() {
      this.$router.push('/upload-file');
    }

  }
}
</script>
