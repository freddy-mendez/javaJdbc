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
            System.out.println("Error al insertar el Cliente"+ex.getMessage());
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
    
    public Cliente getCliente(int id) {
        Connection con = ConexionDB.getInstance();
        String sql = "select * from cliente where id=?";
        Cliente c=null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nom = rs.getString("nombre");
                String ape1 = rs.getString("apellido1");
                String ape2 = rs.getString("apellido2");
                String ciudad = rs.getString("ciudad");
                int categoria = rs.getInt("categoria");
                c = new Cliente(id, nom, ape1, ape2, ciudad, categoria);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }
    
    public boolean delete(int id) {
        boolean result = false;
        Connection con = ConexionDB.getInstance();
        String sql = "delete from cliente where id=?";
        int rs=0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (rs==1) {
            result=true;
        }
        return result;
    }
    
    public boolean update(Cliente c, int id) {
        boolean result = false;
        int rs=0;
        Connection con = ConexionDB.getInstance();
        String sql = "update cliente set nombre=?, apellido1=?, apellido2=?, "
                + "ciudad=?, categoria=? where id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido1());
            ps.setString(3, c.getApellido2());
            ps.setString(4, c.getCiudad());
            ps.setInt(5, c.getCategoria());
            ps.setInt(6, id);
            rs = ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (rs==1) {
            result=true;
        }
        return result;
    }
}
