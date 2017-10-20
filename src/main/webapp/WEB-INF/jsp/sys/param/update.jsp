<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
	<title>系统参数-修改</title>
	<link rel="stylesheet" type="text/css" href="resource/css/style.css" />
	<script type="text/javascript" src="resource/js/common.js"></script>
</head>
<body>
	<form id="form1" name="form1" action="sys/param/update" method="post">
		<div class="ti">系统参数修改</div>
		<table id="dataTab" class="dataTab">
			<input type="hidden" name="id" value="${vo.id}" />
			<tr>
				<td class="right30">参数名称</td>
				<td class="left30">
					<input id="name" name="name" class="text-m" type="text" value="${vo.name}" maxlength="50" />
					<font color="#CE0000">*</font>
				</td>
				<td class="left30_red" id="name_td"></td>
			</tr>
			<tr>
				<td class="right30">参数键</td>
				<td class="left30">
					<input id="param_key" name="param_key" class="text-m" type="text" value="${vo.param_key}" maxlength="50" />
					<font color="#CE0000">*</font>
				</td>
				<td class="left30_red" id="param_key_td">${errorMsg}</td>
			</tr>
			<tr>
				<td class="right30">参数值</td>
				<td class="left30">
					<input id="param_value" name="param_value" class="text-m" type="text" value="${vo.param_value}" maxlength="50" />
					<font color="#CE0000">*</font>
				</td>
				<td class="left30_red" id="param_value_td"></td>
			</tr>
			<tr>
				<td class="right30">备注</td>
				<td class="left30">
					<textarea id="remark" name="remark" maxlength="200" class="tarea">${vo.remark}</textarea>
					<div id="remark_div">最大长度为200个字节</div>
				</td>
				<td></td>
			</tr>
		</table>
		<center class="btn_div">
			<input type="button" class="bnt" onclick="update_onclick()" value="更新" />
			<input type="button" class="bnt" onclick="jumpTo('sys/param/list')" value="返回" />
		</center>
	</form>

	<script type="text/javascript">
		
		bindEvent("name", "参数名称");
		bindEvent("param_key", "参数键");
		bindEvent("param_value", "参数值");
			
		function update_onclick() {
			notBlank("name", "参数名称");
			notBlank("param_key", "参数键");
			notBlank("param_value", "参数值");
			if(count>0) {
				count = 0;
				return false;
			}
			form1.submit();
		}
	</script>
</body>
</html>