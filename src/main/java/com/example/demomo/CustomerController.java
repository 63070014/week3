package com.example.demomo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {
    private ArrayList<Customer> customer;
    public CustomerController(){
        customer = new ArrayList<Customer>();
        customer.add(new Customer("1010","John",true,25));
        customer.add(new Customer("1018","Peter",true,24));
        customer.add(new Customer("1019","Sara",false,23));
        customer.add(new Customer("1110","Rose",false,23));
        customer.add(new Customer("1001","Emma",false,30));
    }
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getCustomers(){
        return customer;
    }
    @RequestMapping(value = "/customerbyid/{id}", method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable("id") String id){
        for(Customer c: customer){
            if(c.getID().equals(id)){
                return c;
            }
        }
        return null;
    }
    @RequestMapping(value = "/customerbyname/{name}", method = RequestMethod.GET)
    public Customer getCustomerByName(@PathVariable("name") String name){
        for(Customer c: customer){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }
    @RequestMapping(value = "/customerDelByid/{id}", method = RequestMethod.GET)
    public boolean delCustomerByID(@PathVariable("id") String id){
        for(Customer c: customer){
            if(c.getID().equals(id)){
                customer.remove(c);
                return true;
            }
        }
        return false;

    }
    @RequestMapping(value = "/customerDelByName/{n}", method = RequestMethod.GET)
    public boolean delCustomerByName(@PathVariable("n") String n){
        for(Customer c: customer){
            if(c.getName().equals(n)){
                customer.remove(c);
                return true;
            }
        }
        return false;
    }
    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public boolean addCustomer(@PathParam("ID") String id,@PathParam("name") String n, @PathParam("sex") String s, @PathParam("age") int a){
        boolean sexxy;
        if(s.equals("male")){
            sexxy = true;
        }else{
            sexxy = false;
        }
        customer.add(new Customer(id, n, sexxy, a));
        return true;
    }
    @RequestMapping(value = "/addCustomer2", method = RequestMethod.POST)
    public boolean addCustomer2(@PathParam("ID") String id,@PathParam("name") String n, @PathParam("sex") String s, @PathParam("age") int a){
        boolean sexxy;
        if(s.equals("male")){
            sexxy = true;
        }else{
            sexxy = false;
        }
        customer.add(new Customer(id, n, sexxy, a));
        return true;
    }

}
