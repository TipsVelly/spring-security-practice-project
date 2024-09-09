package com.eazybytes.springsection2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    // Spring Security 설정을 위한 SecurityFilterChain Bean을 정의합니다.
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /**
         *  SecurityFilterChainConfiguration의 기본 보안 설정 원본
         *  - 이 설정은 모든 요청에 대해 인증을 요구합니다.
         *  - 기본적인 form 로그인과 HTTP Basic 인증을 사용합니다.
         */
        /*@Bean
        SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests((requests) -> {
                ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.anyRequest()).authenticated();
            });
            http.formLogin(Customizer.withDefaults());
            http.httpBasic(Customizer.withDefaults());
            return (SecurityFilterChain)http.build();
        }*/

        /**
         * Spring Security 최신 버전에 맞춘 리팩토링된 기본 보안 설정
         *  - 이 설정 역시 모든 요청에 대해 인증을 요구합니다.
         *  - 코드를 좀 더 간결하게 작성하여 기본 설정을 사용합니다.
         */
        /*@Bean
        SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(requests -> requests
                            .anyRequest().authenticated()
                    )
                    .formLogin(withDefaults())
                    .httpBasic(withDefaults());
            return http.build();
        }*/

        /**
         * 아래는 사용자 정의 보안 설정입니다.
         * - 특정 엔드포인트들에 대해 다른 보안 규칙을 설정할 수 있습니다.
         * - 인증이 필요한 경로와 접근이 허용된 경로를 구분하여 정의합니다.
         */
        /*http
                // HTTP 요청에 대한 인증/인가 규칙을 정의합니다.
                .authorizeHttpRequests(requests -> requests
                        // /myAccount, /myBalance, /myLoans, /myCards 경로에 대해 인증이 필요하도록 설정
                        .requestMatchers("/myAccount", "/myBalance", "myLoans", "myCards").authenticated()
                        // /notices, /contact 경로는 인증 없이 누구나 접근할 수 있도록 허용
                        .requestMatchers("/notices", "/contact").permitAll()
                )
                // 기본 폼 로그인을 사용하도록 설정 (로그인 페이지 및 처리)
                .formLogin(withDefaults())
                // HTTP Basic 인증 방식을 사용하도록 설정 (로그인 정보가 HTTP 헤더에 포함되어 전송)
                .httpBasic(withDefaults());

        // 설정된 SecurityFilterChain을 반환합니다.
        return http.build();*/

        /**
         * 모든 요청을 거부하는 설정
         * - 이 설정은 애플리케이션에 대한 모든 요청을 차단합니다.
         * - 테스트나 특정 시나리오에서 모든 접근을 제한할 때 유용합니다.
         */
        /*http
                // HTTP 요청에 대한 인증/인가 규칙을 정의합니다.
                .authorizeHttpRequests(requests -> requests
                        .anyRequest().denyAll()  // 모든 요청을 차단
                )
                // 기본 폼 로그인을 사용하도록 설정 (로그인 페이지 및 처리)
                .formLogin(withDefaults())
                // HTTP Basic 인증 방식을 사용하도록 설정 (로그인 정보가 HTTP 헤더에 포함되어 전송)
                .httpBasic(withDefaults());

        // 설정된 SecurityFilterChain을 반환합니다.
        return http.build();*/

        /**
         * 모든 요청을 허용하는 설정
         * - 이 설정은 애플리케이션에 대한 모든 요청을 허용합니다.
         * - 공용 웹사이트나 접근 제한이 필요 없는 서비스에 사용될 수 있습니다.
         */
        http
                // HTTP 요청에 대한 인증/인가 규칙을 정의합니다.
                .authorizeHttpRequests(requests -> requests
                        .anyRequest().permitAll()  // 모든 요청을 허용
                )
                // 기본 폼 로그인을 사용하도록 설정 (로그인 페이지 및 처리)
                .formLogin(withDefaults())
                // HTTP Basic 인증 방식을 사용하도록 설정 (로그인 정보가 HTTP 헤더에 포함되어 전송)
                .httpBasic(withDefaults());

        // 설정된 SecurityFilterChain을 반환합니다.
        return http.build();
    }
}
