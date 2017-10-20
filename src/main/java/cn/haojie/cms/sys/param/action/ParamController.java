package cn.haojie.cms.sys.param.action;

/*
* 系统参数控制器
* @date 2017/10/19
*/
import cn.haojie.cms.sys.param.model.Param;
import cn.haojie.cms.sys.param.model.ParamCond;
import cn.haojie.cms.sys.param.service.IParamService;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sys/param")
public class ParamController {

	@Autowired
	private IParamService service;
	
	@RequestMapping("list")
	public String list(ParamCond cond, Map<String, Object> map) {
		map.put("dataList", service.queryList(cond));
		map.put("cond", cond);
		return "sys/param/list";
	}

	@RequestMapping("toinsert")
	public String toinsert() {
		return "sys/param/insert";
	}

	@RequestMapping("toupdate")
	public String toupdate(String id, Map<String, Object> map) {
		map.put("vo", service.queryById(id));
		return "sys/param/update";
	}

	@RequestMapping("detail")
	public String detail(String id, Map<String, Object> map) {
		map.put("vo", service.queryById(id));
		return "sys/param/detail";
	}

	@RequestMapping("insert") 
	public String insert(Param vo, Map<String, Object> map){
		// 校验系统参数键的唯一性
		if(!validate(vo, map, "参数键必须唯一", 1)) {
			return "sys/param/insert";
		}

		service.insert(vo);
		return "redirect:list";
	}

	@RequestMapping("update") 
	public String update(Param vo, Map<String, Object> map){
		// 校验系统参数键的唯一性
		if(!validate(vo, map, "参数键必须唯一", 2)) {
			return "sys/param/update";
		}

		service.update(vo);
		return "redirect:list";
	}

	@RequestMapping("delete") 
	public String delete(String id){
		if(id.contains(",")) {
			service.deleteByIds(id);
		}else {
			service.deleteById(id);
		}
		return "redirect:list";
	}

	/**
	* 表单数据校验唯一性
	* @param vo 需要校验的实体类
	* @param map 相当于request作用域
	* @param errorMsg 出错信息
	* @param flag 添加1，修改2
	* @return true:表示通过校验；false表示未通过校验
	*/
	private boolean validate(Param vo, Map<String, Object> map, String errorMsg, int flag) {
		// 校验系统参数键的唯一性
		ParamCond cond = new ParamCond();
		if(flag==2) { // 如果是修改，加上id
			cond.setId_c(vo.getId());
		}
		cond.setParam_key_c(vo.getParam_key());
		Param param = service.queryByCond(cond);
		if(param!=null) {
			map.put("vo", vo);
			map.put("errorMsg", errorMsg);
			return false;
		}
		return true;
	}
}