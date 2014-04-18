package org.wry.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*  
 * @RequestMapping 方法的返回类型 
 *      ModelAndView  
 *      Model 
 *      A Map object for exposing a model 
 *      View  
 *      String 指定view name 
 *      void if the method handles the response itself 
 *      If the method is annotated with @ResponseBody,the return type is written to the response HTTP body 
 * redirect, forward跳转 
 *      使用"redirect:"前缀,如 "redirect:/view"  
 *      相应地使用"forward:"前缀表示servlet内部跳转 
 * Handling a file upload in a form 
 *      使用@RequestParam("file") MultipartFile file获取上传的文件   
 */
@Controller
public class LoginController {
	@RequestMapping(value = "/login.do", method = { RequestMethod.GET,RequestMethod.POST })
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {
		String email = request.getParameter("email");
		String passWord = request.getParameter("passWord");
		// String nowTime = DateUtil.dateFormat(new Date(),
		// DateFormatConstants.DAY_MONTH_YEAR_HOUR_MIN_SEC);
		String nowTime = new Date().toString();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("email", email);
		modelMap.put("passWord", passWord);
		modelMap.put("nowTime", nowTime);

		ModelMap modelMap2 = new ModelMap();
		modelMap2.addAttribute("email", email);
		modelMap2.addAttribute("passWord", passWord);
		modelMap2.addAttribute("nowTime", nowTime);

		/*
		 * 返回ModelAndView对象，常见的几种方式 view-返回网页名称，在springMVC文件中已经配置了前缀和后缀
		 * model数据可以直接用键值对，也可用hashmap、modelmap以及addobject的方式
		 */
		// return new ModelAndView("index","nowTime",nowTime);
		// return new ModelAndView("index",modelMap);
		// return new ModelAndView("index",modelMap2);
		return new ModelAndView("index").addObject("email", email)
				.addObject("passWord", passWord).addObject("nowTime", nowTime);
	}
}
