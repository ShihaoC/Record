import format from "@/js/format";
import axios from "axios";
let newAxios = axios.create({
    baseURL: 'http://101.42.176.62:8081/'
})
export default {
    name: 'EmployeeManage',
    created() {
        newAxios.get("/Em/getList").then((resp)=>{
            this.tableData = resp.data
            console.log(resp.data)
            this.loading = false
        })
    },
    data() {
        return {
            tableData: [],
            loading: true,
            addForm: {
                logDate: new Date(),
                name: ''
            },
            addStaffForm:{
                EmName: '',
                joinDate: ''
            },
            items: [],
            dialogFormVisible: false,
            formLabelWidth: '90px',
            updateDialog: false,
            updateForm: {
                id: 1,
                logDate: new Date(),
                staff: ''
            },
            temp: '',
            rules: {

            },
            staff: '',
        };
    },
    methods: {
        getDate() {
            this.loading = 'true'
            newAxios.get("/Em/getList").then((resp) => {
                this.tableData = resp.data;
                this.loading = false
            })
            this.loading = 'false'
        },
        handleEdit(index, row) {
            console.log(index, row);
            this.updateForm.id = row.id
            this.updateForm.staff = row.name
            this.updateForm.logDate = row.date
            this.updateDialog = true
        },
        handleDelete(index, row) {
            this.loading = true;
            newAxios.post("/Em/delete",{
                id: row.id,
                name: row.name,
                date: row.date
            }).then((resp) => {
                if (resp.data === 'ERROR') {
                    this.$notify({
                        title: '错误',
                        message: '删除错误',
                        type: "error"
                    })
                    setTimeout(null, 1000)
                    this.loading = false;
                } else {
                    this.$notify({
                        title: '删除成功',
                        message: '删除成功啦',
                        type: "success",
                        position: 'bottom-right'
                    })
                    this.query()
                }
            })
        },
        query() {
            if (this.staff == '所有人') {
                this.getDate('')
            } else {
                this.getDate(this.staff)
            }


        },
        addView() {
            this.dialogFormVisible = true;
        },
        insert() {
            console.log(1)
            console.log(this.addForm)
            if(this.addForm.name === ''){
                this.$message({
                    message: '员工名称不能为空',
                    type: 'warning'
                })
                return;
            }
            newAxios.post("/Em/insert",{
                id: '',
                name: this.addForm.name,
                date: format.formatDate(this.addForm.logDate)
            }).then((resp)=>{
                if(resp.data === 'PASS'){
                    this.$notify({
                        title: '成功',
                        message: '添加成功',
                        type: 'success'
                    })
                    this.dialogFormVisible = false;
                    this.getDate()
                }else {
                    this.$notify({
                        title: '失败',
                        message: '添加失败',
                        type: 'error'
                    })
                }
            })

        },
        update(){
            this.loading = true;
            this.updateDialog = false;
            newAxios.post("/Em/update",{
                id: this.updateForm.id,
                name: this.updateForm.staff,
                date: format.formatDate(this.updateForm.logDate)
            }).then((resp)=>{

                if(resp.data     == 'PASS'){
                    this.$notify({
                        title: '成功',
                        message: '修改成功',
                        type: 'success',
                        position: 'bottom-right'
                    })
                    this.loading = false
                    this.getDate()
                }else {
                    this.$notify({
                        title: '失败',
                        message: '修改失败',
                        type: 'error',
                        position: 'bottom-right'
                    })
                }
            })
        }
    },
}