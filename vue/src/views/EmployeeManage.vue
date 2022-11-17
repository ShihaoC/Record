<template>
  <div class="main">
    <navbar></navbar>
    <div class="btn-box1">
      <div>
        <el-button type="primary" plain @click="addView()">添加信息</el-button>
      </div>
    </div>
    <div class="listBox">
      <el-table v-loading="loading"
                :data="tableData"
                style="width: 100%" border="border">
        <el-table-column label="ID" prop="id" sortable>
        </el-table-column>
        <el-table-column label="姓名" prop="name">
        </el-table-column>
        <el-table-column label="入职时间" prop="date">
        </el-table-column>
        <!--        <el-table-column label="id" prop="id">-->
        <!--        </el-table-column>-->
        <el-table-column align="right">
          <template slot="header" slot-scope="scope">
            操作
          </template>
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">修改
            </el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-dialog title="添加信息"  :visible.sync="dialogFormVisible" width="400px">
      <el-form :model="addForm" :rules="rules">
        <el-form-item label="员工姓名" :label-width="formLabelWidth" prop="name">
          <el-input style="width: 80%" type="text" v-model="addForm.name"></el-input>
        </el-form-item>
        <el-form-item label="入职日期" :label-width="formLabelWidth">
          <el-date-picker type="date" placeholder="选择日期" v-model="addForm.logDate"
                          style="width: 80%"></el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="insert()">确 定</el-button>
      </div>
    </el-dialog>

    <el-dialog title="修改信息" :visible.sync="updateDialog" width="400px">
      <el-form :model="updateForm">
        <el-form-item label="ID" :label-width="formLabelWidth">
          <el-input v-model="updateForm.id" disabled type="text" style="width: 80%"></el-input>
        </el-form-item>
        <el-form-item label="姓名" :label-width="formLabelWidth">
          <el-input v-model="updateForm.staff" type="text" style="width: 80%"></el-input>
        </el-form-item>
          <el-form-item label="日期" :label-width="formLabelWidth">
          <el-date-picker type="date" placeholder="选择日期" v-model="updateForm.logDate"
                          style="width: 80%"></el-date-picker>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="updateDialog = false">取 消</el-button>
        <el-button type="primary" @click="update()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
  import emjs from '@/js/EmployeeManage'
  export default emjs
</script>
<style>
  @import "@/css/EmployeeManage.css";
</style>