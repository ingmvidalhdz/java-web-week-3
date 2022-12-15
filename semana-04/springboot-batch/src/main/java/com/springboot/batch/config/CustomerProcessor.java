package com.springboot.batch.config;

import com.springboot.batch.entity.Customer;
import org.springframework.batch.item.*;

public class CustomerProcessor implements ItemProcessor<Customer,Customer> {

    @Override
    public Customer process(Customer customer) throws Exception {
//        if(customer.getCountry().equals("China")) {
//            return customer;
//        }
        return null;
        
    }
}
