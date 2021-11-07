<template>
  <div style="padding: 10px">
      <div style="margin: 10px ">
          <el-button type="primary" @click="add">新增</el-button>
          <el-button type="primary">删除</el-button>
      </div>
      <div style="margin: 10px">
          <el-input v-model="searchHome" placeholder="主队必发" style="margin: 10px; width:8%" clearable></el-input>
          <el-input v-model="searchPeace" placeholder="平局必发" style="margin: 10px; width:8%" clearable></el-input>
          <el-input v-model="searchGuest" placeholder="客队必发" style="margin: 10px; width:8%" clearable></el-input>
          <el-button type="primary" style="margin-left: 5px" @click="load">查询</el-button>
      </div>
      <div>

              <el-radio v-model="searchbig" label="1">主队必发</el-radio>
              <el-radio v-model="searchbig" label="2">平局必发</el-radio>
              <el-radio v-model="searchbig" label="3">客队必发</el-radio>

      </div>
      <el-table :data="tableData" border stripe style="width: 100%" >
          <el-table-column prop="serialno" label="序列号" width="60" sortable> </el-table-column>
          <el-table-column prop="score" label="比分" width="180">
              <el-table-column
                      prop="scorehome"
                      label="主队进球"
                      width="120">
              </el-table-column>
              <el-table-column
                      prop="scoreguest"
                      label="客队进球"
                      width="120">
              </el-table-column>
          </el-table-column>
          <el-table-column prop="dish" label="盘口" width="180"> </el-table-column>
          <el-table-column prop="home" label="主队必发赔率" width="180" sortable> </el-table-column>
          <el-table-column prop="peace" label="平局必发赔率" width="180" sortable> </el-table-column>
          <el-table-column prop="guest" label="客队必发赔率" width="180" sortable> </el-table-column>
          <el-table-column prop="kaihome" label="主队凯利" width="180" sortable> </el-table-column>
          <el-table-column prop="kaipeace" label="平局凯利" width="180" sortable> </el-table-column>
          <el-table-column prop="kaiguest" label="客队凯利" width="180" sortable> </el-table-column>
          <el-table-column
                  fixed="right"
                  label="操作"
                  width="150">
              <template #default="scope">
                  <el-button @click="handleEdit(scope.row)" type="text" size="small">编辑</el-button>
                  <el-popconfirm title="确认删除吗？">
                      <template #reference>
                  <el-button type="text" size="small">删除</el-button>
                      </template>
                  </el-popconfirm>
              </template>
          </el-table-column>
      </el-table>
    <div style="margin: 10px">
        <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="currentPage"
                :page-sizes="[5, 10, 15, 20,30,100]"
                :page-size="pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
        </el-pagination>

        <el-dialog
                title="录入资料"
                v-model="dialogVisible"
                width="30%">
            <el-form :model="form" label-width="120px">
                <el-form-item label="主队必发赔率">
                    <el-input v-model="form.home" style="width:80%"></el-input>
                </el-form-item>
                <el-form-item label="平局必发赔率">
                    <el-input v-model="form.peace" style="width:80%"></el-input>
                </el-form-item>
                <el-form-item label="客队必发赔率">
                    <el-input v-model="form.guest" style="width:80%"></el-input>
                </el-form-item>
                <el-form-item label="主队凯利">
                    <el-input v-model="form.kaihome" style="width:80%"></el-input>
                </el-form-item>
                <el-form-item label="平局凯利">
                    <el-input v-model="form.kaipeace" style="width:80%"></el-input>
                </el-form-item>
                <el-form-item label="客队凯利">
                    <el-input v-model="form.kaiguest" style="width:80%"></el-input>
                </el-form-item>
                <el-form-item label="比分：主队">
                    <el-input v-model="form.scorehome" style="width:80%"></el-input>
                </el-form-item>
                <el-form-item label="比分：客队">
                    <el-input v-model="form.scoreguest" style="width:80%"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="save" v-on:keyup.enter>确 定</el-button>
  </span>
        </el-dialog>

    </div>
  </div>
</template>

<script>


import request from "../utils/request";

export default {
  name: 'Home',
  components: {
  },
    created() {
      this.load()
    },
    methods: {

      load(){
          request.get("/api/user",{
            params:{
              pageNum:this.currentPage,
              pageSize:this.pageSize,
              searchHome:this.searchHome,
              searchPeace:this.searchPeace,
              searchGuest:this.searchGuest,
              searchbig:this.searchbig}
          }).then(res =>{
              console.log(res)
              this.tableData = res.data.records
              this.total = res.data.total
          })
      },
        save(){
          if(this.form.serialno){
              request.put("/api/user",this.form).then(res =>{
                  console.log(res)
                  if(res.code ==='0'){
                      this.$message({
                          type:"success",
                          message:"更新成功"
                  })
                  }else{
                      this.$message({
                          type:"error",
                          message:"更新失败"
                      })
                  }
          this.load()//刷新表格数据

              })
          }
            request.post("/api/user",this.form).then(res =>{
                console.log(res)
                if(res.code ==='0'){
                    this.$message({
                        type:"success",
                        message:"新增成功"
                    })
                }else{
                    this.$message({
                        type:"error",
                        message:"新增失败"
                    })
                }
            })
            this.dialogVisible = false
        },
        add(){
            this.dialogVisible = true
            this.form ={}
        },
        handleEdit(row) {
            this.form = JSON.parse(JSON.stringify(row))
            this.dialogVisible = true
            console.log(row);
        },
        handleSizeChange(pageSize){//改变当前页面的个数触发
          this.pageSize =pageSize
          this.load()
        },
        handleCurrentChange(pageNum){//改变当前页面触发
          this.currentPage  =pageNum
          this.load()
        }
    },
    data() {
        return {
            form:{},
            dialogVisible:false,
            searchHome:'',
            searchPeace: '',
            searchGuest: '',
            searchbig:'',
            currentPage:1,
            pageSize: 10,
            total:10,
            tableData: [],
        }
    }
}
</script>
