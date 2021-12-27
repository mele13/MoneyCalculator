package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.ActionListenerFactory;
import control.CalculateCommand;
import control.Command;
import control.CommandDictionary;
import persistence.MockCurrencySetLoader;
import ui.swing.ApplicationFrame;

/**
 * @author Mele13
 * 
 * Programa de conversión de monedas.
 * MVC architectural style.
 */
public class MoneyCalculatorApp {
    
    private ApplicationFrame frame;
    private CommandDictionary commandDictionary;
    
    public static void main(String[] args) {
        new MoneyCalculatorApp().execute();
    }

    private void execute() {
        MockCurrencySetLoader.getInstance().load();

        frame = new ApplicationFrame(new ActionListenerFactory() {
            @Override
            public ActionListener getAction(final String action) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        commandDictionary.get(action).execute();
                    }
                };
            }
        });
        
        createCommands();
    }

    private void createCommands() {
        commandDictionary = new CommandDictionary();
        commandDictionary.register("Calculate", new CalculateCommand(frame.getMoneyDialog(), frame.getCurrencyDialog()));
        commandDictionary.register("Exit", new Command() {
            @Override
            public void execute() {
                frame.dispose();
            }
        });
    }
}
