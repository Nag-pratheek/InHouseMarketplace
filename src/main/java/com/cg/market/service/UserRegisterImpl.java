package com.cg.market.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.market.dao.UserRegisterDao;
import com.cg.market.dto.UserDetails;

@Service
@Transactional
public class UserRegisterImpl implements UserRegister {

	@Autowired
	private UserRegisterDao uDao;
	
	@Override
	public UserDetails register(UserDetails uDetails) {
		Optional<UserDetails> detailsOpt = uDao.findById(uDetails.getUsername());
		if(!detailsOpt.isPresent()) {
			//throw new
		}
//		UserDetails details = detailsOpt.get();
//		if(!details.getPassword().equals(uDetails.getPassword())) {
//			//throw new 
//		}
		uDetails = uDao.save(uDetails);
		return uDetails;
	}

	
}
