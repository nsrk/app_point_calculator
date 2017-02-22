package com.point.calculator.util;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sivaramakrishna
 *
 */
public class DistanceCalculator {

	private static final Logger log = LoggerFactory.getLogger(DistanceCalculator.class);

	public static void arrangeByDistance(final Point myPoint, List<Point> pointList) {

		log.info("In the arrangeByDistance method");
		Collections.sort(pointList, new Comparator<Point>() {

			public int compare(Point o1, Point o2) {
				double dist1 = Math.sqrt(Math.pow(myPoint.x - o1.x, 2) - Math.pow(myPoint.y - o1.y, 2));
				double dist2 = Math.sqrt(Math.pow(myPoint.x - o2.x, 2) - Math.pow(myPoint.y - o2.y, 2));
				return Double.compare(dist1, dist2);
			}
		});

		for (Point point : pointList) {
			System.out.println(point.toString());
		}
	}

}
