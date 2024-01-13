package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.config.SecurityConfig;
import com.security.entity.UserInfo;
import com.security.repository.UserInfoRepository;

@Service
public class userService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private SecurityConfig securityConfig;   // for password encoder
	
//	@Bean
//	private PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	public String addUSer(UserInfo userInfo) {
		
		userInfo.setPassword(securityConfig.passwordEncoder().encode(userInfo.getPassword()));
		userInfoRepository.save(userInfo);
		return "user added to system";
	}

}
