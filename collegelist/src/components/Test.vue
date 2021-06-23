<template>  <!-- 模板，每个模板至少有一个div存在-->
  <div>
      <h2>{{msg}}</h2>
      <router-view/>
  </div>
</template>

<!--添加js逻辑-->
<script> 
export default {
    name:'Test',
    data(){			//注意这里的data和vue不一样，要以函数的形式返回值
        return {
            msg:'Test'
        }
    }
}
</script>

<!--添加样式,使用less语法-->
<style lang ='less' scoped>
    h2{
        font-size: 36px;
        color: green;
    }
</style>
