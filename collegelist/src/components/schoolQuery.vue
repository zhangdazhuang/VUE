<template>
  <div >
    <table class="collegelist"  >
        <td width="20%" style="padding-right:20px;vertical-align:top; ">
          <place-query v-if="show"/>    <!-- 左上角查询栏-->
          <menu-query v-else/>
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
import menuQuery from './menuQuery.vue'
import PlaceQuery from './placeQuery.vue'
import Bus from '../bus'
export default {
  data() {
    return {
        total:42,
        page: 0,
        show: true,
     }
  },
  components:{
      menuQuery,
      PlaceQuery     //按地区查询
  },
  created() {
      Bus.$on('show', val => {
          this.show = val
      })
  },
  methods: {
    // getData(value){
    //   if(value.name == '一流学校')
    //   {
    //     Bus.$emit('name', '一流大学')  // 发送数据（参数名称，参数）
    //   }
    //   else if(value.name == '985高校'){
    //     Bus.$emit('name', '985')
    //   }
    //   else if(value.name == '211高校'){
    //     Bus.$emit('name', '211')
    //   }
    //   else
    //   {
    //     Bus.$emit('name', value.name)
    //   }
    // },
    // getPlaceData(value){
    //   Bus.$emit('place', value.name)
    // },
  },
}
</script>
