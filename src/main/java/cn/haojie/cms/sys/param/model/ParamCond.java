package cn.haojie.cms.sys.param.model;

import cn.haojie.cms.util.BaseCond;

/*
* 系统参数实体类
* @date 2017/10/19
*/
public class ParamCond extends BaseCond {
	
	private String name_c;
	private String param_key_c;
	private String param_value_c;
	private String remark_c;

	private String id_c;

	@Override
	public void sqlAppend() {
		addLike(name_c, " and name like ?");
		add(param_key_c, " and param_key=?");
		add(param_value_c, " and param_value=?");
		addLike(remark_c, " and remark like ?");

		add(id_c, " and id<>?");
	}

	public void setId_c(String id_c) {
		this.id_c = id_c;
	}
	public String getId_c() {
		return id_c;
	}

	public void setName_c(String name_c) {
		this.name_c = name_c;
	}
	public String getName_c() {
		return name_c;
	}

	public void setParam_key_c(String param_key_c) {
		this.param_key_c = param_key_c;
	}
	public String getParam_key_c() {
		return param_key_c;
	}

	public void setParam_value_c(String param_value_c) {
		this.param_value_c = param_value_c;
	}
	public String getParam_value_c() {
		return param_value_c;
	}

	public void setRemak_c(String remark_c) {
		this.remark_c = remark_c;
	}
	public String getRemark_c() {
		return remark_c;
	}
}