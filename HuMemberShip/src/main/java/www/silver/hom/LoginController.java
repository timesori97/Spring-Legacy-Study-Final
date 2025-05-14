package www.silver.hom;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import www.silver.VO.MemberVO;
import www.silver.service.IF_memberService;

@Controller
public class LoginController {
	
	@Inject
	IF_memberService memberservice;	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String modsave(@RequestParam("id") String id, 
			@RequestParam("pass") String pass,
			HttpServletRequest request) {
		// select * from kuser where id=? 결과값을 리턴받아서 비밀번호 일치 유무 판단..
		System.out.println("login controller "+id+"/"+pass);
		MemberVO  mvo = memberservice.viewDetail(id);
		//System.out.println(" database result "+mvo.getId()+"/"+mvo.getPass());
		// 비밀번호 일치 판단
		if(mvo != null) {
			if(pass.equals(mvo.getPass())) {
				//비밀번호까지 일치 함.
				//세션에 값을 저장할 것인다.. 아이디와 전화번호를 저장해 본다..				
				HttpSession session = request.getSession();
				if(session.getAttribute("userid")!=null){
					session.removeAttribute("userid");  // 세션의 변수의 값을 삭제
				}
				session.setAttribute("userid", mvo.getId());
				session.setAttribute("usertel", mvo.getTel());
			}
		}
		
		return "redirect:/";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String modsave(HttpSession session) {
		session.invalidate();  //세션 날려라..
		return "redirect:/";
	}

}
