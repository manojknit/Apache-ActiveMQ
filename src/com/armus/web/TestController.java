package com.armus.web;

import com.armus.queue.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

  
    @RequestMapping(value = "/send")
    public ModelAndView send(@RequestParam(value="message", required=false) String messageParam) 
    {
    	ModelAndView modelAndView = new ModelAndView("send");
    	TestSender sender = (TestSender) AppContext.getApplicationContext().getBean("testSender");
    	sender.send(messageParam);
    	modelAndView.addObject("msg",messageParam);
		return modelAndView;
    }
    
    @RequestMapping(value = "/receive")
    public ModelAndView receive() 
    {
    	TestReceiver receiver = (TestReceiver) AppContext.getApplicationContext().getBean("testReceiver");
    	Object result = receiver.receive();
    	ModelAndView modelAndView = new ModelAndView("receive", "result", result);
		return modelAndView;
    }


   
}