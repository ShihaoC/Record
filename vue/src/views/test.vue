<template>
<div>
  <el-button type="text" @click="update()">打开嵌套表单的 Dialog</el-button>

  <el-dialog title="收货地址" :visible.sync="updateDialog" width="25vw">
    <el-form :model="updateForm">
      <el-form-item label="员工姓名" :label-width="formLabelWidth">
        <el-select disabled style="width: 15vw" v-model="updateForm.staff" placeholder="请选择员工"></el-select>
      </el-form-item>
      <el-form-item label="日期" :label-width="formLabelWidth">
        <el-date-picker type="date" placeholder="选择日期" v-model="updateForm.logDate"
                        style="width: 15vw;"></el-date-picker>
      </el-form-item>
      <el-form-item label="工数" :label-width="formLabelWidth">
        <el-input-number type="number" :min="0.5" :step="0.5" :max="1" placeholder="输入工数" v-model="updateForm.num"
                         style="width: 15vw;"></el-input-number>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="updateDialog = false">取 消</el-button>
      <el-button type="primary" @click="updateDialog = false">确 定</el-button>
    </div>
  </el-dialog>
</div>
</template>

<script>
export default {
  name: 'test',
  data() {
    return {
      updateDialog: false,
      updateForm: {
        num: 1,
        logDate: new Date(),
        staff: ''
      },
      formLabelWidth: '90px'
    };
  },
  methods: {
    update(){
      this.updateDialog = true
      this.updateForm.staff = '张三'
      this.axios.post("http://localhost:8081/sys-employee/updateStaff",{
        date: 'AAA',
        name: '20000',
        work: 1,
        id: 1
      }).then((resp)=>{
        console.log(resp)
      })
    }
  }
}
</script>

