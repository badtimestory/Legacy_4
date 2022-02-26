package com.iu.s1.util;

public class Pager {
	// 한 페이지에 보여줄 row 갯수
	private Integer perPage;	// 10
	// 페이지 번호
	private Integer curPage;	// 1
	// 시작 번호
	private Integer beginNum;
	// 끝 번호
	private Integer endNum;
	
	// ----- JSP paging number -----
	private Integer startNum;
	private Integer lastNum;
	
	private boolean before;
	private boolean after;
	
	public void makeRow() {
		this.beginNum = (this.getCurPage() - 1) * this.getPerPage() + 1;
		this.endNum = this.getCurPage() * this.getPerPage();
	}
	
	public void makeNum() {
		
		// 전체 row 갯수
		int totalCount = 400;
		
		// 전체 page 갯수 구하기
		int totalPage = totalCount / this.getPerPage();
		// ex) 전체 페이지가 34개면 4 page가 필요
		if(totalCount % this.getPerPage() != 0) {
			++totalPage;
		}
		
		// 블럭당 갯수
		int perBlock = 10;
		
		// 전체 block의 갯수 구하기
		int totalBlock = totalPage / perBlock;
		
		if(totalPage % perBlock != 0) {
			totalPage++;
		}
		
		// block 1번 : 1 ~ 10
		// block 2번 : 11 ~ 20
		//	page		block
		//	1			1
		//	10			1
		//	11			2
		//	20			2
		//	...
		//	31			3
		
		// Page 번호로 현재 몇번째 Block인지 계산
		int curBlock = this.getCurPage() / perBlock;
		
		if(this.getCurPage() % perBlock != 0) {
			curBlock++;
		}
		
		//		curBlock	startNum	lastNum
		//		1			1			10
		//		2			11			20
//		this.startNum = 1;
//		this.lastNum = totalPage;
		
		// curBlock으로 startNum, lastNum 구하기
		this.startNum = (curBlock - 1) * perBlock + 1;
		this.lastNum = curBlock * perBlock;
		
		// 이전, 다음 블럭 유무 확인
		this.before = false;
		// 현재 block이 2, 3, 4..
		if(curBlock > 1) {
			this.before = true;
		}
		
		this.after = false;
		// 다음 블럭이 더 있을 때
		if(totalBlock > curBlock) {
			this.after = true;
		}
		
		// 현재 블럭이 마지막 블럭과 같으면
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
		
		
	}

	public Integer getPerPage() {
		
		if(this.perPage == null || this.curPage < 1) {
			this.perPage = 10;
		}
		
		return perPage;
	}

	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}

	public Integer getCurPage() {
		
		if(curPage == null || this.curPage < 1) {
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

	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isBefore() {
		return before;
	}

	public void setBefore(boolean before) {
		this.before = before;
	}

	public boolean isAfter() {
		return after;
	}

	public void setAfter(boolean after) {
		this.after = after;
	}
	
	
}
