<template>
  <div id="app"> <!-- 每个项目只能有一个id=app-->
    <table  width="65%" style="text-align:center;margin:0 auto;background-color: #F2F8FE;filter:brightness(1);">
      <tr><td style="text-align:left; height:35px;font-size:19px">
            <svg class="icon" aria-hidden="true">
              <use xlink:href="#icon-wenjian"></use>
            </svg>
            教育部全国高校名单(截止2020-06-30)
          </td> <td style="width= 15%; text-align:right; height:35px;font-size:19px">  
          <span @click="changeSchool()"><router-link to="">按高校查询</router-link></span>   | 
          <span @click="changePlace()"><router-link to="">按地区查询</router-link></span>  
        </td> 
      </tr>
    </table>
    <!-- <router-view></router-view>  -->
    <add/> <!--添加组件 -->
  </div>
</template>

<script>

</script>

<style lang="less">
  #app {  //id = 'app'
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
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
        show: true, //是否显示——————标志位        
      }
    },
    components:{
      Add:SchoolQuery
    },
      methods: {
    getData(value){
      if(value.name == '一流学校')
      {
        Bus.$emit('name', '一流大学')
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
    changePlace(){
      Bus.$emit('show', true)
    },
    changeSchool(){
      Bus.$emit('show', false)
    }
  },
    
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