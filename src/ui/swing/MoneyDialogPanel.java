package ui.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Money;
import model.Number;
import ui.CurrencyDialog;
import ui.MoneyDialog;

public class MoneyDialogPanel extends JPanel implements MoneyDialog {

    private Number number;
    private String amount;
    private CurrencyDialog currencyDialog;
    private static JLabel result;

    public MoneyDialogPanel() {
        super(new FlowLayout(FlowLayout.LEFT));
        createComponents();
    }

    private JTextField createAmountField() {
        final JTextField textField = new JTextField(12);
        textField.setText(amount);
        textField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                amount = textField.getText();
            }
        });
        return textField;
    }

    private JPanel createCurrencyDialog() {
        CurrencyDialogPanel panel = new CurrencyDialogPanel();
        currencyDialog = panel;
        return panel;
    }

    private void createComponents() {
        this.add(createAmountField());
        result = createResultLabel();
        this.add(createCurrencyDialog());
        this.add(result);
    }

    @Override
    public Money getMoney() {
        number = new Number(Double.parseDouble(amount));
        return new Money(number, currencyDialog.getCurrency());
    }

    public static void refresh(String number) {
        result.setText(number);
    }

    private JLabel createResultLabel() {
        JLabel label = new JLabel("");
        label.setPreferredSize(new Dimension(130, 20));
        return label;
    }
}