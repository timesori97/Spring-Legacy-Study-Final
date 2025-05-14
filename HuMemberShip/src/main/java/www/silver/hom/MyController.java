package www.silver.hom;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@Resource(name="cname")  
	String name; 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		System.out.println("Name : "+name);
		return "index";
	}	
	@RequestMapping(value = "/t", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> home1() {
		HashMap<String, String> a = new HashMap<String, String>();
		a.put("a", "aaaa");
		a.put("b", "aaaa");		
		return a;
	}

}
