package www.silver.VO;

public class PageVO {
	private int startNo;  // 페이지에 출력될 처음 번호
	private int endNo;   // 페이지에 출력 될 마지막 번호.
	
	private int perPageNum=10;   // page에 출력 될 게시글 수
	private Integer page;  //  Integer는 객체타입이라서  null을 가질 수 있다.
	                   // 클라이언트가 보내는 파라미터는 모두 문자이므로 만약 파라미터가 없다면 
	                   // 그것은 문자로  page변수에 저장이 된다  page=null;   이것이 허용 되려면
	                     // 타입이 정수이면 안된다.
	private int totalCount;  // 게시판 전체 글의 수
	
	private int endPage;     // 페이지 그룹의 마지막
	private int startPage;   // 페이지 그룹의 시작.. 만약 1번 페이지라면 [1][2][3]...[10]
	
	private boolean prev;    // 이전 페이지 그룹이 있으냐?
	private boolean next;    // 다음 페이지 그룹이 있느냐?
	
	private String searchType;
	private String searchKeyword;

	public int getEndNo() {
		return endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	private void calcPage() {
		startNo = (this.page - 1) * perPageNum +1; 
		int tempEnd = (int) (Math.ceil(page / (double) this.perPageNum) * this.perPageNum);
		this.startPage = (tempEnd - this.perPageNum) + 1;		
		if (tempEnd * this.perPageNum > this.totalCount) {			
			this.endPage = (int) Math.ceil(this.totalCount / (double) this.perPageNum);			
			if(endPage!=page) {
				this.endNo = startNo + this.perPageNum - 1;	
			}else {
				this.endNo = startNo + this.totalCount % 10 - 1;
			}
		} else {			
			this.endPage = tempEnd;
			this.endNo = startNo + this.perPageNum - 1;
		}
		
		this.prev = this.startPage != 1;
		this.next = this.endPage * this.perPageNum < this.totalCount;
		
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcPage();
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public int getStartNo() {

		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
}