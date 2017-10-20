package cn.haojie.cms.sys.param.service;

import cn.haojie.cms.sys.param.model.Param;
import cn.haojie.cms.util.BaseCond;
import java.util.List;

/**
* 系统参数 业务逻辑层
* @date 2017/10/20
*/
public interface IParamService {
	
	/**
	* 添加 系统参数
	*/
	public void insert(Param vo);

	/**
	* 修改 系统参数
	*/
	public void update(Param vo);

	/**
	* 根据id删除系统参数
	*/
	public void deleteById(String id);

	/**
	* 根据多个id删除系统参数
	*/
	public void deleteByIds(String ids);
	
	/**
	* 查询 系统参数 分页列表
	*/
	public List<Param> queryList(BaseCond cond);

	/**
	* 根据id查询单个 系统参数
	*/
	public Param queryById(String id);

	/**
	* 根据条件查询 系统参数
	*/
	public Param queryByCond(BaseCond cond);
}