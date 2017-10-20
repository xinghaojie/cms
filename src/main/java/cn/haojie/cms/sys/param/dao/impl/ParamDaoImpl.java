package cn.haojie.cms.sys.param.dao.impl;

import cn.haojie.cms.sys.param.model.Param;
import cn.haojie.cms.sys.param.dao.IParamDao;
import cn.haojie.cms.util.BaseCond;
import cn.haojie.cms.util.BaseDao;
import cn.haojie.cms.util.ParamInit;

import java.util.List;
import cn.haojie.cms.sys.param.model.ParamCond;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
* 系统参数 数据访问接口的实现类
* @date 2017/10/19
*/
@Repository
public class ParamDaoImpl extends BaseDao implements IParamDao{
	
	@Autowired
	private ParamInit param;

	@Override
	public void insert(Param vo) {
		String sql = "insert into sys_param(id,name,param_key,param_value,remark) values(?,?,?,?,?)";
		Object[] args = {vo.getId(),vo.getName(),vo.getParam_key(),vo.getParam_value(),vo.getRemark()};
		jdbcTemplate.update(sql, args);
		param.reset();
	}
	
	@Override
	public void update(Param vo) {
		String sql = "update sys_param set name=?,param_key=?,param_value=?,remark=? where id=?";
		Object[] args = {vo.getName(),vo.getParam_key(),vo.getParam_value(),vo.getRemark(),vo.getId()};
		jdbcTemplate.update(sql, args);
		param.reset();
	}

	@Override
	public void deleteById(String id) {
		String sql = "delete from sys_param where id=?";
		jdbcTemplate.update(sql,id);
		param.reset();
	}

	@Override
	public void deleteByIds(String ids, String[] args) {
		String sql = "delete from sys_param where id in ("+ids+")";
		System.out.println(sql);
		jdbcTemplate.update(sql, args);
		param.reset();
	}
	
	@Override
	public List<Param> queryList(BaseCond cond) {
		String sql = cond.getCond("select id,name,param_key,param_value,remark from sys_param where 1=1");
		super.queryTotal(sql, cond);
		sql += " order by name limit "+cond.getStartIndex()+","+cond.getPageSize();
		//System.out.println(sql);
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Param.class) , cond.getParam());
	}

	@Override
	public Param queryById(String id) {
		String sql = "select id,name,param_key,param_value,remark from sys_param where id=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Param.class) , id);
	}
	
	@Override
	public List<Param> queryByCond(BaseCond cond) {
		String sql = cond.getCond("select id,name,param_key,param_value,remark from sys_param where 1=1");
		//System.out.println(sql);
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Param.class) , cond.getParam());
	}
}