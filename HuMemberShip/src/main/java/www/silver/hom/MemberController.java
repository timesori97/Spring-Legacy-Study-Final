package www.silver.hom;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import www.silver.VO.BBSVO;
import www.silver.VO.MemberVO;
import www.silver.service.IF_memberService;
import www.silver.util.FileDataUtil;

@Controller
public class MemberController {
	@Inject
	IF_memberService memberservice;	
	@Inject
	FileDataUtil filedatautil;	
	@RequestMapping(value = "/memberjoind", method = RequestMethod.POST)
	public String memberjoind(@ModelAttribute MemberVO membervo, MultipartFile[] file) throws Exception{  // vo로 받을 때 클라이언트의 변수명과 일치하면 자동 매핑
		String[] filename = filedatautil.fileUpload(file);
		System.out.println(filename[0]+"/"+filename[1]);
		//System.out.println(membervo.getId()+"/"+membervo.getName());	
		/*
		 * 첨부파일 디버깅 용
		System.out.println(file.length +"개의 첨부파일이 업로드 되었습니다");
		for(int i=0; i< file.length; i++) {
			System.out.println(i+"번 째 파일명 : "+file[i].getOriginalFilename());
			System.out.println(i+"번 째 파일 사이즈 : "+file[i].getSize());
			System.out.println(i+"번 째 파일  타입 : "+file[i].getContentType());			
		}*/
		membervo.setFilename(filename);
		memberservice.addUser(membervo);
		return "redirect:/allmember";
		
	
		
		
	}
	
	@RequestMapping(value = "/memberjoin", method = RequestMethod.GET)
	public String memberjoin() {
		return "/member/memberjoinF";  // return "" ""는 문자열이다. 클라이언트할때는 전송할때는 문자열이아닌
		                                // 뷰의 이름이다.  컨트롤러에서 처리하기때문에...
	}
	@GetMapping("/allmember")
	public String allmember(Model model) {
		List<MemberVO> mlist = memberservice.allMember();
		System.out.println(mlist.size() +"명 가져옴");
		model.addAttribute("memberlist", mlist);
		return "member/list";  //뷰이름을 아직 결정하지 않아서 null로 잠시 둠..
	}
	@GetMapping("/view")
	public String view(@RequestParam("id") String id, Model model) {
		MemberVO mvo = memberservice.viewDetail(id);
		// select * from kuser where id=?  작업을 원하는 것이고. 이 쿼리는 한 개의 튜플을 리턴 , VO에 저장해서 가지고 온다.
		model.addAttribute("member", mvo);
		// 첨부파일 가져오면 된다.. 
		List<String> attachList = memberservice.getAttach(mvo.getNo());
		model.addAttribute("attachList", attachList);
		return "member/viewMember";
	}
	
	
	@RequestMapping(value = "/duplexid", method = RequestMethod.GET)
	@ResponseBody   //동기, 비동기,,  스프링에서 
	public String duplexid(@RequestParam("id") String id) { 
		System.out.println(id +"dddddddddddd");
		//DB 작업 필요  select * from kuser where id=?
		MemberVO m = memberservice.viewUser(id);  // 서비에게 디비 조회 시킨다.
		String rev_id=null;  // 클라이언트에게 응답할 메시지
		if(m == null) {  // null이라면 일치된 아이디가 없다.
			rev_id=id;   // 클라이언트에게 아이디를 값으로 리턴해 주겠다
		}else {           //null이 아니기 때문에 해당 아이디가 있다..
			rev_id="";   // 클라이언트에게 ""넘긴다.
		}
		return rev_id;   //id타입이 string이다.. 이 타입 그대로 응답.
	}

}
