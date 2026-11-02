package org.amarillobank.service;

import org.amarillobank.dto.ClienteDTO;
import java.util.List;

public interface IClienteService {
    ClienteDTO registrarCliente(ClienteDTO clienteDTO);
    List<ClienteDTO> listarClientes();
}
