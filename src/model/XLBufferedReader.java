package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import util.XLException;

public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    public void load(Sheet sheet) {
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                sheet.setValue(string.substring(0, i), string.substring(i+1),true);
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
