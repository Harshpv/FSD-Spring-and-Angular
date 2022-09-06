package com.authenticationservice.jwtToken;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.authenticationservice.Datamodel.UserDao;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenGenerator {

	public Map<String, String> generateToken(UserDao user) {
		String jwstToken = Jwts.builder()
				.setSubject(user.getEmail())
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256,"secretekeyid")
				.compact();
	    Map<String,String> mapData = new HashMap<>();
	    mapData.put("token",jwstToken);
	    mapData.put("message","Authentication Successful.");
	    return mapData;	
	    }

}
