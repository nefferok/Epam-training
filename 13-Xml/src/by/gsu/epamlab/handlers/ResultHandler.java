package by.gsu.epamlab.handlers;

import static by.Constants.*;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.gsu.epamlab.beans.StudentResult;

public class ResultHandler extends DefaultHandler {
	private enum ResultEnum {
		RESULTS, STUDENT, LOGIN, TESTS, TEST;
	}
	private List<StudentResult> results = new ArrayList<>();
	private String login;

	public ResultHandler() {
	}

	public List<StudentResult> getResults() {
		return results;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		ResultEnum currentEnum = ResultEnum.valueOf(localName.toUpperCase());
		if (currentEnum == ResultEnum.TEST) {
			results.add(
					new StudentResult(login, attrs.getValue(NAME_INDEX), attrs.getValue(DATE_INDEX), attrs.getValue(MARK_INDEX)));
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
