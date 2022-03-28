package com.iu.s1.util;

public class Pager {
	
	// 페이지당 보여줄 row의 갯수
	private Long perPage;
	// 페이지 번호
	private Long page;
	// row 시작 번호
	private Long startRow;
	// row 끝 번호
	private Long lastRow;
	
	// ---------- JSP 변수 ----------
	// 페이징 시작번호
	private Long startNum;
	// 페이징 끝번호
	private Long lastNum;
	
	// 이전 블럭
	private boolean pre;
	// 다음 블럭
	private boolean next;
	
	// ---------- 검색 사용 변수 ----------
	private String search;
	private String kind;
	
	// 시작번호와 끝번호 계산
	public void makeRow() {
		this.startRow = (this.getPage() - 1) * this.getPerPage() + 1;
		this.lastRow = this.getPage() * this.getPerPage();
	}
	
	// JSP 번호 계산
	public void makeNum(Long totalCount) {
		// 1. 전체 Row의 갯수
		
		// 2. 전체 Page의 갯수 구하기
		// 전체 페이지 = 전체 Row 갯수 / 페이지당 보여줄 Row의 갯수
		Long totalPage = totalCount / this.getPerPage();	
		// ex) 전체 페이지가 52면 6page가 필요
		if(totalCount % this.getPerPage() != 0) {
			totalPage++;
		}
		
		// 3. 블럭당 갯수
		Long perBlock = 10L;	// 한 페이지에 페이징번호 10개씩 출력
		
		// 4. 전체 Block의 갯수 구하기
		// 전체 블럭 갯수 = 전체 페이지 / 블럭당 갯수
		Long totalBlock = totalPage / perBlock;
		// 나머지가 존재할 때
		if(totalPage % perBlock != 0) {
			totalBlock++;
		}
		
		// 5. Page번호로 현재 몇 번째 Block인지 계산
		// 1번 block : 1 - 10
		// 2번 block : 11 - 20
		
		// page			BLOCK
		//	1			1
		//	2			1
		// ...
		// 	9			1
		// 10			1
		// 11			2
		// ...
		// 20			2
		// 21			3
		
		// 현재 Block = 페이지 번호 / 블럭당 갯수
		Long curBlock = this.getPage() / perBlock;
		// 현재 블럭이 블럭당 갯수로 나눠 떨어지지 않으면
		if(this.getPage() % perBlock != 0) {
			curBlock++;
		}
		
		// 6. curBlock로 StartNum, lastNum 구하기
		//	curBlock	startNum	lastNum
		//	1			1			10
		//	2			11			20
		
		// (현재 블럭 - 1) * 블럭당 갯수 + 1
		this.startNum = (curBlock - 1) * perBlock + 1;
		// 현재 블럭 * 블럭당 갯수
		this.lastNum = curBlock * perBlock;
		
		// 7. 이전, 다음 블럭 유무 확인
		
		this.pre = false;
		// 현재 블럭 > 1
		// 현재 block이 2, 3, 4...
		if(curBlock > 1) {
			this.pre = true;
		}
		
		this.next = false;
		// 다음 블럭이 더 있을 때
		// 전체 블럭 > 현재 블럭
		if(totalBlock > curBlock) {
			this.next = true;
		// 현재 블럭이 마지막 블럭번호랑 같다면
		} else if (curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
	}
	
	public Long getPerPage() {
		// Reference Type의 기본값은 null
		if(this.perPage == null || this.page < 1) {
			this.perPage = 10L;
		}
		
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	
	public Long getStartRow() {
		return startRow;
	}
	
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	
	public Long getLastRow() {
		return lastRow;
	}
	
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public String getSearch() {
		// 검색어가 없으면 serch = null
		if(this.search == null) {
			this.search = "";
		}
		
//		this.search = "%" + search + "%";
		
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
	
}
