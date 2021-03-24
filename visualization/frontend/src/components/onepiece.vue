<template>
	<div id="onepiece" align="center" style="background-color: #eeeeee; width: 500px;height: 600px;">
		<br/>
		<chartname :finalDataType="getDataType"></chartname>
		<br/>
		<chart></chart>
		<br/>
		<advice></advice>
	</div>
</template>

<script>
	import chartname from './chartname.vue'
	import chart from './chart.vue'
	import advice from './advice.vue'
	export default {
		name: 'onepiece',
		props: ['dataType'],
		components:{
			chartname,
			chart,
			advice
		},
		data() {
			return{
				getDataType : this.dataType
			}
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
