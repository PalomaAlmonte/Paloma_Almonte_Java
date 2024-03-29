package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        List<Customer> customers = convertToCustomers(customerData);

        System.out.println("Customers:");
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
        System.out.println("********************************************");
        System.out.println("\nPositive accounts:");

        for ( String[] customer : customerData) {
            int charge =  Integer.parseInt(customer[2]);
            if (charge > 0)  {
                System.out.println("\nName: " + customer[1] + "\nCharge: " + charge );
            }
        }

        System.out.println("********************************************");
        System.out.println("\nNegative accounts:");
        for ( String[] customer : customerData) {
            int charge =  Integer.parseInt(customer[2]);
            if (charge < 0)  {
                System.out.println("\nName: " + customer[1] + "\nCharge: " + charge );
            }
        }
    }

    public static List<Customer> convertToCustomers(List<String[]> customerData) {
        List<Customer> customers = new ArrayList<>();

        for (String[] data : customerData) {
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int charge = Integer.parseInt(data[2]);


            Customer existingCustomer = null;
            for (Customer customer : customers) {
                if (customer.getId() == id) {
                    existingCustomer = customer;
                    break;
                }
            }

            if (existingCustomer == null) {
                existingCustomer = new Customer();
                existingCustomer.setId(id);
                existingCustomer.setName(name);
                customers.add(existingCustomer);
            }

            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setCharge(charge);

            existingCustomer.getCharges().add(accountRecord);

        }return customers;
    }
}