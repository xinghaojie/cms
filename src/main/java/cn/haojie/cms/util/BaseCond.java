package cn.haojie.cms.util;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

/*
* 有条件的分页查询 基础类。
* 包含分页信息
* @date 2017/10/19
*/
public abstract class BaseCond {
	
	private Integer curPage; // 当前页码
	private Integer totalItems; // 总记录数
	private Integer pageSize; // 每页的记录数
	private Integer startIndex; // limit后的起始位置
	private Integer pageCount; // 总页数

	private List<Object> param = new ArrayList<Object>();
	private StringBuilder cond = new StringBuilder();
	
	protected abstract void sqlAppend();

	public void addLike(String s, String text) {
		if(s!=null && s.trim().length()>0) {
			param.add("%"+s+"%");
			cond.append(text);
		}
	}

	public void add(String s, String text) {
		if(s!=null && s.trim().length()>0) {
			param.add(s);
			cond.append(text);
		}
	}
	public void add(Integer i, String text) {
		if(i != null) {
			param.add(i);
			cond.append(text);
		}
	}

	public String getCond(String sql) {
		cond.append(sql);
		sqlAppend();
		return cond.toString();
	}

	public Object[] getParam() {
		int length = param.size();
		Object[] args = new Object[length];
		for(int i=0; i<length; i++) {
			args[i] = param.get(i);
		}
		return args;
	}
	
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getCurPage() {
		return curPage;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}
	public Integer getTotalItems() {
		return totalItems;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageSize() {
		return pageSize;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getStartIndex() {
		return startIndex;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageCount() {
		return pageCount;
	}
}