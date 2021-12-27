package ui.swing;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import model.Currency;
import model.CurrencySet;
import ui.CurrencyDialog;

public class CurrencyDialogPanel extends JPanel implements CurrencyDialog {

    private Currency currency;

    public CurrencyDialogPanel() {
        this(CurrencySet.getInstance().search("AUD")[0]);
    }

    public CurrencyDialogPanel(Currency currency) {
        super(new FlowLayout(FlowLayout.LEFT));
        this.currency = currency;
        this.createComponents();
    }

    private void createComponents() {
        this.add(createComboBox());
    }

    private JComboBox createComboBox() {
        String[] currencies = CurrencySet.getInstance().getArray();
        JComboBox comboBox = new JComboBox(currencies);
        comboBox.setSelectedIndex(0);
        currency = CurrencySet.getInstance().search(comboBox.getSelectedItem().toString())[0];
        comboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED)
                    currency = CurrencySet.getInstance().search(event.getItem().toString())[0];
            }

        });
        return comboBox;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }
}