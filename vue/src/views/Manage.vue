<template>
  <div class="main">
    <div class="btn-box">
      <el-button type="primary" plain @click="addView()">添加信息</el-button>
      <el-button type="primary" plain @click="query()">查询信息</el-button>
      <el-button type="primary" plain @click="addStaff()">添加员工</el-button>
    </div>
    <div class="search">
      <el-select v-model="staff" placeholder="请选择员工" style="width: 100%">
        <el-option value="所有人"></el-option>
        <el-option v-for="i in items" v-bind:value="i"></el-option>
      </el-select>
    </div>

    <div class="listBox">
      <el-table v-loading="loading"
                :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
                style="width: 100%" border="border">
        <el-table-column label="日期" prop="date" sortable>
        </el-table-column>
        <el-table-column label="姓名" prop="name">
        </el-table-column>
        <el-table-column label="工" prop="work">
        </el-table-column>
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
    <el-dialog title="添加员工" :visible.sync="dialogFormVisible" width="25vw">
      <el-form :model="ruleForm">
        <el-form-item label="员工姓名" :label-width="formLabelWidth">
          <el-select style="width: 15vw" v-model="ruleForm.staff" placeholder="请选择员工">
            <el-option v-for="i in items" v-bind:value="i"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="日期" :label-width="formLabelWidth">
          <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.logDate"
                          style="width: 15vw;"></el-date-picker>
        </el-form-item>
        <el-form-item label="工数" :label-width="formLabelWidth">
          <el-input-number type="number" :min="0.5" :step="0.5" :max="1" placeholder="输入工数" v-model="ruleForm.num"
                           style="width: 15vw;"></el-input-number>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="insert()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import mjs from '../js/manage'

export default mjs

</script>

<style>
@import "../css/manage.css";
</style>
