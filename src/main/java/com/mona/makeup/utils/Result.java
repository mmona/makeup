package com.mona.makeup.utils;

import java.util.List;

public class Result<T> {
	private Page page;
	private List<T> list;
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Result [page=" + page + ", list=" + list + "]";
	}
	
	
	
}
