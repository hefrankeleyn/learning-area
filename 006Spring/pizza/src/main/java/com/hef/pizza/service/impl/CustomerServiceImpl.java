package com.hef.pizza.service.impl;

import com.hef.pizza.domain.Customer;
import com.hef.pizza.service.CustomerNotFoundException;
import com.hef.pizza.service.CustomerService;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer findCustomerByPhone(String phone) {
        if (phone!=null && phone.equals("123456")){
            Customer customer = new Customer("123456");
            return customer;
        }else {
            throw new CustomerNotFoundException();
        }
    }
}
