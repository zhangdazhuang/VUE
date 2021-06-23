<template>
  <div >
    <About></About>
  </div>
</template>
<script>
import About from '../components/About'   //1.引入刚才的组件
export default {
    name:'about',
    components:{    //2.注册组件
        About
    }
}
</script>

<style scoped>
</style>
