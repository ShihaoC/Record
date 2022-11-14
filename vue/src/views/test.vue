<template>
<div>
  <el-button type="text" @click="dialogFormVisible = true">打开嵌套表单的 Dialog</el-button>

  <el-dialog title="添加员工" :visible.sync="dialogFormVisible" width="25vw">
    <el-form :model="ruleForm">
      <el-form-item label="员工姓名" :label-width="formLabelWidth">
        <el-select style="width: 15vw" v-model="ruleForm.staff" placeholder="请选择活动区域">
          <el-option label="区域一" value="shanghai"></el-option>
          <el-option label="区域二" value="beijing"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="日期" :label-width="formLabelWidth">
        <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.logDate"  style="width: 15vw;"></el-date-picker>
      </el-form-item>
      <el-form-item label="工数" :label-width="formLabelWidth">
        <el-input-number type="number" :min="0.5" :step="0.5" :max="1"  placeholder="输入工数" v-model="ruleForm.num" style="width: 15vw;"></el-input-number>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
    </div>
  </el-dialog>
</div>
</template>

<script>
export default {
  name: 'test',
  data() {
    return {
      ruleForm: {
        num: 1,
        logDate: new Date(),
        staff: ''
      },
      dialogTableVisible: false,
      dialogFormVisible: false,
      formLabelWidth: '90px'
    };
  },
  methods: {
    onSubmit() {
      console.log('submit!');
    }
  }
}
</script>

