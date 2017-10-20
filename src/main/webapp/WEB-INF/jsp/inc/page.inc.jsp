<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- 分页导航区 -->
	<div align="right" class="pageDiv">
		<div>
			<c:if test="${cond.curPage>1}">
				<span class="firstPage" onclick="firstPage();" title="首页">&nbsp;</span>
				<span class="previousPage" onclick="previousPage();" title="上一页">&nbsp;</span>
			</c:if>
			<c:if test="${cond.pageCount>1 && cond.curPage<cond.pageCount}">
				<span class="nextPage" onclick="nextPage();" title="下一页">&nbsp;</span>
				<span class="lastPage" onclick="lastPage();" title="末页">&nbsp;</span>
			</c:if>
			共${cond.totalItems}条/${cond.pageCount}页&nbsp;&nbsp;
			每页<select name="pageSize" id="pageSize" class="pageSize">
				<option value="${cond.pageSize}">${cond.pageSize}</option>
			</select>条&nbsp;&nbsp;
			第<input type="text" value="${cond.curPage}" name="curPage" id="curPage" class="pageSize" />页

			<span class="goPage" onclick="goto_Page();" title="转到">&nbsp;</span>
		</div>
	</div>
	<script type="text/javascript">
		var curPageElt = document.getElementById("curPage");
		var curPage = curPageElt.value;
		function firstPage() {
			curPage = 1;
			gotoPage();
		}
		function previousPage() {
			if(curPage == 1) {
				curPage=1;
			}else {
				curPage--;
			}
			gotoPage();
		}
		function nextPage() {
			if(curPage == ${cond.pageCount}) {
				curPage=${cond.pageCount};
			}else {
				curPage++;
			}
			gotoPage();
		}
		function lastPage() {
			curPage=${cond.pageCount};
			gotoPage();
		}

		function gotoPage() {
			var form1Elt = document.getElementById("form1");
			form1Elt.action += "?curPage="+curPage;
			form1Elt.submit();
		}
		function goto_Page() {
			var form1Elt = document.getElementById("form1"); 
			var t = curPageElt.value;
			if(t<1 || t>${cond.pageCount}) {alert("对不起，您输入的数字已超出页码范围！");return;} // 校验输入的页码的范围
			form1Elt.action += "?curPage="+curPageElt.value;
			form1Elt.submit();
		}

		curPageElt.onkeypress = function(event) {
			if (event.keyCode == "13") {
				goto_Page();
			}
		}
	</script>