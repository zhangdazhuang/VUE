<template>
  <div>
      <h2>{{msg}}</h2>
  </div>
</template>

<script>
export default {
    name:'Welcome',
    data(){			//注意这里的data和vue不一样，要以函数的形式返回值
        return {
            msg:'WELCOME'
        }
    }
}
</script>

<style scoped>
    h2{
        font-size: 36px;
        color: red;
    }
</style>
