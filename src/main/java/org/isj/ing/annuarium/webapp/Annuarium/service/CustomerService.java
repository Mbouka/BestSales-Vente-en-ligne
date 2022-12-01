package org.isj.ing.annuarium.webapp.Annuarium.service;

import lombok.extern.slf4j.Slf4j;
import org.isj.ing.annuarium.webapp.Annuarium.Iservice.Icustomer;
import org.isj.ing.annuarium.webapp.Annuarium.error.ErrorInfo;
import org.isj.ing.annuarium.webapp.Annuarium.error.isjException;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Customer;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Livraison;
import org.isj.ing.annuarium.webapp.Annuarium.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@Slf4j
public class CustomerService implements Icustomer {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer saveClient(Customer cust) throws isjException {
        cust.setId(cust.getId());
        cust.setEmail(cust.getEmail());
        cust.setNomComplet(cust.getNomComplet());
        cust.setQuartier(cust.getQuartier());
        cust.setTelephone(cust.getTelephone());
        cust.setVille(cust.getVille());
        Customer cusSave = customerRepository.save(cust);
        return cusSave;
    }

    @Override
    public List<Customer> listClient() {
        List<Customer> LISTCustomer=customerRepository.findAll();
        return LISTCustomer;
    }

    @Override
    public Customer updateClient(Integer id, Customer cust) throws isjException {
        cust.setEmail(cust.getEmail());
        cust.setNomComplet(cust.getNomComplet());
        cust.setQuartier(cust.getQuartier());
        cust.setTelephone(cust.getTelephone());
        cust.setVille(cust.getVille());
        Customer cusUpdate = customerRepository.save(cust);
        return cusUpdate;
    }

    @Override
    public String deleteClient(Integer id) throws isjException {
        customerRepository.deleteById(id);
        return "suppression reussi";
    }

    @Override
    public Customer findCustomerById(Integer id) throws isjException {
        return customerRepository.findById(id).orElseThrow(()->new isjException(ErrorInfo.CUSTOMER_NOT_FOUND));
    }
}
