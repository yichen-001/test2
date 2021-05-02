<template>
    <div class="flink-chart" style="width:400px; height:280px; border:solid 1px #000000; background-color: #ffffff">
        <chart ref="barChart" :options="chartOptions" :auto-resize="true"></chart>
	</div>
</template>

<script>
import axios from 'axios'//用于获取数据的，需要先安装axios

//const URL = '/api/data_keeper/queryDataWithPrefix?namePrefix=MeteorologicalDataStream_';//axios获取数据时需要的URL！！！！
const URL = '/api/data_keeper/queryDataWithPrefix?namePrefix=windPower_';//axios获取数据时需要的URL
//图的配置
const baseOption = {
	title: {
		text: 'Flink动态数据'
	},
	tooltip: {},
	legend: {
		data: ['时间']
	},
	xAxis: {
		type: 'category',
		data: []
	},
	yAxis: {},
	series: [{
		name: '值',
		type: 'line',
		data: []
	}]
};
//指定刷新数据的周期
let __interval = 2000;
//用以保存setInterval方法返回的参数值，clearInterval会用到这个参数值
let __timer;

function preProcess(res) {
	let x = [];
	let y = [];
	Object.keys(res.data)
		.sort((a, b) => +a - +b)
		.forEach(key => {
			x.push(key);
			y.push(res.data[key]);
		})
	return {x, y};
}

export default {
	name: 'FlinkChart',
	data() {
		//把图的配置作为一个参数
		return {chartOptions: baseOption}
	},
	mounted() {
		this.init();
	},
	unmounted() {
		clearInterval(__timer);
	},
	methods: {
		//原先的函数
		updateChart({x, y}) {
			baseOption.xAxis.data = x;
			baseOption.series[0].data = y;
			this.chartOptions = baseOption;
		},
		fetchData(limit = 100) {
            return axios.get(URL + `&limit=${limit}`).then(res => res.data)
		},
		init() {
			this.$refs.barChart.showLoading();
			//then方法是保证数据获取到之后才会执行后面的内容
			this.fetchData().then(res => {
			if (Object.keys(res.data).length) {
				this.$refs.barChart.hideLoading();
				this.$refs.barChart.resize();
				this.updateChart(preProcess(res));
				Object.keys(res.data).length && this.doTimer();
			} else {
				window.alert('无数据');
			}
			})
		},
		//用来刷新取得数据
		doTimer() {
			__timer = setInterval(() => {
				this.fetchData().then(res => {
					if (Object.keys(res.data).length) {
						this.updateChart(preProcess(res));
					}
				})
			}, __interval);
		}
	}
}
</script>

<style>
/*整个div的样式*/
.flink-chart {
	text-align: center;
	width: 500px;
	height: 300px;
}
/*图表标签的样式*/
.echarts {
	margin: 0 auto;
	width: 400px;
	height: 300px;
}
</style>
