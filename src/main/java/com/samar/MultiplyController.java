package com.samar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.samar1mvc.AddService;

@Controller

public class MultiplyController {

@RequestMapping("/multiply")
    
	public ModelAndView multiply(HttpServletRequest request,HttpServletResponse response)
    {
	    float i2 = Float.parseFloat(request.getParameter("u1"));
	    float j2 = Float.parseFloat(request.getParameter("u2"));
		
	    AddService as2 = new AddService();
		float k2 = as2.multiply(i2, j2);
			
		ModelAndView mv2 = new ModelAndView();
		mv2.setViewName("Display.jsp");
		mv2.addObject("Result",k2);
    	
		return mv2;
    }
}
