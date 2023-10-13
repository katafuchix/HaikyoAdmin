package com.example.haikyo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class CustomWebMvcConfigurationSupport extends WebMvcConfigurationSupport {
	
	@Bean
	public PageRequest defaultPageRequest() {
		return PageRequest.of(0, 100);
	}

	@Override
	protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		SortHandlerMethodArgumentResolver argumentResolver = new SortHandlerMethodArgumentResolver();
		argumentResolver.setSortParameter("sort");
		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver(argumentResolver);
		resolver.setFallbackPageable(defaultPageRequest());
		// ページ番号を1から
		resolver.setOneIndexedParameters(true);
		resolver.setPageParameterName("page");
		resolver.setSizeParameterName("size");
		    argumentResolvers.add(resolver);
	}
	
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
			"classpath:/META-INF/resources/", "classpath:/resources/",
			"classpath:/static/", "classpath:/public/" };

    @Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (!registry.hasMappingForPattern("/webjars/**")) {
			registry.addResourceHandler("/webjars/**")
					.addResourceLocations("classpath:/META-INF/resources/webjars/");
		}
		if (!registry.hasMappingForPattern("/**")) {
			registry.addResourceHandler("/**")
					.addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
		}
	}
}
