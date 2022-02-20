package com.sda.company.service;

import com.sda.company.dto.CompanyCreateDto;
import com.sda.company.dto.CompanyFullDto;
import com.sda.company.dto.CompanyResponseDto;
import com.sda.company.model.Company;

import java.util.List;

public interface CompanyService {

    CompanyResponseDto create(CompanyCreateDto companyCreateDto);

    CompanyFullDto findCompanyByName(String name);

    CompanyFullDto findCompanyById(Integer id);

    CompanyFullDto findCompanyByNameAndRegistrationNumber(String name, Long registrationNumber);

    List<CompanyFullDto> findAll(Integer pageNumber, Integer pageSize, String sortBy);

    void saveAllCompanies(List<Company> listOfCompanies);
}
