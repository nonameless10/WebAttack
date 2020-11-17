<template>
    <div class="hello">
        <form>
            <input type="file" @change="getFile($event)">
            <button class="button button-primary button-pill button-small" @click="submit1($event)">无任何验证</button>
            <button class="button button-primary button-pill button-small" @click="submit2($event)">前端验证</button>
            <button class="button button-primary button-pill button-small" @click="submit3($event)">后端验证</button>
        </form>
        <h1>{{ result }}</h1>
    </div>
</template>

<script>

    export default {
        data() {
            return {
                file: '',
                result: "",
            }
        },
        methods: {
            getFile: function (event) {
                this.file = event.target.files[0];
                console.log(this.file);
            },
            submit(){
                let formData = new FormData();
                formData.append("file", this.file);
                let that = this;
                axios.post(this.$global.uploadFile1, formData)
                    .then(function (response) {
                        that.result = response.data.data;
                        console.log(response);
                    })
                    .catch(function (error) {
                        that.result = "上传失败";
                        console.log(error);
                    });
            },
            submit1(event) {
                //阻止元素发生默认的行为
                event.preventDefault();
                this.submit();
            },
            submit2: function (event) {
                //阻止元素发生默认的行为
                event.preventDefault();

                const isIMG =
                    this.file.type === 'image/jpg' ||
                    this.file.type === 'image/jpeg' ||
                    this.file.type === 'image/png'
                console.log(this.file.type);
                if(!isIMG) {
                    this.result = "你选择的不是图片";
                    return false;
                }
                this.submit();
            },
            submit3: function (event) {
                //阻止元素发生默认的行为
                event.preventDefault();

                const isIMG =
                    this.file.type === 'image/jpg' ||
                    this.file.type === 'image/jpeg' ||
                    this.file.type === 'image/png'
                console.log(this.file.type);
                if(!isIMG) {
                    this.result = "你选择的不是图片";
                    return false;
                }
                let formData = new FormData();
                formData.append("file", this.file);
                let that = this;
                axios.post(this.$global.uploadFile2, formData)
                    .then(function (response) {
                        that.result = response.data.data;
                        console.log(response);
                    })
                    .catch(function (error) {
                        that.result = "上传失败";
                        console.log(error);
                    });
            },
        }
    }
</script>

<style>
    .hello {
        margin-top: 60px;
    }
</style>