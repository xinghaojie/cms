<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
	<title>系统参数-明细</title>
	<link rel="shortcut icon" href="resource/img/icon_normal.gif" />
	<link rel="stylesheet" type="text/css" href="resource/css/style.css" />
	<script type="text/javascript" src="resource/js/common.js"></script>
</head>
<body>
	<div class="ti">系统参数明细</div>
	<table id="dataTab" class="dataTab">
		<tr>
			<td class="right30">参数名称</td>
			<td>${vo.name}</td>
		</tr>
		<tr>
			<td class="right30">参数键</td>
			<td>${vo.param_key}</td>
		</tr>
		<tr>
			<td class="right30">参数值</td>
			<td>${vo.param_value}</td>
		</tr>
		<tr>
			<td class="right30">备注</td>
			<td>${vo.remark}</td>
		</tr>
	</table>
</body>
</html>