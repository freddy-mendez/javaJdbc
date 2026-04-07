/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fmo;

import fmo.dao.ClienteDAO;
import fmo.db.ConexionDB;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Teleinformática III
 */
public class Ventas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Connection con = ConexionDB.getInstance();
        
        Scanner tc = new Scanner(System.in);
        
        ClienteDAO cDAO = new ClienteDAO();
        //Cliente luis = new Cliente(2, "Mauricio", "Carvajal", "Vera", "Aqui", 1);
        //cDAO.insert(luis);
        
        Cliente c = cDAO.getCliente(18);
        c.setCiudad("Bga");
        c.setCategoria(100);
        cDAO.update(c, 18);
        
        
        
//        System.out.println("Digite el codigo del cliente a eliminar");
//        int id = tc.nextInt();
//        if (cDAO.delete(id)) {
//            JOptionPane.showMessageDialog(null, 
//                    "Cliente Eliminado!!", 
//                    "Delete Cliente", 
//                    JOptionPane.ERROR_MESSAGE);
//        }
        /*ArrayList<Cliente> data = cDAO.getClientes();
        for (Cliente c: data) {
            System.out.println(c);
        }*/
        
        /*Cliente c = cDAO.getCliente(14);
        System.out.println((c==null?"No existe el cliente":c));*/
        
        /*
        Cliente luis = new Cliente(2, "Mauricio", "Carvajal", "Vera", "Aqui", 1);
        //cDAO.insert(luis);
        if (cDAO.insert(luis)) {
            JOptionPane.showMessageDialog(null, 
                    "Cliente Insertado con Exito!!", 
                    "Insert Cliente", 
                    JOptionPane.INFORMATION_MESSAGE);
        }*/
        
        
        /*
        ClienteDAO cDAO = new ClienteDAO();
        if (cDAO.insert(luis)) {
            JOptionPane.showMessageDialog(null, 
                    "Cliente Insertado con Exito!!", 
                    "Insert Cliente", 
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        
        Cliente luis = new Cliente(1, "Luis", "Figueroa");
        Cliente mauricio = new Cliente(2, "Mauricio", "Carvajal", "Vera", "Aqui", 1);
        Cliente daniel = new Cliente(3, "Daniel", "Celis", null, "Giron", 0);
        
        System.out.println(luis.getNombre());
        System.out.println(mauricio.getApellido1());
        System.out.println(daniel);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.getLogger(Ventas.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        Connection conexion=null;
        
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas", "root", "");
        } catch (SQLException ex) {
            System.getLogger(Ventas.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        if (conexion!=null) {
            String sql = "insert into cliente values (null,'"+luis.getNombre()
                    +"', '"+luis.getApellido1()+"', null, null, 0)";
            try {
                conexion.createStatement().execute(sql);
            } catch (SQLException ex) {
                System.getLogger(Ventas.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        */
        
    }
    
}
