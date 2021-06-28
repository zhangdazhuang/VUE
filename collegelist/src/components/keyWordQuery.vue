<template>
  <el-form :inline="true" class="demo-form-inline" style="display:block;" >
    <el-input v-model="place" placeholder="请输入关键字" style="width:170px;" size="small"  suffix-icon="el-icon-s-promotion"></el-input>
  <el-form-item >
    <el-button type="primary" @click="onSubmit" class ="buttonclass">查询</el-button>
  </el-form-item>
</el-form>

</template>

<script>
import Bus from '../bus'
  export default {
    data() {
      return {
        place: ''
      }
    },
    methods: {
      onSubmit() {
        Bus.$emit('yemian_page', 1)
        Bus.$emit('keyword', this.place)
      }
    }
  }
</script>
<style>
.buttonclass {
    width : 170px;
    height: 35px;
}
.red_dot {
  margin-right: 5px;
  vertical-align: middle;
  color: red;
}

</style>