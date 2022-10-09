<template>
  <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="活动区域">
      <el-select v-model="form.region" placeholder="请选择活动区域">
        <el-option v-for="i in items" v-bind:value="i"></el-option>
      </el-select>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: 'test',
  data() {
    return {
      form: {
        region: '',
      },
      items: [
        'a','b'
      ]
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!');
    }
  }
}
</script>