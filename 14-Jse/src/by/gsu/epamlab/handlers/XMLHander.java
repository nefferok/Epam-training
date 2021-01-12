package by.gsu.epamlab.handlers;

import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.factories.ResultFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class XMLHander extends DefaultHandler {
    private ResultFactory factory;

    private enum ResultEnum {
        RESULTS, STUDENT, LOGIN, TESTS, TEST;
    }
    private List<Result> results = new ArrayList<>();
    private String login;

    public XMLHander(ResultFactory factory) {
        this.factory = factory;
    }

    public List<Result> getResults() {
        return results;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        final int IND_ATR_TEST = 0;
        final int IND_ATR_DATE = 1;
        final int IND_ATR_MARK = 2;
        ResultEnum currentEnum = ResultEnum.valueOf(localName.toUpperCase());
        if (currentEnum == ResultEnum.TEST){
            Result current = factory.getResultFromFacory(login, attrs.getValue(IND_ATR_TEST), attrs.getValue(IND_ATR_DATE), attrs.getValue(IND_ATR_MARK));
            results.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (!s.isEmpty()) {
            login = s;
        }
    }
}
