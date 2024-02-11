package com.samar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.samar1mvc.AddService;

@Controller

public class SubtractController {

	@RequestMapping("/subtract")
    
	public ModelAndView subtract(HttpServletRequest request,HttpServletResponse response)
    {
		float i1 = Float.parseFloat(request.getParameter("t1"));
		float j1 = Float.parseFloat(request.getParameter("t2"));
		
		AddService as1 = new AddService();
		float k1 = as1.subtract(i1, j1);
			
		ModelAndView mv1 = new ModelAndView();
		mv1.setViewName("Display1.jsp");
		mv1.addObject("Result",k1);
    	
		return mv1;
    }

}
