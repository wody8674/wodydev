package com.study.spring.chapter6.service;

import com.study.spring.chapter6.vo.LoginCommand;

public interface Authenticator {

	void authenticate(LoginCommand loginCommand)
			throws AuthenticationException;

}
