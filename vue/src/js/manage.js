import format from "@/js/format";

export default {
    name: 'Manage',
    created() {
        this.axios.get("http://127.0.0.1:8081/sys-employee/getMapping?str=all").then((resp) => {
            this.tableData = resp.data;
            this.loading = false
        }).catch((err) => {
            this.$notify({
                title: '网络连接出错',
                message: err,
                type: "error"
            })
            this.loading = false
        })
        this.axios.get("http://127.0.0.1:8081/sys-employee/getStaffs").then((resp) => {
            let arr = [];
            for (let i = 0; i < resp.data.length; i++) {
                arr[i] = resp.data[i].name;
            }
            this.items = arr;
        })
    },
    data() {
        var logDate = (rule, value, callback) => {
            if (value == '') {
                return callback(new Error('年龄不能为空'));
            } else {
                callback()
            }
        };
        var staff = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('员工不能为空'));
            } else {
                callback()
            }
        };
        var num = (rule, value, callback) => {
            if (value > 1) {
                callback(new Error("不能大于1"))
            } else {
                callback();
            }
        };
        return {
            tableData: [],
            search: '',
            loading: true,
            ruleForm: {
                num: '',
                logDate: '',
                staff: ''
            },
            addStaffForm:{
                EmName: '',
                joinDate: ''
            },
            items: [],
            rules: {
                staff: [
                    { validator: staff, trigger: 'blur' }
                ],
                num: [
                    { validator: num, trigger: 'blur' }
                ],
                logDate: [
                    { validator: logDate, trigger: 'blur' }
                ]
            },
            sear: '',
            staff: '',
        };
    },
    methods: {
        getDate(str) {
            this.loading = 'true'
            this.axios.get("http://127.0.0.1:8081/sys-employee/getMapping?str=" + (str === '' ? "all" : str)).then((resp) => {
                this.tableData = resp.data;
                this.loading = false
            })
            this.loading = 'false'
        },
        handleEdit(index, row) {
            console.log(index, row);
        },
        handleDelete(index, row) {
            this.loading = true;
            console.log(row.name)
            console.log(row.date)
            this.axios.get("http://127.0.0.1:8081/sys-employee/delete?date=" + row.date + "&name=" + row.name+"&work="+row.work).then((resp) => {
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
                        type: "success"
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
            document.querySelector(".addBox").style.display = 'block'
        },
        insert() {
            console.log(1)
            console.log(this.ruleForm.staff)
            if (this.ruleForm.num > 1) {
                this.$message({
                    message: '工数不能大于1',
                    type: "warning"
                })
            } else if (this.ruleForm.staff === '') {
                this.$message({
                    message: '员工不能为空',
                    type: "warning"
                })
            } else if (this.ruleForm.logDate === '') {
                this.$message({
                    message: '日期不能为空',
                    type: "warning"
                })
            } else {

                this.axios.get("http://127.0.0.1:8081/sys-employee/insert?date=" + format.formatDate(this.ruleForm.logDate, "yyyy-MM-dd") + "&name=" + this.ruleForm.staff + "&work=" + this.ruleForm.num).then((resp) => {
                    this.$notify({
                        title: '添加成功',
                        message: '添加成功啦',
                        type: "success"
                    })
                    document.querySelector(".addBox").style.display = 'none'
                    this.query();
                }).catch((err) => {
                    console.log("error")
                })
            }
        },
        hid() {
            document.querySelector(".addBox").style.display = 'none'
        },
        resetForm(){
            this.addStaffForm = []
        }
    },
}