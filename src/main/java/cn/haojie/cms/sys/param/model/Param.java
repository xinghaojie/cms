package cn.haojie.cms.sys.param.model;

/*
* 系统参数实体类
* @date 2017/10/19
*/
public class Param {

	private String id;
	private String name;
	private String param_key;
	private String param_value;
	private String remark;

	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setParam_key(String param_key) {
		this.param_key = param_key;
	}
	public String getParam_key() {
		return param_key;
	}

	public void setParam_value(String param_value) {
		this.param_value = param_value;
	}
	public String getParam_value() {
		return param_value;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
	}
}