<template>  <!--标签包裹的内容是HTMLDom结构，写HTML代码的地方。-->
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<!--标签包裹的内容是页面的逻辑代码，写js代码的地方。-->
<script> 
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  }
}
</script>

<!--<style>标签包裹css内容，可以增加scoped属性声明这些样式只在本模板起作用。-->
<style scoped>

</style>