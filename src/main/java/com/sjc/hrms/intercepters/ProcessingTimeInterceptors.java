package com.sjc.hrms.intercepters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ProcessingTimeInterceptors extends HandlerInterceptorAdapter {
//    preHandle() : Before a request is handled by a request handler.
//    postHandle() : After a request is handled by a request handler. It gives access to the returned ModelAndView object, so you can manipulate the model attributes in it.
//    afterCompletion() : After the completion of all request processing i.e. after the view has been rendered.
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle  ProcessingTimeInterceptors!!");
		long startTime = (Long) request.getAttribute("startTime");
		request.removeAttribute("startTime");

		long endTime = System.currentTimeMillis();
		modelAndView.addObject("totalTime", endTime - startTime);

		System.out.println("Request Prcessing Time :: " + (endTime - startTime));
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exceptionIfAny) throws Exception {
		System.out.println("View Rendered !!");
	}
}
