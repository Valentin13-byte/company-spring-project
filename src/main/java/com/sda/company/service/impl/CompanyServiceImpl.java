package com.sda.company.service.impl;

import com.sda.company.dto.CompanyCreateDto;
import com.sda.company.dto.CompanyFullDto;
import com.sda.company.dto.CompanyResponseDto;
import com.sda.company.mapper.CompanyMapper;
import com.sda.company.model.Company;
import com.sda.company.repository.CompanyRepository;
import com.sda.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======

>>>>>>> origin/main
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyResponseDto create(CompanyCreateDto companyCreateDto) {
        Company company = CompanyMapper.companyToEntity(companyCreateDto);
        Company savedCompany = companyRepository.save(company);

        return CompanyMapper.companyToResponseDto(savedCompany);
    }

    @Override
    public CompanyFullDto findCompanyByName(String name) {
        Company company = companyRepository.findByName(name).orElseThrow(() -> new RuntimeException("Company not found"));

        return CompanyMapper.companyToFullDto(company);
    }

    @Override
    public CompanyFullDto findCompanyById(Integer id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));

        return CompanyMapper.companyToFullDto(company);
    }

    @Override
    public CompanyFullDto findCompanyByNameAndRegistrationNumber(String name, Long registrationNumber) {
        Company company = companyRepository.findByNameAndRegistrationNumber(name, registrationNumber)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        return CompanyMapper.companyToFullDto(company);
    }

    @Override
    public List<CompanyFullDto> findAll(Integer pageNumber, Integer pageSize, String sortBy) {

<<<<<<< HEAD
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));

        List<CompanyFullDto> returnList = new ArrayList<>();
        companyRepository.findAll(pageable).forEach(entity -> {
            returnList.add(CompanyMapper.companyToFullDto(entity));
        });
        return returnList;
=======
        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));

        List<CompanyFullDto> result = new ArrayList<>();
        companyRepository.findAll(pageable).forEach(entity -> {
            result.add(CompanyMapper.companyToFullDto(entity));
        });
        return result;
>>>>>>> origin/main
    }

    @Override
    public void saveAllCompanies(List<Company> listOfCompanies) {
        companyRepository.saveAll(listOfCompanies);
<<<<<<< HEAD
        System.out.println("all companies were created");
    }
=======
        System.out.println(listOfCompanies.size() + " companies was added");
    }


>>>>>>> origin/main
}
