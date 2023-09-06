package com.br.ecommercebook.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.br.ecommercebook.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {

  private final UserRepository userRepository;

  @Bean
  public UserDetailsService userDetailsService() {
    return username -> userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

  @Bean
  public AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
    daoProvider.setUserDetailsService(userDetailsService());
    daoProvider.setPasswordEncoder(passwordEncoder());
    return daoProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception{
    return authConfiguration.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
