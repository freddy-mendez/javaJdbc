package fmo.dao;

import fmo.Cliente;
import fmo.db.ConexionDB;
import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {
    /*
    CRUD  ->    Create
                Read
                Update
                Delete
    */
    
    public boolean insert(Cliente c) {
        Connection con = ConexionDB.getInstance();
        String sql = "insert into cliente values (null, ?, ?, ?, ?, ?)";
        int resultado = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido1());
            ps.setString(3, c.getApellido2());
            ps.setString(4, c.getCiudad());
            ps.setInt(5, c.getCategoria());
            resultado = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error al insertar el Cliente");
        }
        if (resultado==1) {
            return true;
        } else {
            return false;
        }
    }
    
    public ArrayList<Cliente> getClientes() {
        Connection con = ConexionDB.getInstance();
        String sql = "select * from cliente";
        ArrayList<Cliente> data = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultados = ps.executeQuery();
            while(resultados.next()) {
                int id = resultados.getInt("id");
                String nom = resultados.getString("nombre");
                String ape1 = resultados.getString("apellido1");
                String ape2 = resultados.getString("apellido2");
                String ciudad = resultados.getString("ciudad");
                int categoria = resultados.getInt("categoria");
                Cliente c = new Cliente(id, nom, ape1, ape2, ciudad, categoria);
                data.add(c);
            }
        } catch (Exception ex) {
            System.out.println("Error con los datos"+ex.getMessage());
        }
        return data;
    }
}
