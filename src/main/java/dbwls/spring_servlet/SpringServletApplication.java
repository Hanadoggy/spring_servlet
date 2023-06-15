package dbwls.spring_servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan // 서블릿 자동 등록
@SpringBootApplication
public class SpringServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServletApplication.class, args);
	}

//	스프링부탁 자동으로 view Resolver를 등록, application.properties에 등록된 prefix, suffix 사용
//	@Bean
//	InternalResourceViewResolver internalResourceViewResolver() {
//		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
//	}
}
