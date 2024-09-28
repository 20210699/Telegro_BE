package com.telegro.telegro.domain.company.repository;

import com.telegro.telegro.domain.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    Company findByCompanyName(String companyName);
}
