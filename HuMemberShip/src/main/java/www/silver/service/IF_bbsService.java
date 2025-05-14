package www.silver.service;

import java.util.List;

import www.silver.VO.BBSVO;
import www.silver.VO.PageVO;

public interface IF_bbsService {
	
	public void inserbbs(BBSVO bbsvo);
	public List<BBSVO> selectall(PageVO pagevo);
	public int getTotalCnt();
	public void delete(String no);
	public BBSVO mod(String no);
	public void update(BBSVO bbsvo);

}
