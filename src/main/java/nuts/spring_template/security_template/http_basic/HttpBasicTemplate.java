package nuts.spring_template.security_template.http_basic;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class HttpBasicTemplate {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(basic -> basic
                .realmName("security") // 인증 영역 이름 설정
                .authenticationEntryPoint((request, response, authException) -> {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 상태 코드 설정
                    response.setContentType("application/json");
                    response.getWriter().write("{\"error\": \"Unauthorized\"}"); // JSON 응답 반환
                })
        );
        return http.build(); // SecurityFilterChain 객체 반환
    }

}
