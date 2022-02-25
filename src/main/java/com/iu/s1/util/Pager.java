package com.iu.s1.util;

public class Pager {
	// 한 페이지에 보여줄 row 갯수
	private Integer viewPage;
	// 페이지 번호
	private Integer curPage;
	// 시작 번호
	private Integer beginNum;
	// 끝 번호
	private Integer endNum;
	
	// ----- JSP paging number -----
	private Integer beginPagingNum;
	private Integer endPagingNum;
	private boolean before;
	private boolean after;
	
	public void makeRow() {
		
		this.beginNum = (this.getCurPage()-1) * this.getViewPage() + 1;
		this.endNum = this.getCurPage() * this.getViewPage();
		
	}
	
	public void makePageNum() {
		
		// DB 전체 Row 갯수
		int totalCount = 400;
		
		// 전체 page 개수
		int totalPage = totalCount / this.getViewPage();
		if(totalCount % this.getViewPage() != 0) {
			++totalPage;
		}
		
		// 한 화면에 출력할 페이징의 갯수
		int PagingCount = 10;
		
		// 전체 페이징 개수 = 전체페이지 / 페이징 갯수
		int totalPagingCount = totalPage / PagingCount;
		
		if(totalPage % PagingCount != 0) {
			++totalPage;
		}
		
		// 현재 페이징이 몇번째 인지 확인
		// 	getCurpage
		//	2
		int pagingBundle = this.getCurPage() / PagingCount;
		
	}
	
	public Integer getViewPage() {
		// 초기값이 null
		if(this.viewPage == null || curPage < 1) {
			this.viewPage = 10;
		}
		
		return viewPage;
	}
	public void setViewPage(Integer viewPage) {
		this.viewPage = viewPage;
	}
	
	public Integer getCurPage() {
		
		if(this.curPage == null || curPage < 1) {
			this.curPage = 1;
		}
			
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getBeginNum() {
		return beginNum;
	}
	public void setBeginNum(Integer beginNum) {
		this.beginNum = beginNum;
	}
	public Integer getEndNum() {
		return endNum;
	}
	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}
	
	
}
