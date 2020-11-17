<template>
    <div class="xss">
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="文章">
                <el-input type="textarea" v-model="form.article"></el-input>
            </el-form-item>
            <el-form-item label="编号">
                <el-input v-model="form.id"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submit">发表</el-button>
                <el-button type="primary" @click="query">查询</el-button>
            </el-form-item>
            <el-form-item label="结果">
                <!--<h1>v-html：</h1><h1 v-html="form.result"></h1>-->
                <h1>v-dompurify-html：</h1><h1 v-dompurify-html="form.result"></h1>
                <h1>插值表达式：</h1><h1>{{form.res}}</h1>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                form: {
                    article: "",
                    id: "",
                    result: "",
                    res: "",
                },
            }
        },
        methods: {
            submit() {
                let param = {
                    article: this.form.article
                }
                axios.post(this.$global.insertArticle, this.$qs.stringify(param)).then(res => {
                    this.form.result = res.data.data;
                    console.log(res);
                })
            },

            query() {
                axios.get(this.$global.queryArticle + "/" +  this.form.id).then(res => {
                    console.log(res.data.data);
                    this.form.result = res.data.data;
                    // this.$refs.res.innerHTML = res.data.data;
                    this.form.res = res.data.data;
                })
            }
        }
    }
</script>

<style scoped>

    .xss {
        margin-top: 60px;
        width: 40%;
        margin-left: 30%;
        margin-right: 30%;
    }

</style>