package com.ankit.token.generator.controller;

/*Responsible for creating token
only tokenprovider  counter can create token

*
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.token.generator.security.CurrentUser;
import com.ankit.token.generator.security.UserPrincipal;
import com.ankit.token.generator.service.TokenService;



@RestController
@RequestMapping("token")
public class TokenController {
	
	@Autowired
	private TokenService tokenServics;
	
	@GetMapping("/{tokenTypeId}")
	@PreAuthorize("hasRole('TokenGenerator')")
	public String createToken(@CurrentUser UserPrincipal currentUser,@PathVariable Long tokenTypeId) {
		return tokenServics.createServiceToken(currentUser.getId(), tokenTypeId);
	
		
	}

}
