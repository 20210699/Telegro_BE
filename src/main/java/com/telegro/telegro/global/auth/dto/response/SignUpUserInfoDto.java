package com.telegro.telegro.global.auth.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
//Todo: 알맞게 수정
public class SignUpUserInfoDto {
  private String username;
  private String profile;
  private String email;
  private String password;
}
