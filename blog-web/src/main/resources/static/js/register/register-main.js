$(function() {
	checkForm();//校验表单
	checkCode();//校验验证码
	but();
});

function but() {
	$(".same-register2").click(function() {
		alert(1);
	});
}

/**
 * 校验表单属性，且修改样式
 * @returns
 */
function checkForm() {
	var divBox = $(".mid-input-same"); //外层div
	var inputBox = $("input[class='field-same']");//div里面的input
	var spanBox = $("span[class='mid-span-same']");//div里面的 'x'号 用来清空input
	var eyeBox = $("span[class='mid-span-same2']");//小眼睛 span
	//放到div上 改变鼠标手样式
	divBox.mouseover(function() {
		$(this).css("cursor", "text");
	});
	//点击div区域  ，让input获取焦点
	divBox.bind("click",function(){
		$(this).find("input[class='field-same']").focus();
	});
	//input聚焦后   新增div的边框样式
	divBox.find("input[class='field-same']").focus(function(){
		$(this).parent().css({"border-color":"#4486E9","box-shadow":"#C4D9F8 0px 0px 3px 1px"});
	});
	//input失焦后   移除div的边框样式
	divBox.find("input[class='field-same']").blur(function(){
		$(this).parent().css({"border-color":"","box-shadow":""});
	});
	//输入框的键盘按键弹起事件 ， 监听输入框的值的长度，  大于0就显示小叉叉 ， 否则不显示
	inputBox.keyup(function() {
		if ($(this).val().length > 0) {
			$(this).next().show();
			if($(this).next().next().is($("span[class='mid-span-same2']"))){
				$(this).next().next().show();
			}
		} else {
			$(this).siblings("span[class='mid-span-same']").hide();
			$(this).next().next().hide();
		}
	});
	//小叉叉 图标  ：放上去鼠标变样式  ，点击之后隐藏并且清空输入框的值
	spanBox.mouseover(function() {
		$(this).css("cursor", "pointer");
	}).click(function() {
		$(this).prev("input[class='field-same']").val('');
		$(this).hide();
		$(this).next().hide();
	});
	//小眼睛 图标  ：放上去鼠标变样式  ，点击打开关闭眼睛 并且修改input的type类型
//	var eyeFlag = false;
	eyeBox.mouseover(function() {
		$(this).css("cursor", "pointer");
	}).click(function() {
		var typeAttr = $(this).prev().prev("input[class='field-same']").attr("type");
		var iAttr = $(this).find("i").attr("class");
		if(typeAttr=="password" && iAttr=="iconfont icon-eye"){
			$(this).prev().prev("input[class='field-same']").attr("type","text");
			$(this).find("i").attr("class","iconfont icon-eye_no");
		}else{
			$(this).prev().prev("input[class='field-same']").attr("type","password");
			$(this).find("i").attr("class","iconfont icon-eye");
		}
	});
}

/**
 * 滑块验证
 */
function checkCode() {
	// 一、定义一个获取DOM元素的方法
	var getter = function(selector) {
		return document.querySelector(selector);
	}, box = getter(".drag-register"), // 容器
	bg = getter(".bg-register"), // 背景
	text = getter(".text-register"), // 文字
	btn = getter(".btn-register"), // 滑块
	success = false, // 是否通过验证的标志
	distance = box.offsetWidth - btn.offsetWidth;// 滑动成功的宽度（距离）
	// 二、给滑块注册鼠标按下事件
	btn.onmousedown = function(e) {
		// 1.鼠标按下之前必须清除掉后面设置的过渡属性
		btn.style.transition = "";
		bg.style.transition = "";
		// 说明：clientX 事件属性会返回当事件被触发时，鼠标指针向对于浏览器页面(或客户区)的水平坐标。
		// 2.当滑块位于初始位置时，得到鼠标按下时的水平位置
		var e = e || window.event;
		var downX = e.clientX;
		// 三、给文档注册鼠标移动事件
		document.onmousemove = function(e) {
			var e = e || window.event;
			// 1.获取鼠标移动后的水平位置
			var moveX = e.clientX;
			// 2.得到鼠标水平位置的偏移量（鼠标移动时的位置 - 鼠标按下时的位置）
			var offsetX = moveX - downX;
			// 3.在这里判断一下：鼠标水平移动的距离 与 滑动成功的距离 之间的关系
			if (offsetX > distance) {
				offsetX = distance;// 如果滑过了终点，就将它停留在终点位置
			} else if (offsetX < 0) {
				offsetX = 0;// 如果滑到了起点的左侧，就将它重置为起点位置
			}
			// 4.根据鼠标移动的距离来动态设置滑块的偏移量和背景颜色的宽度
			btn.style.left = offsetX + "px";
			bg.style.width = offsetX + "px";
			// 如果鼠标的水平移动距离 = 滑动成功的宽度
			if (offsetX == distance) {
				// 1.设置滑动成功后的样式
				text.innerHTML = "验证通过";
				text.style.color = "#fff";
				btn.innerHTML = "&radic;";
				btn.style.color = "green";
				bg.style.backgroundColor = "lightgreen";

				// 2.设置滑动成功后的状态
				success = true;
				// 成功后，清除掉鼠标按下事件和移动事件（因为移动时并不会涉及到鼠标松开事件）
				btn.onmousedown = null;
				document.onmousemove = null;

				// 3.成功解锁后的回调函数
				setTimeout(function() {
					alert('解锁成功！');
				}, 100);
			}
		}
		// 四、给文档注册鼠标松开事件
		document.onmouseup = function(e) {
			// 如果鼠标松开时，滑到了终点，则验证通过
			if (success) {
				return;
			} else {
				// 反之，则将滑块复位（设置了1s的属性过渡效果）
				btn.style.left = 0;
				bg.style.width = 0;
				btn.style.transition = "left 1s ease";
				bg.style.transition = "width 1s ease";
			}
			// 只要鼠标松开了，说明此时不需要拖动滑块了，那么就清除鼠标移动和松开事件。
			document.onmousemove = null;
			document.onmouseup = null;
		}
	}

}