<template>
  <div id="app"> <!-- 每个项目只能有一个id=app-->
    <table  width="70%" style="text-align:center;margin:0 auto;background-color: #F2F8FE;">
      <tr><td style="text-align:left; height:35px;font-size:19px">
            <svg class="icon" aria-hidden="true">
              <use xlink:href="#icon-wenjian"></use>
            </svg>
            <font style="font-size:15px">教育部全国高校名单(截至{{updateTime}})</font>
          </td> <td style="width= 15%; text-align:right; height:35px;font-size:19px">  
          <span  @click="changeSchool()"><router-link to=""><font style="font-size:15px">按高校查询</font></router-link></span>   | 
          <span @click="changePlace()"><router-link to=""><font style="font-size:15px">按地区查询</font></router-link></span>  
        </td> 
      </tr>
    </table>
    <!-- <router-view></router-view>  -->
    <add/> <!--添加组件 -->
  </div>
</template>

<style lang="less">
  #app {  //id = 'app'
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #010102;
  }
  .icon { // class="icon"
  width: 1em;
  height: 1em;
  vertical-align: -0.15em;
  fill: currentColor;
  overflow: hidden;
  }

</style>

<script>
  import SchoolQuery from './components/schoolQuery.vue' 
  import Bus from './bus'
  export default {
    data(){
      return{
        show: true,    
        updateTime:""    
      }
    },
    components:{
      Add:SchoolQuery
    },
    methods: {
      changePlace(){
        Bus.$emit('show', true)
      },
      changeSchool(){
        Bus.$emit('show', false)
      },
    },
    mounted(){     
      const nowDate = new Date();
      const date = {
        year: nowDate.getFullYear(),
        month: nowDate.getMonth() + 1,
        date: nowDate.getDate(),
      }
      const newmonth = date.month>10?date.month:'0'+date.month
      const day = date.date>10?date.date:'0'+date.date
      this.updateTime = date.year + '-' + newmonth + '-' + day
    }
    
  }
</script>

<!--<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |  //to="/about"为在router\index.js中定义的路由的路径 
      <router-link to="/welcome">Welcome</router-link> |
      <router-link to="/test">Test</router-link> |
      <router-link to="/h1">h1</router-link>  |
      <router-link to="/h2">h2</router-link> 
    </div>
    <router-view/>
    //<router-view></router-view> 
  </div>
</template>

<style lang="less">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
-->