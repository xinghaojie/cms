package cn.haojie.cms.sys.param.service.impl;

import cn.haojie.cms.sys.param.model.Param;
import cn.haojie.cms.sys.param.service.IParamService;
import cn.haojie.cms.sys.param.dao.IParamDao;
import cn.haojie.cms.util.BaseCond;
import cn.haojie.cms.util.UUIDUtil;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
* 系统参数 数据访问接口的实现类
* @date 2017/10/19
*/
@Service
public class ParamServiceImpl implements IParamService{

	@Autowired
	private IParamDao dao;

	@Override
	public void insert(Param vo) {
		vo.setId(UUIDUtil.generateUUID());
		dao.insert(vo);
	}

	@Override
	public void update(Param vo) {
		dao.update(vo);
	}

	@Override
	public void deleteById(String id) {
		dao.deleteById(id);
	}

	@Override
	public void deleteByIds(String ids) {
		String[] args = ids.split(",");
		ids = "";
		for(int i=0; i<args.length; i++) {
			ids += "?";
			if(i<args.length-1) {
				ids += ",";
			}
		}
		dao.deleteByIds(ids, args);
	}
	
	@Override
	public List<Param> queryList(BaseCond cond) {
		return dao.queryList(cond);
	}
	
	@Override
	public Param queryById(String id) {
		return dao.queryById(id);
	}
	
	@Override
	public Param queryByCond(BaseCond cond) {
		List<Param> dataList = dao.queryByCond(cond);
		return dataList.size()==0?null:dataList.get(0);
	}
}