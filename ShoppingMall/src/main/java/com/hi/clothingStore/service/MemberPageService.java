package com.hi.clothingStore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hi.clothingStore.vo.MemberVO;
@Service
public interface MemberPageService {
//	//	페이지 list 가져오기
//	List<MemberVO> getList(MemberVO vo) throws Exception;
	//	컨트롤러로 넘겨 줄 getListCnt안에 vo가방
	//	페이지 총 개수 가져오기
	
	int getListCnt(MemberVO vo) throws Exception;	
}
