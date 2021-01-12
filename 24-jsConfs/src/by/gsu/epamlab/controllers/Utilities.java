package by.gsu.epamlab.controllers;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;

import by.gsu.epamlab.model.beans.Conference;
import by.gsu.epamlab.model.beans.Event;

public class Utilities {
	public static String getJsonConfs(Map<Integer, Conference> conferences) {

		JSONArray ja = new JSONArray();
		ja.put("id");
		ja.put("name");
		ja.put("faculty");
		ja.put("date");
		
		String strConfs = conferences.entrySet().stream()
			.map(entry -> entry.getKey() + ", " + entry.getValue())
			.collect(Collectors.joining(" \n"));
		
		JSONArray jsonConfs = CDL.toJSONArray(ja, strConfs);
		return jsonConfs.toString();
	}

	public static String getJsonConfById(Map<Integer, Conference> conferences, int id) {
		JSONObject jsonConf = new JSONObject();
		jsonConf.put("name", conferences.get(id).getName());
		jsonConf.put("faculty", conferences.get(id).getFaculty());
		jsonConf.put("date", conferences.get(id).getDate());
		return jsonConf.toString();
	}

	public static String getJsonEvents(List<Event> events) {
		if(events.size() == 0) {
			return "[]";
		}
		JSONArray ja = new JSONArray();
		ja.put("id");
		ja.put("name");
		ja.put("time");
		
		String strEvents = events.stream()
			.map(event -> event.toString())
			.collect(Collectors.joining(" \n"));
		
		JSONArray jsonEvents = CDL.toJSONArray(ja, strEvents);
		return jsonEvents.toString();
	}
	
}
