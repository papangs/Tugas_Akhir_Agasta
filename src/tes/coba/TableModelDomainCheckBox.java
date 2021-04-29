package tes.coba;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModelDomainCheckBox extends AbstractTableModel {

    private final String[] HEADER = new String[]{"KOLOM1", "KOLOM2", "KOLOM3", "KOLOM4"};
    private List<DomainCheckBox> listDomain;

    public TableModelDomainCheckBox(List<DomainCheckBox> listDomain) {
        this.listDomain = listDomain;
    }

    public int getRowCount() {
        return listDomain.size();
    }

    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public String getColumnName(int column) {
        return HEADER[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        DomainCheckBox ds = listDomain.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ds.getCheckBox1().getText();
            case 1:
                return ds.getCheckBox2().getText();
            case 2:
                return ds.getCheckBox3().getText();
            case 3:
                return ds.getCheckBox4().getText();
            default:
                return "";
        }
    }
}
