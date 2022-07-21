package com.khaind.microservices.account.service.Impl;

import com.khaind.microservices.account.repository.UserRepository;
import com.khaind.microservices.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

}
