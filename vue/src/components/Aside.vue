<template>
    <div>
        <el-menu
                style="width: 200px ;height: calc(100vh - 50px)"
                default-active="home"
                router
                class="el-menu-vertical-demo"
        >
            <el-sub-menu index="1">
                <template #title>
                    <i class="el-icon-location"></i>
                    <span>工具</span>
                </template>
                    <el-menu-item index="home">大数据</el-menu-item>
                    <el-menu-item index="now">实时数据</el-menu-item>
                    <el-menu-item index="1-3">选项3</el-menu-item>
                    <el-menu-item index="1-4">选项4</el-menu-item>
            </el-sub-menu>
            <el-menu-item index="2">
                <i class="el-icon-menu"></i>
                <template #title>导航二</template>
            </el-menu-item>
            <el-menu-item index="3" disabled>
                <i class="el-icon-document"></i>
                <template #title>导航三</template>
            </el-menu-item>
            <el-menu-item index="4">
                <i class="el-icon-setting"></i>
                <template #title>导航四</template>
            </el-menu-item>
        </el-menu>
    </div>
</template>

<script>
    export default {
        name: "Aside"
    }
</script>

<style scoped>

</style>