package www.silver.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import www.silver.VO.BBSVO;
import www.silver.VO.PageVO;

@Repository
public class BbsDAOImpl implements IF_bbsDAO{
	@Inject
	SqlSession sqlsession;
	final private  String mapper = "www.silver.dao.IF_bbsDAO";
	@Override
	public void insertbbs(BBSVO bbsvo) {
		sqlsession.insert(mapper+".insertOne", bbsvo);		
	}
	@Override
	public void insertAttach(String filename) {
		
		System.out.println("첨부파일 저장  dao");
		sqlsession.insert(mapper+".insertAttach", filename);
	}
	@Override
	public List<BBSVO> selectall(PageVO pagevo) {
		
		return sqlsession.selectList(mapper+".selectall", pagevo);
	}
	@Override
	public int getTotalCnt() {
		
		return sqlsession.selectOne(mapper+".totalcnt");
	}
	@Override
	public void delete(String no) {
		
		sqlsession.delete(mapper+".deleteone",no);
	}
	@Override
	public BBSVO getOne(String no) {
		
		return sqlsession.selectOne(mapper+".selectone",no);
	}
	@Override
	public void update(BBSVO bbsvo) {
		
		sqlsession.update(mapper+".update", bbsvo);
		
	}

}
