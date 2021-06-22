<template>
  <div>
      <h2>{{msg}}</h2>
      <router-view/>
  </div>
</template>

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

<style scoped>
    h2{
        font-size: 36px;
        color: green;
    }
</style>
