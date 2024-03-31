package com.example.backendclientes.services;

import com.example.backendclientes.Cliente;
import com.example.backendclientes.IClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private IClienteDAO clienteDao;
    @Override
    @Transactional(readOnly = true)
    public List<Cliente>findAll(){
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public Cliente findById(Long id) {

        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteDao.deleteById(id);

    }


}
