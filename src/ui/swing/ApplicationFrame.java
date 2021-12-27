package ui.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import control.ActionListenerFactory;
import ui.CurrencyDialog;
import ui.MoneyDialog;

public class ApplicationFrame extends JFrame {

    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;
    private final ActionListenerFactory factory;

    public ApplicationFrame(ActionListenerFactory factory) {
        super("Money Calculator");

        this.factory = factory;
        this.setMinimumSize(new Dimension(437, 150));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        createComponents();
        this.setVisible(true);
    }

    private void createComponents() {
        this.add(createToolbar(), BorderLayout.SOUTH);
        this.add(createContent());
    }

    private JPanel createToolbar() {
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        toolbar.add(createCalculateButton());
        toolbar.add(createExitButton());
        return toolbar;
    }

    private JButton createExitButton() {
        JButton button = new JButton("Exit");
        button.addActionListener(factory.getAction("Exit"));
        return button;
    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(factory.getAction("Calculate"));
        return button;
    }

    private JPanel createContent() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(createMoneyDialogPanel());
        panel.add(createCurrencyDialogPanel());
        return panel;
    }

    private JPanel createMoneyDialogPanel() {
        MoneyDialogPanel panel = new MoneyDialogPanel();
        moneyDialog = panel;
        return panel;
    }

    private JPanel createCurrencyDialogPanel() {
        CurrencyDialogPanel panel = new CurrencyDialogPanel();
        currencyDialog = panel;
        return panel;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }
}