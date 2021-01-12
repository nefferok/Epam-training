import java.io.IOException;
import java.util.List;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.Constants;
import by.gsu.epamlab.beans.StudentResult;
import by.gsu.epamlab.handlers.ResultHandler;

public class Runner {
	public static void main(String[] args) {
		try {
			//create reader and handler
			ResultHandler rh = new ResultHandler();
			XMLReader reader = XMLReaderFactory.createXMLReader();
			//parsing
			reader.setContentHandler(rh);
			reader.parse(Constants.XML_FILE_PATH);
			//output
			List <StudentResult> list = rh.getResults();
			for (StudentResult e:list) {
				System.out.println(e);
			}
		} catch (SAXException e) {
			System.err.print(Constants.SAX_ERROR + e);
		} catch (IOException e) {
			System.err.print(Constants.STREAM_ERROR + e);
		}
	}
}
