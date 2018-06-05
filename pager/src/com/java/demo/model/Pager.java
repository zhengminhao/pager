package com.java.demo.model;

import java.io.Serializable;
import java.util.List;
/**
 * 分页对象类
 * @author zhengminhao
 * @param <T>
 */

public class Pager<T> implements Serializable {

	private static final long serialVersionUID = 6846793509547658331L;

	private int pageSize;// 每页多少条数据
	private int currentPage;// 当前第几页
	private int totalPage;// 一共多少页
	private int totalRecord;// 一共多少记录
	private List<T> dataList;// 显示数据
	
    //处理分页信息
	public Pager(int pageNum,int pageSize,List<T> sourceList){
		//一共多少条数据
		this.totalRecord = sourceList.size();
		//每页显示条数
		this.pageSize = pageSize;
		//一共多少页
		this.totalPage = this.totalRecord /this.pageSize;
		//不整除情况，页数+1
		if(this.totalRecord %this.pageSize !=0){
			this.totalPage =this.totalPage +1;
		}
		
	    //当前第几页
		if(this.totalPage<pageNum){
			this.currentPage = this.totalPage;
		}else{
			this.currentPage =pageNum;
		}
		
		//获取dataList,使用sublist进行获取
		int fromIndex = this.pageSize *(this.currentPage-1); 
		int toIndex;
		if(this.pageSize * this.currentPage>this.totalRecord){
			toIndex = this.totalRecord;
		}else{
			toIndex = this.pageSize * this.currentPage;
		}
		
		//截取数据
		this.dataList = sourceList.subList(fromIndex, toIndex);
	}
	
	public Pager(int pageSize, int currentPage, int totalPage, int totalRecord,
			List<T> dataList) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.totalRecord = totalRecord;
		this.dataList = dataList;
	}

	public Pager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "Pager [pageSize=" + pageSize + ", currentPage=" + currentPage
				+ ", totalPage=" + totalPage + ", totalRecord=" + totalRecord
				+ ", dataList=" + dataList + "]";
	}

}
