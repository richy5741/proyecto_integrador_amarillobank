package org.amarillobank.repository;

import org.amarillobank.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface IClienteRepository {
    Cliente save(Cliente cliente);
    List<Cliente> findAll();
    Optional<Cliente> findByCedula(String cedula);
    Optional<Cliente> findById(Integer id);
}