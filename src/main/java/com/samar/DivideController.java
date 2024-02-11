package com.samar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.samar1mvc.AddService;

@Controller

public class DivideController {

@RequestMapping("/divide")
    
	public ModelAndView divide(HttpServletRequest request,HttpServletResponse response)
    {
	    float i3 = Float.parseFloat(request.getParameter("v1"));
	    float j3 = Float.parseFloat(request.getParameter("v2"));
		
	    AddService as3 = new AddService();
		float k3 = as3.divide(i3, j3);
			
		ModelAndView mv3 = new ModelAndView();
		mv3.setViewName("Display3.jsp");
		mv3.addObject("Result",k3);
    	
		return mv3;
    }
}
