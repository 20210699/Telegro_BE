package com.telegro.telegro.global.auth.controller;

import com.telegro.telegro.domain.user.service.UserService;
import com.telegro.telegro.global.apiPayLoad.response.SuccessResponse;
import com.telegro.telegro.global.auth.dto.request.LoginRequestDto;
import com.telegro.telegro.global.auth.dto.request.SignUpRequestDto;
import com.telegro.telegro.global.auth.dto.response.LoginDto;
import com.telegro.telegro.global.auth.dto.response.SignUpUserInfoDto;
import com.telegro.telegro.global.auth.jwt.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController implements AuthControllerDocs {

  private final UserService userService;
  private final JWTUtil jwtUtil;

  @PostMapping("/login")
  public SuccessResponse<LoginDto> login(LoginRequestDto loginRequestDto) {
      Long id = userService.getUserId(loginRequestDto);
      String jwtToken = jwtUtil.createJwt(id, 60 * 60 * 60 * 1000L);

      LoginDto loginDto = LoginDto.builder()
              .accessToken(jwtToken).build();

      return SuccessResponse.of(loginDto);
  }

  @PostMapping("/signup")
  public SuccessResponse<?> signup(SignUpRequestDto signUpRequestDto) {
      SignUpUserInfoDto userInfoDto = SignUpUserInfoDto.builder()
              .userid(signUpRequestDto.userid())
              .username(signUpRequestDto.username())
              .password(signUpRequestDto.password())
              .phone(signUpRequestDto.phone())
              .email(signUpRequestDto.email())
              .address(signUpRequestDto.address())
              .addressDetail(signUpRequestDto.addressDetail())
              .zipCode(signUpRequestDto.zipCode())
              .build();

      userService.signUp(userInfoDto);

      return SuccessResponse.of();
  }
}
