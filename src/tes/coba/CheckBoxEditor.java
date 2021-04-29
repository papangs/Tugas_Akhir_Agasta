package tes.coba;

import java.awt.Component;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class CheckBoxEditor extends AbstractCellEditor
        implements TableCellEditor {

    private JRadioButton currentValue;
    private List<DomainCheckBox> listCk;

    public CheckBoxEditor(List<DomainCheckBox> listCk) {
        this.listCk = listCk;
    }

    /**
     * This method required by cell editor to get the cell current value
     */
    public Object getCellEditorValue() {
        return currentValue;
    }

    /**
     * This method required by TableCellEditor to get which component i want to
     * use for the editor
     */
    public Component getTableCellEditorComponent(JTable table,
            Object value,
            boolean isSelected,
            int row,
            int column) {

        /* Mengambil last selected checkbox */
        for (DomainCheckBox ck : listCk) {
            if (ck.getCheckBox1().getText().equals((String) value)) {
                currentValue = ck.getCheckBox1();
            } else if (ck.getCheckBox2().getText().equals((String) value)) {
                currentValue = ck.getCheckBox2();
            }
        }
        return currentValue;
    }
}
