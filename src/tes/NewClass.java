package tes;


import java.awt.*;
import java.awt.event.*;
import javafx.scene.control.RadioButton;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class NewClass extends JFrame {

    private DefaultTableModel dtm;
    private ButtonGroup bg;
    private JTable table;
    private JScrollPane jsp;

    public NewClass() {
        setTitle("JTableRadioButton Test");
        dtm = new DefaultTableModel();
        dtm.setDataVector(new Object[][]{{"Course 1", new JRadioButton("Java")}, {"Course 1", new JRadioButton("Python")}, {"Course 1", new JRadioButton("Scala")}, {"Course 2", new RadioButton("Selenium")}, {"Course 2", new JRadioButton("Java Script")}}, new Object[]{"Course", "Technology"});
        table = new JTable(dtm) {
            public void tableChanged(TableModelEvent tme) {
                super.tableChanged(tme);
                repaint();
            }
        };
        bg = new ButtonGroup();
        bg.add((JRadioButton) dtm.getValueAt(0, 1));
        bg.add((JRadioButton) dtm.getValueAt(1, 1));
        bg.add((JRadioButton) dtm.getValueAt(2, 1));
        bg.add((JRadioButton) dtm.getValueAt(3, 1));
        bg.add((JRadioButton) dtm.getValueAt(4, 1));
        table.getColumn("Technology").setCellRenderer(new RadioButtonRenderer());
        table.getColumn("Technology").setCellEditor(new RadioButtonEditor(new JCheckBox()));
        jsp = new JScrollPane(table);
        add(jsp, BorderLayout.NORTH);
        setSize(400, 275);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NewClass();
    }
}

class RadioButtonRenderer implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value == null) {
            return null;
        }
        return (Component) value;
    }
}

class RadioButtonEditor extends DefaultCellEditor implements ItemListener {

    private JRadioButton button;

    public RadioButtonEditor(JCheckBox checkBox) {
        super(checkBox);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value == null) {
            return null;
        }
        button = (JRadioButton) value;
        button.addItemListener(this);
        return (Component) value;
    }

    public Object getCellEditorValue() {
        button.removeItemListener(this);
        return button;
    }

    public void itemStateChanged(ItemEvent e) {
        super.fireEditingStopped();
    }
}
