<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
	<title>系统参数-列表</title>
	<link rel="stylesheet" type="text/css" href="resource/css/style.css" />
	<script type="text/javascript" src="resource/js/common.js"></script>
</head>
<body>
	
	<!-- 搜索区 -->
	<form id="form1" name="form1" action="sys/param/list" method="post">
		<div class="ti">系统参数查询</div>
		<table class="SearchTab">
			<tr id="conditionTr">
				<td align="right">参数名称</td>
				<td><input name="name_c" type="text" value="${cond.name_c}" /></td>
				<td align="right">参数键</td>
				<td><input name="param_key_c" type="text" value="${cond.param_key_c}" /></td>
				<td align="right">参数值</td>
				<td><input name="param_value_c" type="text" value="${cond.param_value_c}" /></td>
				<td align="right">备注</td>
				<td><input name="remark_c" type="text" value="${cond.remark_c}" /></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<input type="button" class="bnt" value="查询" onclick="gotoPage();" />
					<input type="button" class="bnt" value="清空" onclick="_clean('conditionTr');" />
				</td>
			</tr>
		</table>
	</form>
	
	<!-- 数据区 -->
	<table class="titleTab">
		<tr>
			<td class="ti">系统参数列表</td>
			<td class="bu">
				<input type="button" class="bnt" value="新增" onclick="jumpTo('sys/param/toinsert');" />
				<input type="button" class="bnt" value="删除" onclick="deleteByIds('sys/param/delete')" />
			</td>
		</tr>
	</table>
	<table id="dataTab" class="dataTab">
		<tr>
			<th><input type="checkbox" id="checkAll" onclick="chkAll();" />序号</th>
			<th>参数名称</th>
			<th>参数键</th>
			<th>参数值</th>
			<th>备注</th>
			<th>删除</th>
			<th>修改</th>
			<th>详情</th>
		</tr>
		
		<c:forEach var="vo" items="${dataList}" varStatus="s">
		<tr>
			<td class="sqe_w"><input type="checkbox" name="chk" onclick="check();" value="${vo.id}" />${cond.startIndex+s.count}</td>
			<td>${vo.name}</td>
			<td>${vo.param_key}</td>
			<td>${vo.param_value}</td>
			<td>${vo.remark}</td>
			<td class="td-del" onclick="jumpTo('sys/param/delete?id=${vo.id}')"></td>
			<td class="td-upd" onclick="jumpTo('sys/param/toupdate?id=${vo.id}')"></td>
			<td class="td-det" onclick="showWinDefault('sys/param/detail?id=${vo.id}', 500, 550)"></td>
		</tr>
		</c:forEach>
		
	</table>
	
	<jsp:include page="/WEB-INF/jsp/inc/page.inc.jsp"></jsp:include>
</body>
</html>