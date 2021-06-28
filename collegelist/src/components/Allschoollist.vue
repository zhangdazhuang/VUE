<template>
  <div >
    <table class="collegelist"  >
        <td width="20%" style="padding-right:20px;vertical-align:top; ">
          <!-- 左上角查询栏 -->
          <key-word-query v-if="show"/>
          <type-query v-else/>
        </td>
        <td width="100%">
          <router-view/>
        </td>
      </table>
  </div>
</template>
<style lang="less" >
.collegelist{
  width: 70%;
  text-align:center;
  margin:0 auto;
}

</style>
<script>
import TypeQuery from './Query.vue'
import keyWordQuery from './keyWordQuery.vue'
import Test from './About.vue'
import Bus from '../bus'
export default {
  data() {
    return {
        total:42,
        page: 0,
        show: false,
     }
  },
  components:{
      keyWordQuery,
      TypeQuery,      
      Test
  },
  created() {
      Bus.$on('show', val => {
          this.show = val
      })
  },
}
</script>
