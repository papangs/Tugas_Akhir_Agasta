package tes.coba;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;


public class DomainCheckBox {

    private JRadioButton checkBox1;
    private JRadioButton checkBox2;
    private JRadioButton checkBox3;
    private JRadioButton checkBox4;

    public JRadioButton getCheckBox1() {
        return checkBox1;
    }

    public void setCheckBox1(JRadioButton checkBox1) {
        this.checkBox1 = checkBox1;
    }

    public JRadioButton getCheckBox2() {
        return checkBox2;
    }

    public void setCheckBox2(JRadioButton checkBox2) {
        this.checkBox2 = checkBox2;
    }

    public JRadioButton getCheckBox3() {
        return checkBox3;
    }

    public void setCheckBox3(JRadioButton checkBox3) {
        this.checkBox3 = checkBox3;
    }

    public JRadioButton getCheckBox4() {
        return checkBox4;
    }

    public void setCheckBox4(JRadioButton checkBox4) {
        this.checkBox4 = checkBox4;
    }

    public DomainCheckBox(JRadioButton checkBox1, JRadioButton checkBox2, JRadioButton checkBox3, JRadioButton checkBox4) {
        this.checkBox1 = checkBox1;
        this.checkBox2 = checkBox2;
        this.checkBox3 = checkBox3;
        this.checkBox4 = checkBox4;
    }
    
    
}
