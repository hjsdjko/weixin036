<template>
<view class="content">
	<view :style='{"width":"100%","padding":"0 0 0 0","position":"relative","background":"#ff993310","height":"100%"}'>
		<form :style='{"width":"100%","padding":"24rpx 24rpx 24rpx 24rpx","background":"none","display":"block","height":"auto"}'>
			<view :style='{"padding":"0px 0 0px 48rpx","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"2rpx 2rpx 2rpx 2rpx","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
				<input :style='{"border":"0px solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"0px","flex":"1","background":"#ffffff00","fontSize":"28rpx","lineHeight":"64rpx","height":"64rpx"}' v-model="forum.title" placeholder="标题"></input>
			</view>
			<view :style='{"padding":"0px 0 0px 48rpx","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"2rpx 2rpx 2rpx 2rpx","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}' @change="setIsDoneTap" :value="index" :range="options">
					<view class="uni-picker-type" :style='{"width":"100%","lineHeight":"64rpx","fontSize":"28rpx","color":"#666666"}'>{{options[index]}}</view>
				</picker>
			</view>
			<view :style='{"padding":"0px 0 0px 48rpx","margin":"0 0 24rpx 0","borderColor":"#eeeeee","alignItems":"center","borderRadius":"0px 0 0 0px","borderWidth":"2rpx 2rpx 2rpx 2rpx","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
				<xia-editor :style='{"minHeight":"300rpx","padding":"20rpx 0 0 0","margin":"0 0 0 0","color":"#666666","flex":"1","background":"none","height":"auto"}' v-model="forum.content" @editorChange="contentChange" placeholder="内容"></xia-editor>
			</view>
			<view :style='{"width":"100%","justifyContent":"center","display":"flex","height":"auto"}'>
				<button :style='{"border":"0px solid #eeeeee","padding":"0 0 0 0","margin":"0 20rpx 0 20rpx","color":"#fff","borderRadius":"40rpx","background":"#ff9933","width":"240rpx","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red margin-tb-sm">确认提交</button>
			</view>
		</form>
	</view>
</view>
</template>

<script>
    import xiaEditor from '@/components/xia-editor/xia-editor';
	export default {
		data() {
			return {
				forum: {
					content: '',
					id: '',
					title: '',
					isdone: '开放',
					parentid: 0
				},
				index: 0,
				options: ['开放', '关闭'],
				username: '',
				user: {}
			}
		},
        components: {
            xiaEditor
        },
		async onLoad(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			if (options.id) {
				this.id = options.id;
				let res = await this.$api.info('forum',this.id);
				this.forum = res.data
			}
			this.styleChange()
		},
		methods: {
            contentChange(e) {
                this.forum.content = e
            },
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.my-publish-pv .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.myPublishForm.content.input.backgroundColor
					// })
				})
			},
			async onSubmitTap() {
				this.forum.username = this.username;
				if (this.id) {
					await this.$api.update('forum',this.forum);
				} else {
					await this.$api.save('forum',this.forum);
				}
				this.$utils.msgBack('操作成功');
			},
			setIsDoneTap(e) {
				// this.forum.isdone = e;
				this.index = e.target.value
				this.forum.isdone = this.options[this.index]
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
