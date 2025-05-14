package www.silver.service;
import java.util.List;

import www.silver.VO.MemberVO;
public interface IF_memberService {	
	public void addUser(MemberVO membervo);	
	public MemberVO viewUser(String id);  
	public List<MemberVO> allMember();
	public MemberVO viewDetail(String id); 
	public List<String> getAttach(String no);
}
