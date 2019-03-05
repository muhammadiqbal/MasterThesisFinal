package com.iqbal.masterthesis.cargomailparser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

/**
 * SpringMVCConfiguration
 */
@Configuration
@ComponentScan("com.iqbal.masterthesis.cargomailparser")
public class SpringMVCConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
       SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
       templateResolver.setApplicationContext(applicationContext);
       templateResolver.setSuffix(".html");
       templateResolver.setTemplateMode("HTML");
       return templateResolver;
    }
 
    /*
     * STEP 2 - Create SpringTemplateEngine
     * */
    @Bean
    public SpringTemplateEngine templateEngine() {
       SpringTemplateEngine templateEngine = new SpringTemplateEngine();
       templateEngine.setTemplateResolver(templateResolver());
       templateEngine.setEnableSpringELCompiler(true);
       return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("WebMvcConfigurer - addResourceHandlers() function get loaded...");
        registry.addResourceHandler("/resources/static/**")
                .addResourceLocations("/resources/");

        // registry
        //     .addResourceHandler("/js/**")
        //     .addResourceLocations("/js/")
        //     .setCachePeriod(3600)
        //     .resourceChain(true)
        //     .addResolver(new GzipResourceResolver())
        //     .addResolver(new PathResourceResolver());
        
    }
}