<template>
  <div>
	<div align="center"><h1 style="color: #3A8EE6;"><font size="10">动态指导大屏</font></h1></div>
	<hr style="height:3px;border:none;border-top:3px ridge blue;"/>
	<div id="wholepage">
      <el-row>
		<el-col :span="12" align="center">
          <div align="center" style="background-color: #eeeeee; width: 500px;height: 600px;">
            <br/>
            <div style="width:100px; height:45px;background-color: #ffffff">
              <h1><font size="6">温度</font></h1>
            </div>
            <br/>
            <chart1></chart1>
            <br/>
            <advice></advice>
          </div>
        </el-col>
		<el-col :span="12" align="center">
          <div align="center" style="background-color: #eeeeee; width: 500px;height: 600px;">
            <br/>
            <div style="width:100px; height:45px;background-color: #ffffff">
              <h1><font size="6">风力</font></h1>
            </div>
            <br/>
            <chart2></chart2>
            <br/>
            <advice></advice>
          </div>
        </el-col>
      </el-row>
      <br/>
      <el-row>
		<el-col :span="12" align="center">
          <div align="center" style="background-color: #eeeeee; width: 500px;height: 600px;">
            <br/>
            <div style="width:100px; height:45px;background-color: #ffffff">
              <h1><font size="6">降水量</font></h1>
            </div>
            <br/>
            <chart3></chart3>
            <br/>
            <advice></advice>
          </div>
		</el-col>
		<el-col :span="12" align="center">
          <div align="center" style="background-color: #eeeeee; width: 500px;height: 600px;">
            <br/>
            <div style="width:100px; height:45px;background-color: #ffffff">
              <h1><font size="6">湿度</font></h1>
            </div>
            <br/>
            <chart4></chart4>
            <br/>
            <advice></advice>
          </div>
		</el-col>
      </el-row>
	</div>
  </div>
</template>

<script>
    import chart1 from './chart1.vue'
    import chart2 from './chart2.vue'
    import chart3 from './chart3.vue'
    import chart4 from './chart4.vue'
    import advice from './advice.vue'
	export default {
		name: 'wholepage',
		components:{
            chart1,
            chart2,
            chart3,
            chart4,
            advice
		},
		methods: {
			
		}
	}
</script>

<style>
</style>
