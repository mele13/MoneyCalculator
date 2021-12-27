package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Currency;
import persistence.FileCurrencySetLoader;

public class FileExchangeMoneyControl {

    private final String fileName;

    public FileExchangeMoneyControl(String filename) {
        this.fileName = filename;
    }

    public void execute() throws FileNotFoundException {
        FileCurrencySetLoader.getInstance().load(readCurrencies(fileName));
    }

    private Currency[] readCurrencies(String filename) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
        ArrayList<String> listString = new ArrayList<>();

        while (true) {
            String line;
            try {
                line = reader.readLine();
                if (line == null)
                    break;
                listString.add(line);
            } catch (IOException ioe) {
                break;
            }
        }
        return fromString(listString);
    }

    private Currency[] fromString(ArrayList<String> listString) {
        ArrayList<Currency> listCurrency = new ArrayList<>();        
        for (String string : listString) {
            String[] split = string.split(";");
            listCurrency.add(new Currency(split[0], split[1], split[2]));
        }

        return listCurrency.toArray(new Currency[0]);
    }
}
