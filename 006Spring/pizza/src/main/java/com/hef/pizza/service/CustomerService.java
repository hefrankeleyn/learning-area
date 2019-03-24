package com.hef.pizza.service;

import com.hef.pizza.domain.Customer;

public interface CustomerService {

    Customer findCustomerByPhone(String phone);
}
