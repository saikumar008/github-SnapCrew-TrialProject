package com.photoProject.Snapcrew.Service;

import com.photoProject.Snapcrew.Dto.CustomerDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(UUID id);

    public Page<CustomerDto> getAllCustomers(int page, int size);

    CustomerDto updateCustomer(UUID id, CustomerDto customerDto);

    void deleteCustomer(UUID id);

}
