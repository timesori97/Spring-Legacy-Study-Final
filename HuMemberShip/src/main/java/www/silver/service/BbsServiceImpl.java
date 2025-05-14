package www.silver.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import www.silver.VO.BBSVO;
import www.silver.VO.PageVO;
import www.silver.dao.IF_bbsDAO;

@Service
public class BbsServiceImpl implements IF_bbsService{
	
	@Inject
	IF_bbsDAO dao;
	
	@Override
	public void inserbbs(BBSVO bbsvo) {
		dao.insertbbs(bbsvo);
		
		String[] t = bbsvo.getFnames();
		System.out.println("글등록 서비스 "+t.length);
		for(int i=0; i< t.length; i++) {
			System.out.println(i+"/"+t[i]);
			if(t[i]!=null) {
				System.out.println("첨부파일등록 서비스");
				dao.insertAttach(t[i]);
			}
		}
	}

	@Override
	public List<BBSVO> selectall(PageVO pagevo) {
		
		return dao.selectall(pagevo);
	}

	@Override
	public int getTotalCnt() {
		
		return dao.getTotalCnt();
	}

	@Override
	public void delete(String no) {
		
		dao.delete(no);
	}

	@Override
	public BBSVO mod(String no) {
		
		return dao.getOne(no);
	}

	@Override
	public void update(BBSVO bbsvo) {
		
		dao.update(bbsvo);
	}

}
