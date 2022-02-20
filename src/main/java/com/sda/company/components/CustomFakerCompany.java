package com.sda.company.components;

import com.github.javafaker.Faker;
import com.sda.company.model.Company;

import java.util.ArrayList;
import java.util.List;

public class CustomFakerCompany {
    public List<Company> createDummyCompanyList() {
        List<Company> companyList = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 500; i++) {
            Company company = new Company();
            company.setName(faker.company().name());
            company.setRegistrationNumber(faker.number().randomNumber(5, true));
            company.setEmail(faker.bothify("?????##@gmail.com"));
            company.setPhoneNumber(faker.phoneNumber().phoneNumber());
            company.setAddress(faker.address().fullAddress());

            companyList.add(company);
        }
        return companyList;
    }
}
