// Anthony Wocken
// HW05
// 11/7/16
// client class
/**
 * This class creates a location object 
 *
 * @author Anthony Wocken
 * @version 1.8.0_66
 */
public class Location
{
    /** instance variables */
    private String locationName;
    private double numLatitude;
    private double numLongitude;
    private double lat1;
    private double lat2;
    private double lng1;
    private double lng2;
    
    /** Constructor for objects of class Location */
    
    public Location(String name, double lat, double lon) {
        locationName = name;
        numLatitude = lat;
        numLongitude = lon;
        if ( numLatitude < -90 || numLatitude > 90 || numLongitude < -180 || numLongitude > 180) {
            throw new IllegalArgumentException("Error: Invalid coordinate");
        }
    }
    
    /**
     * Get the latitude of this location
     * @return numLatitude the latitude of this location
     */
    public double getLatitude() {
        return numLatitude;
    }
    
    /**
     * Get the longitude of this location
     * @return numLongitude the longitude of this location
     */
    public double getLongitude() {
        return numLongitude;
    }    
    
    /**
     * Get the name of this location
     * @return locationName the name of this location
     */
    public String getName() {
        return locationName;
    }
    
    /**
     * Get String version of name, latitude, and longitude of this location
     * @return String representation of this Location
     */
    public String toString() {
        return locationName + " " + numLatitude + " " + numLongitude;
    }
    
    /**
     * Calculate the distance between this location and the parameter
     * @param Location l location to get distance to
     * @return dist the distance between this Location and the parameter
     */
    public double distance(Location l) {
          // earth's radius, in miles
         double earthRadius = 3963.1;     

         // convert all angles to radians
         lat1 = Math.toRadians(numLatitude);            
         lat2 = Math.toRadians(l.getLatitude());
         lng1 = Math.toRadians(numLongitude);
         lng2 = Math.toRadians(l.getLongitude());
         
         // calculate the Haversine formula in pieces
         double dLat = lat2-lat1;     
         double dLng = lng2-lng1;
         double sindLat = Math.sin(dLat / 2);     
         double sindLon = Math.sin(dLng / 2);     
         double a = Math.pow(sindLat, 2) + Math.pow(sindLon, 2) * Math.cos(lat1) * Math.cos(lat2);
         double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
         double dist = earthRadius * c;
         
         return dist;
    
    }
}
