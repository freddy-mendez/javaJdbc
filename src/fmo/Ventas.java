package fmo;

import fmo.dao.ClienteDAO;
import fmo.model.Cliente;
import fmo.view.Menu;
import java.util.ArrayList;


/**
 *
 * @author Teleinformática III
 */
public class Ventas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //menuPrincipal();
        java.awt.EventQueue.invokeLater(() -> new Menu().setVisible(true));
        
        // TODO code application logic here
        
        //Connection con = ConexionDB.getInstance();
        
        //Scanner tc = new Scanner(System.in);
        
        //ClienteDAO cDAO = new ClienteDAO();
        //Cliente luis = new Cliente(2, "Mauricio", "Carvajal", "Vera", "Aqui", 1);
        //cDAO.insert(luis);
        
        /*Cliente c = cDAO.getCliente(18);
        c.setCiudad("Bga");
        c.setCategoria(100);
        cDAO.update(c, 18);*/
        
        
        
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
    
    private static void menuPrincipal() {
        boolean salir = false;
        do {
            IO.println("********************MENU*******************");
            IO.println("*          1. Gestión de Clientes         *");
            IO.println("*          2. Gestión de Comerciales      *");
            IO.println("*          3. Salir                       *");
            IO.println("*******************************************");
            String rs = IO.readln("Digite su opción:");
            switch (rs) {
                case "1":
                    gestionClientes();
                    break;
                case "2":
                    IO.println("Gestión Comerciales");
                    break;
                case "3":
                    salir=true;
                    break;
                default:
                    IO.println("Opción no valida, Intente nuevamente");
            }
        } while (!salir);
    }

    private static void gestionClientes() {
        boolean gestion=true;
        ClienteDAO cDAO = new ClienteDAO();
        do {
            IO.println("********************MENU*******************");
            IO.println("*          1. Listar Clientes             *");
            IO.println("*          2. Agregar Cliente             *");
            IO.println("*          3. Eliminar Cliente            *");
            IO.println("*          4. Modificar Cliente           *");
            IO.println("*          5. Volver al menu pricipal     *");
            IO.println("*******************************************");
            String rs = IO.readln("Digite su opción:");
            switch (rs) {
                case "1":
                    ArrayList<Cliente> clientes = cDAO.getClientes();
                    for (Cliente c:clientes) {
                        IO.println(c);
                    }
                    break;
                case "2":
                    String nombre = IO.readln("Digite el nombre del Cliente");
                    String apellido1 = IO.readln("Digite el primer apellido del Cliente");
                    String apellido2=null;
                    String result = IO.readln("Tiene segundo apellido? [Si o No]").
                            toLowerCase();
                    if (result.equals("si")) {
                        apellido2=IO.readln("Digite el segundo apellido");
                    }
                    String ciudad=null;
                    result = IO.readln("Tiene Ciudad? [Si o No]").
                            toLowerCase();
                    if (result.equals("si")) {
                        ciudad=IO.readln("Digite la ciudad");
                    }
                    int categoria=0;
                    result = IO.readln("Tiene categoria? [Si o No]").
                            toLowerCase();
                    if (result.equals("si")) {
                        categoria=Integer.parseInt(IO.readln("Digite la categoria"));
                    }
                    Cliente c = new Cliente(nombre, apellido1, apellido2, ciudad, categoria);
                    cDAO.insert(c);
                    break;
                case "3":
                    String id = IO.readln("Digite el id del Cliente a Eliminar");
                    cDAO.delete(Integer.parseInt(id));
                    break;
                case "4":
                    String id1 = IO.readln("Digite el id del Cliente");
                    Cliente c1 = cDAO.getCliente(Integer.parseInt(id1));
                    IO.println("Nombre Actual="+c1.getNombre());
                    String resp = IO.readln("Quiere modificar el nombre? [Si o No]")
                            .toLowerCase();
                    if (resp.equals("si")) {
                        c1.setNombre(IO.readln("Digite el nuevo nombre"));
                    }
                    IO.println("Apellido 1 Actual="+c1.getApellido1());
                    resp = IO.readln("Quiere modificar el primer apellido? [Si o No]")
                            .toLowerCase();
                    if (resp.equals("si")) {
                        c1.setApellido1(IO.readln("Digite el nuevo primer apellido"));
                    }
                    IO.println("Apellido 2 Actual="+c1.getApellido2());
                    resp = IO.readln("Quiere modificar el segundo apellido? [Si o No]")
                            .toLowerCase();
                    if (resp.equals("si")) {
                        c1.setApellido2(IO.readln("Digite el nuevo segundo apellido"));
                    }
                    IO.println("Ciudad Actual="+c1.getCiudad());
                    resp = IO.readln("Quiere modificar la ciudad? [Si o No]")
                            .toLowerCase();
                    if (resp.equals("si")) {
                        c1.setCiudad(IO.readln("Digite la nueva ciudad"));
                    }
                    IO.println("Categoria Actual="+c1.getCategoria());
                    resp = IO.readln("Quiere modificar la categoria? [Si o No]")
                            .toLowerCase();
                    if (resp.equals("si")) {
                        c1.setCategoria(Integer.parseInt(IO.readln("Digite la nueva ciudad")));
                    }
                    cDAO.update(c1, Integer.parseInt(id1));
                    break;
                case "5":
                    gestion=false;
                    break;
                default:
                    throw new AssertionError();
            }
        } while(gestion);
    }
    
}
