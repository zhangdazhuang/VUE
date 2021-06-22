<template>
  <div>
      <Test></Test>  <!-- 3.组件名为标签使用 -->
  </div>
</template>

<script>
import Test from '../components/Test'   //1.引入刚才的组件
export default {
    name:'test',
    components:{    //2.注册组件
        Test
    }
}
</script>

<style scoped>
</style>
