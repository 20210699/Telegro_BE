package com.telegro.telegro.domain.company.dto.request;

import com.telegro.telegro.global.auth.dto.response.SignUpUserInfoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Schema(description = "공급업체 회원가입")
@Getter
@Builder
public class CompanySignUpDTO {
    SignUpUserInfoDto signUpUserInfoDto;
    CompanyRequestDTO companyRequestDTO;
}
