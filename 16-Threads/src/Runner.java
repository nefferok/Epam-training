import by.gsu.epamlab.utilit.ResultReader;
import by.gsu.epamlab.utilit.ResultWriter;

import java.io.FileNotFoundException;

import static by.Constants.EXCEPTION_SCANNER_CREATE;

public class Runner {
    public static void main(String[] args){
        try {
            ResultReader reader = new ResultReader("src/results.csv");
            ResultWriter writer = new ResultWriter(reader);
            Thread thReader = new Thread(reader);
            thReader.start();
            Thread.yield();
            writer.go();
        } catch (FileNotFoundException e) {
            System.err.println(EXCEPTION_SCANNER_CREATE);
        }
    }
}
