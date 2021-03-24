<template>
  <div>
	<div align="center"><h1 style="color: #3A8EE6;"><font size="10">动态指导大屏</font></h1></div>
	<hr style="height:3px;border:none;border-top:3px ridge blue;"/>
	<div id="wholepage">
      <el-row>
		<el-col :span="12" align="center"><onepiece dataType="温度"></onepiece></el-col>
		<el-col :span="12" align="center"><onepiece dataType="风力"></onepiece></el-col>
      </el-row>
      <br/>
      <el-row>
		<el-col :span="12" align="center"><onepiece dataType="降水量"></onepiece></el-col>
		<el-col :span="12" align="center"><onepiece dataType="湿度"></onepiece></el-col>
      </el-row>
	</div>
  </div>
</template>

<script>
	import onepiece from './onepiece.vue'
	export default {
		name: 'wholepage',
		components:{
			onepiece
		},
		methods: {
			
		}
	}
</script>

<style>
</style>
