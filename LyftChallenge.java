/*
Problem:
Calculate the detour distance between two different rides.
Given four latitude / longitude pairs, where driver one is traveling from
point A to point B and driver two is traveling from point C to point D,
write a function (in your language of choice) to calculate the shorter
of the detour distances the drivers would need to take to pick-up and
drop-off the other driver.

Assumptions:
Driver one is driving from A to B
Driver two is driving from C to D

Find distance ACDB
Find disatance CABD

Choose the shortest distance the driver would need to take.

Assume using Kilometers

Radius of Earth = 6371 Km

point A is in index 0 in array points, followed by B, C, and D.
*/

import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class LyftChallenge {

  public static void main(String[] args){

    System.out.println("LyftChallenge");

    // Initialize four Points
    Point[] points = new Point[4];

    // Generate Points Randomly
    for (int i = 0; i<4; i++)
    {
      // Generates latitude
      points[i] = new Point(
        ThreadLocalRandom.current().nextInt(-90, 90 + 1),
      // Generates longitude
        ThreadLocalRandom.current().nextInt(-180, 180 + 1));
    }

    // Print points
    for (Point point : points){
      System.out.print(point.toString() + ", ");
    }
    System.out.println();

    // Calculate Paths
    double distanceACDB = haversine(points[2], points[3]);
    double distanceCABD = haversine(points[0], points[1]);

    // Check for sortest path
    if (distanceACDB < distanceCABD){
      System.out.println("Take route ACDB");
    }
    else if (distanceACDB == distanceCABD){
      System.out.println("Both routes are equal");
    }
    else {
      System.out.println("Take route CABD");
    }
  }

  public static double haversine(Point p1, Point p2){
    final int radius = 6371;
    double distanceLatitude = Math.toRadians(p2.latitude - p1.latitude);
    double distanceLongitude = Math.toRadians(p2.longitude - p2.longitude);
    double latitude1 = Math.toRadians(p1.latitude);
    double latitude2 = Math.toRadians(p2.latitude);

    double a = Math.pow(Math.sin(distanceLatitude / 2), 2) +
               Math.pow(Math.sin(distanceLongitude /2), 2) *
               Math.cos(latitude1) *
               Math.cos(latitude2);
    double c = 2 * Math.asin(Math.sqrt(a));
    return radius * c;
  }
}

// Point on map
class Point {

  // Latitude of point
  int latitude;

  // Longitude of point
  int longitude;

  // Constructor
  public Point(int latitude, int longitude){
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public String toString(){
    return "(" + latitude + ", " + longitude + ")";
  }
}
