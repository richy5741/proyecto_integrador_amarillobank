package org.amarillobank.service.impl;

import org.amarillobank.dto.ClienteDTO;
import org.amarillobank.mapper.ClienteMapper;
import org.amarillobank.model.Cliente;
import org.amarillobank.repository.IClienteRepository;
import org.amarillobank.repository.impl.ClienteRepositoryImpl;
import org.amarillobank.service.IClienteService;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteServiceImpl implements IClienteService {

    // Aquí conectamos el repositorio
    private final IClienteRepository clienteRepository = new ClienteRepositoryImpl();

    @Override
    public ClienteDTO registrarCliente(ClienteDTO clienteDTO) {
        // Regla de negocio: no repetir cédula
        if (clienteRepository.findByCedula(clienteDTO.getCedula()).isPresent()) {
            throw new RuntimeException("Ya existe un cliente con cédula: " + clienteDTO.getCedula());
        }
        Cliente cliente = ClienteMapper.toEntity(clienteDTO);
        Cliente guardado = clienteRepository.save(cliente);
        return ClienteMapper.toDTO(guardado);
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        return clienteRepository.findAll().stream()
                .map(ClienteMapper::toDTO)
                .collect(Collectors.toList());
    }
}
