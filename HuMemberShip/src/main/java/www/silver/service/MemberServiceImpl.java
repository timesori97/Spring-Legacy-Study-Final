package www.silver.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import www.silver.VO.MemberVO;
import www.silver.dao.IF_MemberDAO;

@Service 
public class MemberServiceImpl implements IF_memberService{
	@Inject
	IF_MemberDAO memberdao;
	
	@Override
	@Transactional
	public void addUser(MemberVO membervo) {
		// 1. 글저장
		memberdao.insertMember(membervo);
		// 2. 첨부파일
		String[] fname = membervo.getFilename();
		for(int i=0; i<fname.length; i++) {
			if(fname[i]!=null) {
				// fname[i]를 첨부파일 테이블에 insert한다.
				// System.out.println(fname[i] + "를 첨부파일 테이블에 insert한다");
				// kuser_attach table에 추가 하자..
				memberdao.attachFname(fname[i]);
			}
		}
	}	
	@Override
	@Transactional(readOnly = true)
	public MemberVO viewUser(String id) {  
		
		
		MemberVO m = memberdao.selectOne(id);
		return m;
	}
	@Override
	@Transactional(readOnly = true)
	public MemberVO viewDetail(String id) {
		   
		MemberVO m = memberdao.selectOne(id);
		return m;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<MemberVO> allMember() {
		//System.out.println("allMember call");
		List<MemberVO> mlist = memberdao.selectall();
		return mlist;		
	}
	@Override
	@Transactional(readOnly = true)
	public List<String> getAttach(String no) {
		
		return memberdao.getAttach(no);
	}
	

}
