<template>
  <div class="contant">
    <el-form :model="loginForm" :rules="rules" ref="ruleForm" label-width="0px" class="demo-ruleForm">
      <h2 class="title">登录</h2>
      <el-form-item label="" prop="name">
        <el-input v-model="loginForm.name" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item label="" prop="password">
        <el-input type="password" v-model="loginForm.password" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" v-on:click="Login()" @keyup.enter="Login()" style="width: 70%">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'login',
  data() {
    //自定义验证
    let name = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户名'))
      }
    }
    return {
      loginForm: {
        name: '',
        password: ''
      },
      rules: {
        name: [
          {validator: name}
        ],
        password: [
          {required: true, message: '请输入密码'}
        ]
      }
    }
  },
  methods: {
    //登录的方法
    Login() {
      //表单验证
      if (this.loginForm.name.length === 0 || this.loginForm.password.length === 0) {
        this.$notify({
          title: '用户名密码不能为空',
          message: '用户名密码不能为空，请按照要求填写',
          type: "warning"
        })
      } else {
        //通过Axios向后端发送get请求
        this.$axios.get("http://101.42.176.62:8081/sys-user/login?name=" + this.loginForm.name + "&password=" + this.loginForm.password).then((resp) => {
          // resp.data 属性值为 PASS 登录成功，清空表单 跳转页面
          if (resp.data === "PASS") {
            this.$message({
              message: '成功',
              type: "success"
            })
            this.loginForm = []
            this.$router.push({path: '/manage'})
            // resp.data 属性值为 PASSWORD_ERROR 密码错误 清空密码
          } else if (resp.data === "PASSWORD_ERROR") {
            this.$notify({
              title: '密码错误',
              message: '请检查密码是否正确',
              type: "warning"
            })
            this.loginForm.password = ''
          }
        }).catch((err) => {
          this.$notify({
            title: '网络错误',
            message: err.message,
            type: "error"
          })
        })
      }
    }
  }
}

</script>

<style>
.contant {
  margin: 200px auto;
  width: 500px;
  height: 300px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.6);
  border-radius: 20px;
  box-sizing: border-box;
  padding: 0 50px 0 50px;
}

.title {
  display: inline-block;
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>

