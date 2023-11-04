package com.bora.app.config.security;


import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
//@RequiredArgsConstructor
//@EnableWebSecurity
public class SecurityConfig {
//
//    private final String baseUrl = "api/v1";
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
//                        authorizationManagerRequestMatcherRegistry
//                                .requestMatchers(HttpMethod.POST,this.baseUrl+"/registration").permitAll()
//                                .requestMatchers(HttpMethod.POST,this.baseUrl+"/login").permitAll()
//                                .anyRequest().authenticated()
//                )
//                .csrf(AbstractHttpConfigurer::disable)
//                .httpBasic((basic) -> basic
//                        .addObjectPostProcessor(new ObjectPostProcessor<BasicAuthenticationFilter>() {
//                            @Override
//                            public <O extends BasicAuthenticationFilter> O postProcess(O filter) {
//                                filter.setSecurityContextRepository(new HttpSessionSecurityContextRepository());
//                                return filter;
//                            }
//                        }))
//                .build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}
