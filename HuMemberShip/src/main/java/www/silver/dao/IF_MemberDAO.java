package www.silver.dao;

import java.util.List;

import www.silver.VO.MemberVO;

public interface IF_MemberDAO {
	
	
	
	public void insertMember(MemberVO mvo);
	public MemberVO selectOne(String id);
	public List<MemberVO> selectall();
	public void attachFname(String filename);
	public List<String> getAttach(String no);  //첨부파일이 여러개 일 수도 있다.

}
