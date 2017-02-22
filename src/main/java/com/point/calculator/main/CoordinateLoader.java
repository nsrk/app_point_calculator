package com.point.calculator.main;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;

import com.point.calculator.model.Coordinate;
import com.point.calculator.util.DistanceCalculator;

import ch.qos.logback.classic.Logger;

/**
 * @author Sivaramakrishna
 *
 */
public class CoordinateLoader {

	private static final Logger log = (Logger)LoggerFactory.getLogger(CoordinateLoader.class);
	
	
	public static void main(String[] args)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		List<Map<Point, String>> list = new ArrayList<Map<Point, String>>();
		Map<Point, String> map = new HashMap<Point, String>();
		ObjectMapper mapper = new ObjectMapper();
		InputStream is = CoordinateLoader.class.getResourceAsStream("/coordinates.json");
		log.info("Successfully loaded json data from properties file");
		List<Coordinate> coordinatesList = mapper.readValue(is,
				TypeFactory.defaultInstance().constructCollectionType(List.class, Coordinate.class));

		Point point;
		List<Point> pointList = new ArrayList<Point>();

		for (Coordinate coordinate : coordinatesList) {
			String[] values = coordinate.getValue().split(",");
			int pointX = Integer.parseInt(values[0]);
			int pointY = Integer.parseInt(values[1]);
			point = new Point(pointX, pointY);
			pointList.add(point);
			map.put(point,coordinate.getId());
			list.add(map);
		}

		Point myPoint = new Point(31, 49);
		DistanceCalculator.arrangeByDistance(myPoint, pointList);
		//DistanceCalculator.printSortedList(list, pointList);

	}

}
