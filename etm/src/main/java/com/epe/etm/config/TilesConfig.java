package com.epe.etm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class TilesConfig {

	@Bean
	public TilesConfigurer tilesConfigurer(){
		final TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] {"/WEB-INF/tiles/tilesDef.xml"});
		configurer.setCheckRefresh(true);
		return configurer;
	}
	
	@Bean
	public TilesViewResolver tilesViewResolver(){
		TilesViewResolver resolver = new TilesViewResolver();
		resolver.setOrder(1);
		return resolver;
	}
	
}
