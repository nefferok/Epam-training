package by.gsu.epamlab.utilit;

import by.Constants;
import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.interfases.IResultDAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static by.Constants.DELIMITER;

public class ResultReader implements IResultDAO, Runnable {
    private ResultBuffer resultBuffer;
    private Scanner sc;

    public ResultReader(String file) throws FileNotFoundException {
        sc = new Scanner(new FileReader(file));
        this.resultBuffer = new ResultBuffer(sc.hasNext());
    }

    @Override
    public boolean hasResult() {
        return resultBuffer.hasNext();
    }

    @Override
    public Result nextResult() {
        return resultBuffer.getResult();
    }

    private void closeReader() {
        sc.close();
    }

    @Override
    public void run() {
        boolean nextFlag = sc.hasNextLine();
        while (nextFlag) {
            Result result = new Result(sc.nextLine().split(DELIMITER));
            System.out.println(Constants.GOT_MESSAGE + result);
            nextFlag = sc.hasNext();
            resultBuffer.setResultAndNextFlag(result, nextFlag);
        }
        closeReader();
    }
}
