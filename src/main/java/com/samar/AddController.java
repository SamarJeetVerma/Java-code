package com.samar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.samar1mvc.AddService;

@Controller

public class AddController 
{
	@RequestMapping("/add")
    
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response)
    {
		float i = Float.parseFloat(request.getParameter("s1"));
		float j = Float.parseFloat(request.getParameter("s2"));
		
	
		AddService as = new AddService();
		float k = as.add(i, j);
			
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Display.jsp");
		mv.addObject("Result",k);
    	
		return mv;
    }

}
