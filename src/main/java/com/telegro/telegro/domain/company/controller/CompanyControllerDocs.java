package com.telegro.telegro.domain.company.controller;

import com.telegro.telegro.domain.company.dto.request.CompanyRequestDTO;
import com.telegro.telegro.global.apiPayLoad.response.SuccessResponse;
import com.telegro.telegro.global.auth.annotation.LoginInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface CompanyControllerDocs {
    @Operation(summary = "공급 업체를 등록합니다.")
    @ApiResponse(responseCode = "200", description = "공급 업체 등록 성공")
    public SuccessResponse<?> createCompany(@LoginInfo Long id, @RequestBody CompanyRequestDTO companyRequestDTO);
    @Operation(summary = "공급 업체를 삭제합니다.")
    public SuccessResponse<?> deleteCompany(@LoginInfo Long id, @RequestParam(value = "id", required = true)
                                                @Parameter(description = "공급업체 id") Long companyId);
}
