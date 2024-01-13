package com.security.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.security.entity.UserInfo;
import com.security.repository.UserInfoRepository;

public class UserInfoUserDetailService implements UserDetailsService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserInfo> userInfo=userInfoRepository.findByName(username);
		return userInfo.map(UserInfoUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("user not found"));
		
	}

}
