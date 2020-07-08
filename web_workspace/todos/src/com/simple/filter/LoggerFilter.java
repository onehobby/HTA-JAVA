package com.simple.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoggerFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// 전처리 작업
		HttpServletRequest httpReq = (HttpServletRequest) request;
		String requestURI = httpReq.getRequestURI();
		String ipAddr = httpReq.getRemoteAddr();

		long startTime = System.currentTimeMillis();
		System.out.println("["+ipAddr+"] 클라이언트의 요청을 받음");
		System.out.println("["+requestURI+"] 요청에 대한 처리를 시작함");
		
		chain.doFilter(request, response); // 다음번 필터와의 연결고리, 반드시 다음 필터와 연결해주어야하고 마지막 필터일 경우 톰캣이 servlet or JSP를 실행시킨다.
										   // chain.doFilter 실행을 시켜주지 않으면 다음번 필터와 연결되지않고 그 후 작업(FrontController > Controller 등)이 실행되지 않는다.
										   // chain.doFilter메소드 위아래 위치에 따라 전처리, 후처리 작업이 나뉜다.
		// 후처리 작업
		long endTime = System.currentTimeMillis();
		long workingTime = endTime - startTime;
		
		System.out.println("소요시간 : " + workingTime + "밀리초");
		System.out.println("["+requestURI+"] 요청에 대한 처리르 종료함\n");
		
	}

}
