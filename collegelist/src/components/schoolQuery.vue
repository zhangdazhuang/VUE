<!--  -->
<template>
  <table  width="65%" style="text-align:center;margin:0 auto;">
      <td width="20%" style="padding-right:20px;vertical-align:top; ">
        <place-query v-if="show"/>    <!-- 左上角查询栏-->
        <menu-query v-else/>
      </td>
      <td width="90%">
        <router-view/>
      </td>
    </table>
</template>

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
      elData: [{
        path: '/',
        name: '一流学校'
      },
      {
        path: '',
        name: '一流学科'
      },
      {
        path: '',
        name: '985高校'
      },
      {
        path: '',
        name: '211高校'
      }
      ],
      elPlaceData:[
        {
          name: '北京市'
        },
        {
          name: '四川省'
        },
        {
          name: '天津市'
        },
        {
          name: '河北省'
        },
        {
          name: '山西省'
        },
        {
          name: '内蒙古自治区'
        },
        {
          name: '辽宁省'
        },
        {
          name: '吉林省'
        },
        {
          name: '黑龙江省'
        },
        {
          name: '上海市'
        },
        {
          name: '江苏省'
        },
        {
          name: '浙江省'
        },
        {
          name: '安徽省'
        },
        {
          name: '福建省'
        },
        {
          name: '江西省'
        },
        {
          name: '山东省'
        },
        {
          name: '河南省'
        },
        {
          name: '湖北省'
        },
        {
          name: '湖南省'
        },
        {
          name: '广东省'
        },
        {
          name: '广西壮族自治区'
        },
        {
          name: '海南省'
        },
        {
          name: '重庆市'
        },
        {
          name: '贵州省'
        },
        {
          name: '云南省'
        },
        {
          name: '西藏自治区'
        },
        {
          name: '陕西省'
        },
        {
          name: '甘肃省'
        },
        {
          name: '青海省'
        },
        {
          name: '宁夏回族自治区'
        },
        {
          name: '新疆维吾尔自治区'
        },
      ]
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
    getData(value){
      if(value.name == '一流学校')
      {
        Bus.$emit('name', '一流大学')  // 发送数据（参数名称，参数）
      }
      else if(value.name == '985高校'){
        Bus.$emit('name', '985')
      }
      else if(value.name == '211高校'){
        Bus.$emit('name', '211')
      }
      else
      {
        Bus.$emit('name', value.name)
      }
    },
    getPlaceData(value){
      Bus.$emit('place', value.name)
    },
  },
}
</script>
<style>
</style>