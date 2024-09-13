package com.telegro.telegro.domain.user.service;

import com.telegro.telegro.domain.user.entity.User;
import com.telegro.telegro.domain.user.entity.enums.Membership;
import com.telegro.telegro.domain.user.repository.UserRepository;
import com.telegro.telegro.global.apiPayLoad.exception.CustomException;
import com.telegro.telegro.global.auth.dto.response.SignUpUserInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.telegro.telegro.global.apiPayLoad.exception.Error;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public Long signUp(SignUpUserInfoDto signUpUserInfoDto) {
        User existUser = userRepository
                .findByUserId(signUpUserInfoDto.getUserid());

        if(existUser != null){
            throw CustomException.of(Error.NICKNAME_ALREADY_USED_ERROR);
        }

        User user = User.builder()
                .userId(signUpUserInfoDto.getUserid())
                .username(signUpUserInfoDto.getUsername())
                .phone(signUpUserInfoDto.getPhone())
                .address(signUpUserInfoDto.getAddress())
                .addressDetail(signUpUserInfoDto.getAddressDetail())
                .zipCode(signUpUserInfoDto.getZipCode())
                .totalPrice(0)
                .email(signUpUserInfoDto.getEmail())
                .membership(Membership.MEMBER)
                .password(passwordEncoder.encode(signUpUserInfoDto.getPassword()))
                .build();

        Long savedUserId = null;
        try {
            User savedUser = userRepository.save(user);
            savedUserId = savedUser.getId();
        } catch (DuplicateKeyException e) {
            throw new RuntimeException("try to save duplicated user");
        }
        return savedUserId;
    }
}
