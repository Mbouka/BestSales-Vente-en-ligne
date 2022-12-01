package org.isj.ing.annuarium.webapp.Annuarium.service;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Icustomer;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Customer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@Slf4j
public class CustomerService implements Icustomer {
    @Override
    public Customer saveClient(Customer cust) throws isjException {
        cust.setId(cust.getId());
        cust.setEmail(cust.getEmail());
        cust.setNomComplet(cust.getNomComplet());
        cust.setQuartier(cust.getQuartier());
        cust.setTelephone(cust.getTelephone());
        cust.setVille(cust.getVille());
        return null;
    }

    @Override
    public List<Customer> listClient() {
        return null;
    }

    @Override
    public Customer updateClient(Integer id, Customer cust) throws isjException {
        return null;
    }

    @Override
    public String deleteClient(Integer id) throws isjException {
        return null;
    }

    @Override
    public Customer findCustomerById(Integer id) throws isjException {
        return null;
    }
}
