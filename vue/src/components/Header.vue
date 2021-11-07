<template>
    <div style="height:50px;line-height: 50px;border-bottom: 1px solid #ccc;display: flex">
        <div style="width: 300px;padding-left: 30px;font-weight: bold ;font-size: 30px; color:dodgerblue ">竞彩管理平台</div>
        <div style="flex: 1 "></div>
        <div class="demo-type">
            <div style="padding: 7px">
                <el-avatar
                        src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
                ></el-avatar>
            </div>
        </div>
        <div style="width: 100px ">
            <el-dropdown>
  <span class="el-dropdown-link">
    内马尔<i class="el-icon-arrow-down el-icon--right"></i>
  </span>
                <template #dropdown>
                    <el-dropdown-menu>
                        <el-dropdown-item>主页信息</el-dropdown-item>
                        <el-dropdown-item>会员信息</el-dropdown-item>
                        <el-dropdown-item>个人信息</el-dropdown-item>
                        <el-dropdown-item disabled>暂无</el-dropdown-item>
                        <el-dropdown-item divided>退出系统</el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </div>

    </div>
</template>

<script>
    export default {
        name: "Header"

    }

</script>

<style scoped>

</style>