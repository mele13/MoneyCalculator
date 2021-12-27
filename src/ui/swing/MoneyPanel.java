package ui.swing;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Money;
import ui.MoneyViewer;

public class MoneyPanel extends JPanel implements MoneyViewer {

    public static void refresh(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private JLabel label;

    public MoneyPanel() {
        super(new FlowLayout(FlowLayout.LEFT));
        this.createComponents();
    }

    @Override
    public void show(Money money) {
        label.setText(money.toString());
    }

    private void createComponents() {
        this.add(createMoneyDisplay());
    }

    private JLabel createMoneyDisplay() {
        label = new JLabel();
        return label;
    }
}