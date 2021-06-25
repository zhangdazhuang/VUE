<template>
<div>
  <table border="0" style="width:100%;">
    <tr style="height:30px">
      <td style="text-align:left"><svg class="icon" aria-hidden="true"> <!--设置蓝点-->
                                  <use xlink:href="#icon-yuandian1"></use>
                                </svg>全国普通高等学校名单
      </td>
    </tr>
    <tr>
      <td style="background:#6f98e4"></td>
    </tr>
  </table>
  <!-- row-style，cell-style设置行高-->
  <el-table :data="tableData" border style="width:100%;" class="table"
   :row-style="{height:'40px'}"  :cell-style="{padding:'0px'}"  
   :header-cell-style="{textAlign: 'center'}"   > <!--设置表头居中-->
    <el-table-column type="index"
      :index="indexMethod" label="序号" width="60" align="center"> </el-table-column>
    <el-table-column prop="code" label="学校标识码" width="105" align="center"> </el-table-column>
    <!-- <el-table-column prop="schoolname" label="学校名称" width="170" align="center">  -->
    <el-table-column label="学校名称" width="180" align="center"> 
        <template slot-scope="scope">   <!--通过表格模板设置超链接，通过 Scoped slot 可以获取到 row, column, $index 和 store，row.link获取数据 -->
          <a :href="scope.row.link" target="_blank"> {{scope.row.schoolname}}</a>
        </template>
    </el-table-column>
    <el-table-column prop="province" label="所在地区" width="130" align="center"> </el-table-column>
    <el-table-column prop="city" label="城市" width="100" align="center"> </el-table-column>
    <el-table-column prop="department" label="主管部门" width="150" align="center"> </el-table-column>
    <el-table-column prop="level" label="办学层次" width="80" align="center"> </el-table-column>
    <el-table-column prop="type" label="办学类型" width="200" align="center"> </el-table-column>
  </el-table>
    <el-pagination v-if="show" background  layout="prev, pager, next" :total="total" :current-page="yemian_page" :page-size="20" @current-change="changerPage">
    </el-pagination>
</div>
</template>
<style lang="less" >
  .icon {
    width: 1em;
    height: 1em;
    vertical-align: -0.15em;
    fill: currentColor;
    overflow: hidden;
  }

</style>
<script>
import Bus from '../bus'
import '../assets/font/iconfont.js' 
  export default {
    data() {
      return {
        total:62,  
        page: 0,
        yemian_page:1,
        show: true,
        val_flag: '一流大学',
        placeList:'北京市四川省天津市河北省山西省内蒙古自治区辽宁省吉林省黑龙江省上海市江苏省浙江省安徽省福建省江西省山东省河南省湖北省湖南省广东省广西壮族自治区海南省重庆市贵州省云南省西藏自治区陕西省甘肃省青海省新疆维吾尔自治区',
        schoolList:['一流学校','一流学科','985高校','211高校'],
        tableData: [],
        test:[],
        tableLabel: {
          lineid: '序号',
          code: '学校标识码',
          schoolname: '学校名称',
          province: '所在地区',
          city: '城市',
          department: '主管部门',
          level: '办学层次',
          type: '办学类型',
          link:"链接"
        }
      }
    },
    created() {
      Bus.$on('yemian_page', val=> {    //接收数据（参数名称，参数）
        this.yemian_page = val
        this.show = false;//让分页隐藏
        this.$nextTick(() => {//重新渲染分页
          this.show = true
        })
      })// http://localhost:1426/college/first?type=一流大学&page=0
      Bus.$on('name', val => {
        this.val_flag = val 
        this.$http('http://localhost:1426/college/first?type='+this.val_flag+'&page='+this.page).then(res => {
            this.tableData = res.data
        })
        this.$http('http://localhost:1426/college/countPlace?type='+this.val_flag).then(res => {
            this.total = res.data
        })
      })
      Bus.$on('place', val =>{
        this.val_flag = val  
        this.$http('http://localhost:1426/college/second?province='+this.val_flag+'&page='+this.page).then(res => {
            this.tableData = res.data
          })
        this.$http('http://localhost:1426/college/countProvince?province='+this.val_flag).then(res => {
            this.total = res.data
          })
      })
      Bus.$on('page', val=>{
        this.page = val
        if(this.placeList.indexOf(this.val_flag) > -1){
          this.$http('http://localhost:1426/college/second?province='+this.val_flag+'&page='+this.page).then(res => {
            this.tableData = res.data
          })
        }
        else {  //if(this.schoolList.indexOf(this.val_flag) > -1)
          this.$http('http://localhost:1426/college/first?type='+this.val_flag+'&page='+this.page).then(res => {
            this.tableData = res.data
        })
        }
      })
    },
    mounted () {
      this.$http('http://localhost:1426/college/first?type='+this.val_flag+'&page='+this.page).then(res => {
        this.tableData = res.data
      })
    },
    methods: {
      indexMethod(index) {
        return index + 1;
      },
      changerPage(page){
        Bus.$emit('page', page-1)
      }
    },
    
  }
</script>