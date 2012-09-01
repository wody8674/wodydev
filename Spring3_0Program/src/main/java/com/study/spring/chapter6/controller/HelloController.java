package com.study.spring.chapter6.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.spring.chapter6.vo.HelloVo;
import com.study.spring.chapter6.vo.OrderCommand;
import com.study.spring.chapter6.vo.OrderItem;
import com.study.spring.chapter6.vo.ValidatorVo;

@Controller
public class HelloController {
	
	@RequestMapping("/paraTest.do")
	public ModelAndView paraTest(@RequestParam("query") String query, @RequestParam(value = "p", defaultValue = "1") int page) {
		
		ModelAndView mav = new ModelAndView(); // 뷰로 반환히기 위한 객체 생성
		mav.setViewName("chapter6/paraTest"); // 뷰 이름
		mav.addObject("query", query);
		mav.addObject("page", page);
		
		return mav;
		
	}
	
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
	
	@RequestMapping("/process.do")
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView(); // 뷰로 반환히기 위한 객체 생성
		
		/* **********************************
		 * 서블릿 객체를 직접 사용할 때
		 * **********************************/
		
		return mav;
	}
	
	@RequestMapping("/process2.do")
	public ModelAndView process(HttpSession session) {
		ModelAndView mav = new ModelAndView(); // 뷰로 반환히기 위한 객체 생성
		
		/* **********************************
		 * 이미 있는 세션을 사용하거나 세션을
		 * 생성할 때 사용
		 * **********************************/
		
		return mav;
	}
	
	@RequestMapping("/stringReturn.do")
	public String stringReturn(ModelMap model) {
		
		// 에러남;;
		//model.addAttribute("return", "리턴되씀");
		//model.addObject("return2", "리턴되씀");
		
		return "chapter6/stringReturn";
	}
	
	@RequestMapping("chapter6/urlViewTest.do")
	public Map<String, Object> urlViewTest() {
		
		/* **********************************
		 * url을 통한 뷰 이름 자동 매칭
		 * **********************************/
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("maptest", "mapTestString");
		model.put("test", "testString");
		
		return model;
		
	}
	
	@RequestMapping("/hello/{query}/{page}/restful.do")
	public ModelAndView restFulTest(@PathVariable String query, @PathVariable int page) {

		/* ******************************************************************
		 * restful 서비스를 위한 REST 방식의 패턴을 적용하기 위한 방법
		 * ******************************************************************/
		
		ModelAndView mav = new ModelAndView(); // 뷰로 반환히기 위한 객체 생성
		mav.setViewName("chapter6/paraTest"); // 뷰 이름
		mav.addObject("query", query);
		mav.addObject("page", page);

		return mav;

	}
	
	@RequestMapping("/validator.do")
	public ModelAndView validator(@ModelAttribute("validator") ValidatorVo validatorVo, BindingResult result) {
		
		/* ******************************************************************
		 * validater test
		 * ******************************************************************/
		
		ModelAndView mav = new ModelAndView(); // 뷰로 반환히기 위한 객체 생성
		
		// validator
		new MemberInfoValidator().validate(validatorVo, result);
		
		// 검증 결과 에러 발생시 
		if (result.hasErrors()) {
			mav.setViewName("chapter6/validatorError");
			return mav;
		}
		
		mav.setViewName("chapter6/validator");
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
