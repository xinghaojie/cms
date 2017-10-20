package cn.haojie.cms.util;

import cn.haojie.cms.sys.param.dao.IParamDao;
import cn.haojie.cms.sys.param.model.ParamCond;
import cn.haojie.cms.sys.param.model.Param;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

/*
* 系统参数初始化，在Spring容器初始化时，将数据库中的系统参数表数据放到内存中
* @date 2017/10/20
*/
@Component
public class ParamInit {
	
	@Autowired
	private IParamDao dao;

	private Map<String,String> map = new HashMap<String,String>();

	@PostConstruct
	public void init() {
		List<Param> paramList = dao.queryByCond(new ParamCond());
		for(Param p : paramList) {
			map.put(p.getParam_key(),p.getParam_value());
		}
		System.out.println("系统参数初始化完成!");
	}
	
	/**
	* 根据参数键获取参数值
	*/
	public String findParam_value(String param_key) {
		return map.get(param_key);
	}
	
	/**
	* 系统参数表发生变化时， 重新获取数据库中的数据
	*/
	public void reset() {
		map.clear();
		init();
	}
}