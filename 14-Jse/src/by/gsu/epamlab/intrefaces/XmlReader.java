package by.gsu.epamlab.intrefaces;

import by.gsu.epamlab.beans.Result;
import by.gsu.epamlab.exception.ReaderException;
import by.gsu.epamlab.factories.DecimalResultFactory;
import by.gsu.epamlab.factories.ResultFactory;
import by.gsu.epamlab.handlers.XMLHander;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static by.Constants.EXCEPTION_SAX_CREATE;

public class XmlReader implements IResultDAO {
    private ResultFactory factory;
    private Iterator<Result> iterator;

    public XmlReader (String path, DecimalResultFactory factory) throws ReaderException {
        this.factory = factory;
        try {
            XMLHander rh = new XMLHander(factory);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(rh);
            reader.parse(path);
            List <Result> results = rh.getResults();
            iterator = results.iterator();
        } catch (IOException | SAXException e) {
            throw new ReaderException(EXCEPTION_SAX_CREATE, e);
        }
    }

    @Override
    public boolean hasResult() {
        return iterator.hasNext();
    }

    @Override
    public Result nextResult() {
        return iterator.next();
    }

    @Override
    public void closeReader() {
        iterator=null;
    }
}
