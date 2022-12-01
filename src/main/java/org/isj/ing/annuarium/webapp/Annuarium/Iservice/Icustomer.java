package org.isj.ing.annuarium.webapp.Annuarium.Iservice;

import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Customer;


import java.util.List;

public interface Icustomer {
    Customer saveClient(Customer cust)throws isjException;
    List<Customer> listClient();
    Customer updateClient(Integer id, Customer cust) throws  isjException;
    String deleteClient (Integer id) throws  isjException;
    Customer findCustomerById(Integer id) throws isjException;
}
