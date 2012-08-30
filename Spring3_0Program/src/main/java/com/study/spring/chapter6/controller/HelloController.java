package com.study.spring.chapter6.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.spring.chapter6.vo.HelloVo;
import com.study.spring.chapter6.vo.OrderCommand;
import com.study.spring.chapter6.vo.OrderItem;

@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		
		ModelAndView mav = new ModelAndView(); // 뷰로 반환히기 위한 객체 생성
		mav.setViewName("chapter6/hello"); // 뷰 이름
		mav.addObject("greeting", getGreeting()); // 뷰로 전달할 객체
		
		return mav;
		
	}
	
	@RequestMapping("/hello2.do")
	public ModelAndView hello2(HelloVo helloVo) {
		ModelAndView mav = new ModelAndView(); // 뷰로 반환히기 위한 객체 생성
		
		// form 객체를 통해 파라미터를 보낼 때 위 메서드의 인자값으로 자동 매칭하여 받을 수 있다.
		System.out.println(helloVo.getTitle());
		System.out.println(helloVo.getContent());
		System.out.println(helloVo.getParentId());

		mav.setViewName("chapter6/hello"); // 뷰 이름
		mav.addObject("greeting", getGreeting()); // 뷰로 전달할 객체
		
		return mav;
	}
	
	@RequestMapping("/hello3.do")
	public ModelAndView hello3(@ModelAttribute("hello") HelloVo helloVo) {
		ModelAndView mav = new ModelAndView(); // 뷰로 반환히기 위한 객체 생성
		
		// form 객체를 통해 파라미터를 보낼 때 위 메서드의 인자값으로 자동 매칭하여 받을 수 있다.
		System.out.println(helloVo.getTitle());
		System.out.println(helloVo.getContent());
		System.out.println(helloVo.getParentId());

		mav.setViewName("chapter6/hello3"); // 뷰 이름
		mav.addObject("greeting", getGreeting()); // 뷰로 전달할 객체
		
		return mav;
	}
	
	@RequestMapping("/order.do")
	public ModelAndView order(OrderCommand orderCommend) {
		ModelAndView mav = new ModelAndView(); // 뷰로 반환히기 위한 객체 생성

		List<OrderItem> orderList = orderCommend.getOrderItems();
		int orderCnt = orderList.size();
		
		System.out.println("orderCount : " + orderCnt);
		
		if (orderCnt > 0) {
			for (int i=0; i<orderCnt; i++) {
				OrderItem orderItem = orderList.get(i);
				
				System.out.println("orderItem.getItemId()" + orderItem.getItemId());
				System.out.println("orderItem.getNumber()" + orderItem.getNumber());
				System.out.println("orderItem.getRemark()" + orderItem.getRemark());
			}
		}
		

		mav.setViewName("chapter6/order"); // 뷰 이름
		mav.addObject("greeting", getGreeting()); // 뷰로 전달할 객체
		
		return mav;
	}
	
	private String getGreeting() {
		
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		
		if (hour >= 6 && hour <= 10) {
			return "좋은 아침이에요^^";
		} else if (hour >= 12 && hour <= 15) {
			return "점심 먹었심?";
		} else if (hour >= 18 && hour <= 22) {
			return "굿나잇";
		}
		
		return "안녕하세요";
	}
}
