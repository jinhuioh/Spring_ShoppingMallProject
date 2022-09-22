// 클래스 파일입니다.
// 관리자 아이디로 로그인시 회원 전체 조회 페이징 처리
package com.hi.clothingStore.vo;

public class MemberPajinationVO {
	private int currentPageNo;//현재 페이지 번호
	private int recordCountPerPage;//한 페이지 당 게시되는 게시물 수
	private int pageSize;//페이지 리스트에 게시되는 페이지 수
	private int totalRecordCount;//전체 게시물 수
	private int firstPageNoOnPageList;//페이지 리스트의 첫 페이지 번호=1
	private int lastPageNoOnPageList;//페이지 리스트의 마지막 페이지 번호=2
	private int firstRecordIndex;//페이징sql의 조건절에 사용되는 시작 row num
	private boolean xprev;//이전버튼
	private boolean xnext;//다음버튼
	private int realEnd;//페이징 마지막 숫자
	
//	Source-> getters and setters
	public int getCurrentPageNo() {
		return currentPageNo;
	}


	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}


	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}


	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getTotalRecordCount() {
		return totalRecordCount;
	}


	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	// 페이지 리스트의 첫 페이지 번호
	// 브라우저에서 1~10까지의 버튼을 생성하면 1이 첫 페이지가 되므로
	// 현재 페이지 번호에서 10을 나눈뒤 10을 곱해주자.
	// 마지막 페이지에서 -9를 빼주면 첫번째 페이지가 나온다
	public int getFirstPageNoOnPageList() {
		lastPageNoOnPageList = (int)(Math.ceil(currentPageNo/10.0))* 10;
		firstPageNoOnPageList = lastPageNoOnPageList -9;
		return firstPageNoOnPageList;
	}


	public void setFirstPageNoOnPageList(int firstPageNoOnPageList) {
		this.firstPageNoOnPageList = firstPageNoOnPageList;
	}

	// 페이지 리스트의 마지막 페이지 번호
	// 현재 페이지 번호에서 10.0을 나눈뒤에 10을 곱해준다.
	// 현재 페이지 번호가 10이하일 경우가 있기 때문에 realEnd변수에 다시 한 번 계산을 해주어야 한다.
	// 만약 realEnd변수가 마지막 페이지 번호보다 작을 경우 마지막 페이지 번호와 같도록 한다.
	public int getLastPageNoOnPageList() {
		lastPageNoOnPageList = (int)(Math.ceil(getCurrentPageNo()/10.0)) * 10;
		int realEnd = (int)(Math.ceil((getTotalRecordCount() * 1.0)/getRecordCountPerPage()));
		if(realEnd < lastPageNoOnPageList) {
			lastPageNoOnPageList = realEnd;
		}
		
		return lastPageNoOnPageList;
	}


	public void setLastPageNoOnPageList(int lastPageNoOnPageList) {
		this.lastPageNoOnPageList = lastPageNoOnPageList;
	}

	//sql에 사용될 firstRecordIndex은 (현재페이지 - 1) * 한 페이지당 게시되는 게시물 수 입니다.
	//ex) (5 - 1) * 10 = 40
	//페이징 sql의 조건절에 사용되는 시작 row num
	public int getFirstRecordIndex() {
		firstRecordIndex = (getCurrentPageNo() -1) * getRecordCountPerPage();
		return firstRecordIndex;
	}


	public void setFirstRecordIndex(int firstRecordIndex) {
		this.firstRecordIndex = firstRecordIndex;
	}

	// 이전버튼
	// 리스트의 첫 페이지 번호가 1보다 크면 보이도록 한다.
	public boolean getXprev() {
		xprev = getFirstPageNoOnPageList() > 1;
		return xprev;
	}


	public void setXprev(boolean xprev) {
		this.xprev = xprev;
	}

	// 다음버튼
	//다음 버튼은 realEnd변수를 구해서 리스트의 마지막 페이지 번호보다 크면 다음 버튼이 보이도록 한다.
	//realEnd = (5 * 1.0) * 20 = 100
	//if (lastPageNoOnPageList 의 결과 값 < realEnd ) = 다음 버튼 생성
	public boolean getXnext() {
		int realEnd = (int)(Math.ceil((getTotalRecordCount() * 1.0) / getRecordCountPerPage()));
		xnext = getLastPageNoOnPageList() < realEnd;
		return xnext;
	}


	public void setXnext(boolean xnext) {
		this.xnext = xnext;
	}

	// 페이징 마지막 숫자
	public int getRealEnd() {
		realEnd = (int)(Math.ceil((getTotalRecordCount() * 1.0) / getRecordCountPerPage()));
		return realEnd;
	}


	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}


	@Override
	public String toString() {
		return "MemberPajinationVO [currentPageNo=" + currentPageNo + ", recordCountPerPage=" + recordCountPerPage
				+ ", pageSize=" + pageSize + ", totalRecordCount=" + totalRecordCount + ", firstPageNoOnPageList="
				+ firstPageNoOnPageList + ", lastPageNoOnPageList=" + lastPageNoOnPageList + ", firstRecordIndex="
				+ firstRecordIndex + ", xprev=" + xprev + ", xnext=" + xnext + ", realEnd=" + realEnd
				+ ", getCurrentPageNo()=" + getCurrentPageNo() + ", getRecordCountPerPage()=" + getRecordCountPerPage()
				+ ", getPageSize()=" + getPageSize() + ", getTotalRecordCount()=" + getTotalRecordCount()
				+ ", getFirstPageNoOnPageList()=" + getFirstPageNoOnPageList() + ", getLastPageNoOnPageList()="
				+ getLastPageNoOnPageList() + ", getFirstRecordIndex()=" + getFirstRecordIndex() + ", getXprev()="
				+ getXprev() + ", getXnext()=" + getXnext() + ", getRealEnd()=" + getRealEnd() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

// Source -> override to string

	

	

}
