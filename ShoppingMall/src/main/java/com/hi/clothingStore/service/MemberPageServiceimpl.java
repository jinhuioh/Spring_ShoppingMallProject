package com.hi.clothingStore.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hi.clothingStore.dao.MemberDAO;
import com.hi.clothingStore.dao.ReviewDAO;
import com.hi.clothingStore.vo.MemberVO;
@Service
public class MemberPageServiceimpl implements MemberPageService{
// 	!페이징처리!----------------------------------------------------------------------
	
	@Inject
	private MemberDAO dao;
//	// 페이지리스트
//	@Override
//	public List<MemberVO> getList(MemberVO searchVo) {
//		return dao.getList(searchVo);
//	}
	// 페이지 총 개수
	// MemberDAO에 있는 getListCnt에 들어있는 vo를 리턴
	@Override
	public int getListCnt(MemberVO vo) {
		return dao.getListCnt(vo);
	}
}
