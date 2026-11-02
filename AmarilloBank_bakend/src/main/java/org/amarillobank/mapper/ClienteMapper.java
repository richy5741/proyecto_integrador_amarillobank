package org.amarillobank.mapper;

import org.amarillobank.dto.ClienteDTO;
import org.amarillobank.model.Cliente;

public class ClienteMapper {


    public static ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) return null;
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setCedula(cliente.getCedula());
        return dto;
    }


    public static Cliente toEntity(ClienteDTO dto) {
        if (dto == null) return null;
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNombre(dto.getNombre());
        cliente.setCedula(dto.getCedula());
        return cliente;
    }
}
