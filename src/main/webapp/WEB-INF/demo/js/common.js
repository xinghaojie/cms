/**
* 描述：默认的通用弹出窗口
* @作者：邢浩杰
* @时间：2017/10/18
*/
function showWinDefault(url, winWidth, winHeight) {
	var left = (top.document.body.clientWidth - winWidth) /2
	var top1 = (top.document.body.clientHeight - winHeight) /2
	showWin(url, winWidth, winHeight, top1, left);
}

/**
* 描述：通用弹出窗口
* @作者：邢浩杰
* @时间：2017/10/18
*/
function showWin(url, winWidth, winHeight, top1, left) {
	var features = "toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, copyhistory=no"
					+ ",width="+winWidth+", height="+winHeight
					+ ",top="+top1+", left="+left;

	window.open(url, "_blank", features);
}

/**
* 描述：清空查询条件。id为包含条件单元格的tr标签的id
* @作者：邢浩杰
* @时间：2017/10/18
*/
function _clean(id) {
	var cells = document.getElementById(id).cells;
	for(var i=0; i<cells.length; i++) {
		if(i%2 == 1) {
			var inputElt = cells[i].firstChild;
			inputElt.value = "";
		}
	}
}

/**
* 描述：页面跳转
* @作者：邢浩杰
* @时间：2017/10/18
*/
function jumpTo(url) {
	window.location.href=url;
}


/**
* 描述：页面加载完毕，表单隔行变色
* @作者：邢浩杰
* @时间：2017/10/18
*/
window.onload = function() {
	var tableTrElts = document.getElementsByName("dataTab"); 
	if(tableTrElts.length>1) {	// 一个页面中有多个dataTab的table，使用name
		for(var i=0; i<tableTrElts.length; i++) {
			tableTrColor(tableTrElts[i]);
		}
	}else {	// 一个页面中有多个dataTab的table，使用id
		tableTrColor(document.getElementById("dataTab"));
	}
}
function tableTrColor(e) {
	var tableTrElt = e;
	if(tableTrElt==null || tableTrElt==undefined) return; // 如果该页面没有dataTab，结束函数
	var rows = tableTrElt.rows;
	for(var i=0; i<rows.length; i++) {
		if(i % 2 == 0) {
			rows[i].style.backgroundColor="#e0e0e0";
			rows[i].onmouseout=function() {this.style.backgroundColor="#e0e0e0"} // 鼠标离开事件
		}else {
			rows[i].style.backgroundColor="#f0f0f0";
			rows[i].onmouseout=function() {this.style.backgroundColor="#f0f0f0"}
		}
		rows[i].onmouseover = function() {this.style.backgroundColor="#bebebe"} // 鼠标悬停事件
	}
}

/**
* 描述：复选框全选或者取消全选
* @作者: 邢浩杰
* @时间: 2017/10/18
*/
function chkAll() {
	var chkAllElt = document.getElementById("checkAll");
	var chks = document.getElementsByName("chk");
	for(var i=0; i<chks.length; i++) {
		chks[i].checked = chkAllElt.checked;
	}
}

/**
* 描述：复选框下面关联的每个单选框单击时，选中或者取消选中全选按钮
* @作者: 邢浩杰
* @时间: 2017/10/18
*/
function check() {
	var chks = document.getElementsByName("chk");
	var chkAllElt = document.getElementById("checkAll");
	var selected = 0;
	for(var i=0; i<chks.length; i++) {
		if(chks[i].checked == true) {
			selected++;
		}
	}
	chkAllElt.checked = (selected == chks.length);
}