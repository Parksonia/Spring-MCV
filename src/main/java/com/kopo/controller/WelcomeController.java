package com.kopo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	
	@RequestMapping(value ="/home", method=RequestMethod.GET)
		public String welcome(Model model) {
		model.addAttribute("hello","Welcome to WebtoonPage"); //hello,strapline 속성에 값 저장
		model.addAttribute("strapline","Welcome to Webtoon Mall!");
		return "welcome"; //"welcome"이라는 jsp로 이동 ,리턴됨
		
	}	
}
