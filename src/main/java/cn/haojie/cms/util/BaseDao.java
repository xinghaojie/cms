package cn.haojie.cms.util;

import cn.haojie.cms.util.ParamInit;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/*
* 所有dao层的基础类：关于分页查询
* @date 2017/10/20
*/
@Repository
public class BaseDao {
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	private ParamInit param;

	protected void queryTotal(String sql, BaseCond cond) {
		String sql2 = "select count(*) from (" + sql +") t";
		Integer totalItems = jdbcTemplate.queryForObject(sql2, Integer.class, cond.getParam());
		
		Integer curPage = cond.getCurPage()==null?1:cond.getCurPage();
		Integer pageSize = Integer.valueOf(param.findParam_value("pageSize")); // 每页记录数
		
		Integer pageCount = totalItems/pageSize;
		if(totalItems%pageSize != 0) {
			pageCount++;
		}

		cond.setStartIndex((curPage-1)*pageSize); // limit后的起始下标
		cond.setCurPage(curPage);
		cond.setPageSize(pageSize);		// 每页记录数
		cond.setTotalItems(totalItems);	// 总记录数
		cond.setPageCount(pageCount);	// 总页数
	
		/* 测试时使用
		System.out.println("当前页码: " + curPage);
		System.out.println("每页记录数: " + pageSize);
		System.out.println("总页数: " + pageCount);
		System.out.println("limit起始总页数: " + cond.getStartIndex());
		System.out.println("总记录数: " + totalItems);
		*/
	}
}