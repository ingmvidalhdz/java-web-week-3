package com.springdemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springdemo.model.Morido;

@Service
public class CustomerServiceRestClientImpl implements CustomerService {

    private RestTemplate restTemplate;

    private String crmRestUrl;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    public CustomerServiceRestClientImpl(RestTemplate theRestTemplate,
            @Value("${crm.rest.url}") String theUrl) {

        restTemplate = theRestTemplate;
        crmRestUrl = theUrl;

        logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
    }

    @Override
    public List<Morido> getMoridos() {

        logger.info("***OBTENER LISTA DE CLIENTES DESDE EL SERVICE REST CLIENTE");
        logger.info("in getCustomers(): Calling REST API " + crmRestUrl);

        // make REST call
        ResponseEntity<List<Morido>> responseEntity
                = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Morido>>() {
                });

        // get the list of customers from response
        List<Morido> customers = responseEntity.getBody();

        logger.info("in getMorido(): customers" + customers);

        return customers;
    }

    @Override
    public Morido getMorido(int theId) {
        logger.info("***OBTENER UN CLIENTE DESDE EL SERVICE REST CLIENTE");

        logger.info("in getMorido(): Calling REST API " + crmRestUrl);

        // make REST call
        Morido theCustomer
                = restTemplate.getForObject(crmRestUrl + "/" + theId,
                        Morido.class);

        logger.info("in saveMorido(): theCustomer=" + theCustomer);

        return theCustomer;
    }

    @Override
    public void saveMorido(Morido theCustomer) {

        logger.info("in saveMorido(): Calling REST API " + crmRestUrl);

        int employeeId = theCustomer.getId();

        // make REST call
        if (employeeId == 0) {
            // add employee
            logger.info("***SALVAR UN CLIENTE DESDE EL SERVICE REST CLIENTE");

            restTemplate.postForEntity(crmRestUrl, theCustomer, String.class);

        } else {
            // update employee
            logger.info("***ACTUALIZAR UN CLIENTE DESDE EL SERVICE REST CLIENTE");

            restTemplate.put(crmRestUrl, theCustomer);
        }

        logger.info("in saveMorido(): success");
    }

    @Override
    public void deleteMorido(int theId) {
        logger.info("***BORRAR UN CLIENTE DESDE EL SERVICE REST CLIENTE");

        logger.info("in deleteMorido(): Calling REST API " + crmRestUrl);

        // make REST call
        restTemplate.delete(crmRestUrl + "/" + theId);

        logger.info("in deleteCustomer(): deleted customer theId=" + theId);
    }

}
