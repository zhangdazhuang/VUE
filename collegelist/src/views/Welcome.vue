<template>
  <div>
      <Welcome></Welcome>  <!-- 3.组件名为标签使用 -->
  </div>
</template>

<script>
import Welcome from '../components/Welcome'   //1.引入刚才的组件
export default {
    name:'welcome',   //重点 别用Welcome，其他名称都行，不能与组件同名
    components:{    //2.注册组件
        Welcome
    }
}
</script>

<style scoped>
</style>
