<template>
    <div class="sql">
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="用户名">
                <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="login1">登录1-#</el-button>
                <el-button type="primary" @click="login2">登录2-$</el-button>
                <el-button type="primary" @click="query1">查询1-$</el-button>
                <el-button type="primary" @click="query2">查询2-#</el-button>
            </el-form-item>
            <el-form-item label="结果">
                <p>{{form.result}}</p>
            </el-form-item>
        </el-form>
    </div>
</template>


<script>
    export default {
        data() {
            return {
                form: {
                    name: "",
                    password: "",
                    result: "",
                },
                attack: "",
            }
        },
        methods: {
            login1() {
                let params = {
                    name: this.form.name,
                    password: this.form.password
                }
                axios.post(this.$global.loginUrl1, this.$qs.stringify(params)).then(res => {
                    console.log(res);
                    this.form.result = res.data.data;

                })
            },
            login2() {
                let params = {
                    name: this.form.name,
                    password: this.form.password
                }
                axios.post(this.$global.loginUrl2, this.$qs.stringify(params)).then(res => {
                    console.log(res);
                    this.form.result = res.data.data;
                })
            },
            query1() {
                let param = {
                    name: this.form.name
                }
                axios.post(this.$global.queryUrl1, this.$qs.stringify(param)).then(res => {
                    this.form.result = res.data.data;
                })
            },
            query2() {
                let param = {
                    name: this.form.name
                }
                axios.post(this.$global.queryUrl2, this.$qs.stringify(param)).then(res => {
                    this.form.result = res.data.data;
                })
            }
        }
    }
</script>

<style scoped>

    .sql {
        margin-top: 60px;
        width: 40%;
        margin-left: 30%;
        margin-right: 30%;
    }
</style>