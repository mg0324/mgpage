package com.mgang.page.util;

import java.util.List;

/**
 * 
 * @author meigang
 * 分页对象
 */
public class Page {
	private int totalPage;     //总页数  
    private int totalCount;    //总记录数  
    private int currentPage;   //当前页  
    private int pageSize;      //每页的数量  
    private int firstPage;     //首页
    private int prePage;       //前一页
    private int nextPage;      //下一页
    private int lastPage;      //尾页
    private boolean isFirst;   //首页标志
    private boolean isLast;    //尾页标志
    private List list;         //存放分页数据
    
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public boolean isFirst() {
		return isFirst;
	}
	public void setIsFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}
	public boolean isLast() {
		return isLast;
	}
	public void setIsLast(boolean isLast) {
		this.isLast = isLast;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
    
	/** 
     * 分页处理 
     * @param current_page 当前页 
     * @param page_size 每页的数量 
     * @param total_count 总记录数 
     */  
    public void paging(int currentPage, int pageSize, int totalCount){  
        this.currentPage = currentPage;  
        this.pageSize = pageSize;  
        this.totalCount = totalCount;  
          
        if(currentPage < 1){  
            this.currentPage = 1;  
        }  
          
        this.totalPage = (this.totalCount + pageSize - 1)/pageSize;  
        this.firstPage =1;  
        this.lastPage = totalPage;  
          
        if(this.currentPage > 1){  
            this.prePage = this.currentPage - 1;  
        }else{  
            this.prePage = 1;  
        }  
          
        if(this.currentPage < totalPage){  
            this.nextPage = this.currentPage + 1;   
        }else{  
            this.nextPage = totalPage;  
        }  
        //判断是否是当前页
        if(this.currentPage <= 1){  
            this.setIsFirst(true);  
        }else{  
            this.setIsFirst(false);  
        }  
        //判断是否是最后一页
        if(this.currentPage >= totalPage){  
            this.isLast = true;  
        }else{  
            this.isLast = false;  
        }  
    }
    
}
