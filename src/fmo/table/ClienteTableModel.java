package fmo.table;

import fmo.model.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel {
    private String [] columnas = {"Id","Nombre", "Apellido 1", "Apellido 2", "Ciudad","Categoria"};
    private ArrayList<Cliente> data;

    public ClienteTableModel(ArrayList<Cliente> data) {
        this.data = data;
    }
    
    public Cliente getObjectRow(int rowIndex) {
        return data.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return this.data.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente c = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getId();
            case 1:
                return c.getNombre();
            case 2:
                return c.getApellido1();
            case 3:
                return c.getApellido2();
            case 4:
                return c.getCiudad();
            case 5:
                return c.getCategoria();
            default:
                return "NA";
        }
    }
    
}
