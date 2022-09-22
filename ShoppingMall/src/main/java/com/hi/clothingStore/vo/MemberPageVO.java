//Pagination 작업이 끝났으면 Pagination을 받아줄 변수가 필요.
//MemberVO에서 직접 받는 것보다 PageVO란 클래스를 만들어 MemberVO에 상속한 다음 사용.
//MemberVO에 extends해서 사용.
package com.hi.clothingStore.vo;

public class MemberPageVO {
	private int pageIndex = 1;// 현재 페이지 인덱스
	private int pageUnit = 10;// 한 페이지에 들어가는 인원 수=10으로 지정
	private int pageSize = 10;// 페이지 사이즈
	private int start = 0; // xml에 쓰일 회원 페이징 객체. 첫번째 회원인덱스 예) 인덱스가 0 이면 0부터 10인덱스까지 한 페이지에 보여주도록 구현 
	private int firstIndex = 0;// 첫번째 회원인덱스=0번째 인덱스부터 시작 
	private int recordCountPerPage = 10;// 회원 10명씩 카운트
	private int totCnt = 0;// 회원 총 인원수
	private int startDate = 0;// 시작데이터
	private int endDate = 0;// 종료 데이터
	private int realEnd = 0;// 페이징 마지막 숫자
	private boolean prev, next;// 이전, 다음버튼
	
	//getters and setters(외부로부터 데이터를 보호하기 위함)
	public int getPageIndex() {
		return pageIndex;
	}
	
	// start객체(회원 첫 인덱스 순서)--------------------------------
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
		this.start = (pageIndex -1)*pageSize;
	}
	public int getPageUnit() {
		return pageUnit;
	}
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}
	public int getPageSize() {
		return pageSize;
	}
	// start객체(회원 첫 인덱스 순서)--------------------------------
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.start = (pageIndex-1)*pageSize;
	}
	public int getFirstIndex() {
		return firstIndex;
	}
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}
	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}
	public int getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(int totCnt) {
		this.totCnt = totCnt;
	}
	public int getStartDate() {
		return startDate;
	}
	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}
	public int getEndDate() {
		return endDate;
	}
	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}
	public int getRealEnd() {
		return realEnd;
	}
	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	

}
