package tes.coba;

import java.awt.Component;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {

    private List<DomainCheckBox> listCk;

    public CheckBoxRenderer(List<DomainCheckBox> listCk) {
        this.listCk = listCk;
    }

    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row, int column) {

        JRadioButton checkBox = null;
        for (DomainCheckBox ck : listCk) {
            if (ck.getCheckBox1().getText().equals((String) value)) {
                checkBox = ck.getCheckBox1();
            } else if (ck.getCheckBox2().getText().equals((String) value)) {
                checkBox = ck.getCheckBox2();
            } else if (ck.getCheckBox3().getText().equals((String) value)) {
                checkBox = ck.getCheckBox3();
            } else if (ck.getCheckBox4().getText().equals((String) value)) {
                checkBox = ck.getCheckBox4();
            }
        }

        if (!isSelected) {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        } else {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        }
        return checkBox;
    }

}
