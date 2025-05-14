package www.silver.dao;

import java.util.List;

import www.silver.VO.BBSVO;
import www.silver.VO.PageVO;

public interface IF_bbsDAO {
	public void insertbbs(BBSVO bbsvo);
	public void insertAttach(String filename);
	public List<BBSVO> selectall(PageVO pagevo);
	public int getTotalCnt();
	public void delete(String no);
	public BBSVO getOne(String no);
	public void update(BBSVO bbsvo);
}
