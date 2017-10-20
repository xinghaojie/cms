package cn.haojie.cms.sys.param.dao.impl;

import cn.haojie.cms.sys.param.model.Param;
import cn.haojie.cms.sys.param.model.ParamCond;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.junit.runner.RunWith;
import org.junit.Test;

import cn.haojie.cms.util.UUIDUtil;

/**
* 系统参数 数据访问接口的实现类
* @date 2017/10/19
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-servlet.xml"})
public class ParamDaoImplTest{
	
	@Autowired
	private ParamDaoImpl paramDaoImpl;

	//@Test
	public void testInsert() {
		Param vo = new Param();
		vo.setId(UUIDUtil.generateUUID());
		vo.setName("张三");
		vo.setParam_key("yy");
		vo.setParam_value("zz");
		vo.setRemark("oo");
		paramDaoImpl.insert(vo);
	}
	
	//@Test
	public void testUpdate() {
		Param vo = new Param();
		vo.setId("2338c09e010c439498f88cc2506566d4");
		vo.setName("李四");
		vo.setParam_key("tt");
		vo.setParam_value("zz");
		vo.setRemark("oo");
		paramDaoImpl.update(vo);
	}
	
	//@Test
	public void testDeleteById() {
		paramDaoImpl.deleteById("ce00ad210a65497ba7f20a4e920c92d9");
	}
	
	@Test
	public void testQueryList() {
		ParamCond cond = new ParamCond();
		cond.setPageSize(1);
		cond.setCurPage(2);
		cond.setName_c("三");
		cond.setParam_key_c("");
		cond.setParam_value_c("");
		List<Param> params = paramDaoImpl.queryList(cond);
		System.out.println(params.size());
	}
	
	//@Test
	public void testQueryById() {
		Param param = paramDaoImpl.queryById("2338c09e00c439498f88cc2506566d4");
		System.out.println(param);
	}
}