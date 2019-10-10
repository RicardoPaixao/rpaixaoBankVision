package com.rpaixao.services;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.rpaixao.models.ReqResWrapper;
import com.rpaixao.models.User;
import com.rpaixao.models.UserReqRes;
import com.rpaixao.repositories.UserRepository;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
	   final String uri = "https://reqres.in/api/users";


	@Override
    @Transactional
	public List<User> importReqRes() {
		List<User> importedUsers = new ArrayList<User>();		
		RestTemplate restTemplate = new RestTemplate();
		try {	
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            ResponseEntity<ReqResWrapper> response = restTemplate.exchange(uri,HttpMethod.GET,entity,ReqResWrapper.class);
            System.out.println(response);

            ReqResWrapper result = response.getBody();
			
		for (UserReqRes userReqRes : result.getData()) {
			User u = new User();
			u.setId(userReqRes.getId());
			u.setNombres(userReqRes.getFirst_name());
			u.setApellidos(userReqRes.getLast_name());
			userRepository.save(u); //TODO batch save function
			importedUsers.add(u);
		}}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return importedUsers;
	}

}
