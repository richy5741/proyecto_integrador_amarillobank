package org.amarillobank.repository.impl;
import org.amarillobank.config.DatabaseConfig;
import org.amarillobank.model.Cliente;
import org.amarillobank.repository.IClienteRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepositoryImpl implements IClienteRepository {
    public ClienteRepositoryImpl() { DatabaseConfig.initDatabase(); }

    @Override
    public Cliente save(Cliente c) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO clientes (nombre, cedula) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getCedula());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) c.setId(rs.getInt(1));
            return c;
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> lista = new ArrayList<>();
        try (Connection conn = DatabaseConfig.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT id, nombre, cedula FROM clientes")) {
            while (rs.next()) {
                lista.add(new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("cedula")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }

    @Override public Optional<Cliente> findByCedula(String ced) { return Optional.empty(); }
    @Override public Optional<Cliente> findById(Integer id) { return Optional.empty(); }
}