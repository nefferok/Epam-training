package by.gsu.epamlab.utilit;

import by.Constants;
import by.gsu.epamlab.beans.Result;

public class ResultWriter {
    private ResultReader reader;

    public ResultWriter(ResultReader reader) {
        this.reader = reader;
    }

    public void go(){

        while (reader.hasResult()){
            Result result =  reader.nextResult();
            System.out.println(Constants.PUT_MESSAGE + result);
        }
    }
}
