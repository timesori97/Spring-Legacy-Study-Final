package www.silver.dao;



import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import www.silver.VO.MemberVO;

@Repository   
public class MemberDAOImpl implements IF_MemberDAO{
	@Inject
	private SqlSession sqlsession;
	@Override
	public void insertMember(MemberVO mvo) {
		
		sqlsession.insert("www.silver.dao.IF_MemberDAO.insertone", mvo);
	}
	@Override
	public MemberVO selectOne(String id) {
		
		MemberVO m = sqlsession.selectOne("www.silver.dao.IF_MemberDAO.selectOne", id);
		return m;
	}
	@Override
	public List<MemberVO> selectall() {
		
		List<MemberVO> mlist = sqlsession.selectList("www.silver.dao.IF_MemberDAO.selectall");
		return mlist;
	}
	@Override
	public void attachFname(String filename) {
		sqlsession.insert("www.silver.dao.IF_MemberDAO.kuser_attach",filename);
		
	}
	@Override
	public List<String> getAttach(String no) {
		
		return sqlsession.selectList("www.silver.dao.IF_MemberDAO.getAttach", no);
	}

}
