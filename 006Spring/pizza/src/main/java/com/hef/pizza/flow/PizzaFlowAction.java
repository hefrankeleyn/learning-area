package com.hef.pizza.flow;

import com.hef.pizza.domain.Customer;
import com.hef.pizza.domain.Order;
import com.hef.pizza.domain.Payment;
import com.hef.pizza.domain.PaymentDetails;
import com.hef.pizza.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PizzaFlowAction {


    @Autowired
    private CustomerService customerService;
    public Customer lookupCustomer(String phoneNumber){
        Customer customer= customerService.findCustomerByPhone(phoneNumber);
        return customer;
    }

    public void saveOrder(Order order){
        System.out.println("order save ok!");
    }

    public boolean checkDeliveryArea(String zipCode){
        if (zipCode.equals("123")){
            return false;
        }
        return true;
    }

    public void addCustomer(Customer customer){
        System.out.println("Add customer ok!");
    }

    public Payment verifPayment(PaymentDetails paymentDetails){
        Payment payment = new Payment();
        payment.setAmount(23.0f);
        return payment;
    }
}
