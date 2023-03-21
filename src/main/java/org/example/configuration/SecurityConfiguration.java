package org.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfiguration {

   // @Autowired
   // private BCryptPasswordEncoder bCryptPasswordEncoder;
  //  @Bean
  //  public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
  //      InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
  //      manager.createUser(User.withUsername("user")
  //              .password(bCryptPasswordEncoder.encode("userPass"))
  //              .roles("USER")
  //              .build());
  //      manager.createUser(User.withUsername("admin")
  //              .password(bCryptPasswordEncoder.encode("adminPass"))
  //              .roles("USER", "ADMIN")
  //              .build());
  //      return manager;
  //  }


  //  @Bean
  //  public AuthenticationManager authenticationManager(HttpSecurity http,
  //                                                     UserDetailsService userDetailService) throws Exception {
  //      return http.getSharedObject(AuthenticationManagerBuilder.class)
  //              .userDetailsService(userDetailService)
  //              .passwordEncoder(bCryptPasswordEncoder)
  //              .and()
  //              .build();
  //  }

  // @Bean
  // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
  //     http.csrf()
  //             .disable()
  //             .authorizeRequests().requestMatchers(HttpMethod.GET)
  //             .hasRole("ADMIN").requestMatchers("/admin/**")
  //             .hasAnyRole("USER", "ADMIN").requestMatchers("/login/**")
  //             .anonymous()
  //             .anyRequest()
  //             .authenticated()
  //             .and()
  //             .httpBasic()
  //             .and()
  //             .sessionManagement()
  //             .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

  //     return http.build();
  // }
}
