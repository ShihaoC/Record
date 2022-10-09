<template>
  <div class="main">
    <div class="btn-box">
      <el-button type="primary" plain @click="addView()">添加信息</el-button>
      <el-button type="primary" plain @click="query()">查询信息</el-button>
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
    <div class="addBox">
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="auto" class="demo-ruleForm">
        <el-form-item label="员工" prop="staff">
          <el-select v-model="ruleForm.staff" placeholder="请选择员工" style="width: 100%">
            <el-option v-for="i in items" v-bind:value="i"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="日期" prop="logDate">
          <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.logDate" style="width: 100%;">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="工" prop="num">
          <el-input-number type="number" placeholder="输入工数" v-model="ruleForm.num" style="width: 100%;">
          </el-input-number>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 40%" type="primary" @click="insert()">提交</el-button>
          <el-button style="width: 40%" type="primary" @click="hid()">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
import mjs from '../js/manage'

export default mjs

</script>

<style>
@import "../css/manage.css";
</style>
