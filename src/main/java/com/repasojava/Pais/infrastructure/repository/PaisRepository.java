package com.repasojava.Pais.infrastructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import com.repasojava.Pais.domain.entity.Pais;
import com.repasojava.Pais.domain.service.PaisService;

public class PaisRepository implements PaisService {
    private Connection connection;

    public PaisRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void createPais(Pais pais) {
        String sql = "INSERT INTO pais (descripcion) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql,
                PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, pais.getName());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pais.setId(generatedKeys.getLong(1));
                }
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Pais> findPaisById(Long id) {
        String query = "SELECT id,descripcion FROM pais WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Pais pais = new Pais(
                            resultSet.getLong("id"),
                            resultSet.getString("descripcion"));
                    return Optional.of(pais);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void updatePais(Pais pais) {
        String query = "UPDATE pais SET descripcion = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, pais.getName());
            statement.setLong(2, pais.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}