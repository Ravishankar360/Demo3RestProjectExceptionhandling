package com.spring.Demo.Demo3RestProjectExcptionHandling;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.Demo.Demo3RestProjectExcptionHandlingApplication;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Demo3RestProjectExcptionHandlingApplication.class);
	}

}
