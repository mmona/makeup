package com.mona.makeup.page.utils;


public class PageUtil {
	
	public static Page createPage(int pageSize,int totalCount,int currentPage) {
		pageSize = getEveryPage(pageSize);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(pageSize, totalCount);
		int beginIndex = getBeginIndex(pageSize, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new Page(pageSize, totalCount, totalPage, currentPage,
				beginIndex, hasPrePage,  hasNextPage);
	}
	
	public static Page createPage(Page page,int totalCount) {
		int everyPage = getEveryPage(page.getPageSize());
		int currentPage = getCurrentPage(page.getCurrentPage());
		int totalPage = getTotalPage(everyPage, totalCount);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage,
				beginIndex, hasPrePage,  hasNextPage);
	}
	
	//get the size of per page
	public static int getEveryPage(int pageSize) {
		return pageSize == 0 ? 10 : pageSize;
	}
	
	//get currentPage
	public static int getCurrentPage(int currentPage) {
		return currentPage == 0 ? 1 : currentPage;
	}
	
	//get total page
	public static int getTotalPage(int pageSize,int totalCount) {
		int totalPage = 0;
		if(totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		return totalPage;
	}
	
	//get begin page
	public static int getBeginIndex(int pageSize,int currentPage) {
		return (currentPage - 1) * pageSize;
	}
	
	// has previous page ?
	public static boolean getHasPrePage(int currentPage) {
		return currentPage == 1 ? false : true;
	}
	
	//has next page ?
	public static boolean getHasNextPage(int totalPage, int currentPage) {
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}
	
}
