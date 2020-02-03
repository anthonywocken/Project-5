// Anthony Wocken
// HW05
// 11/7/16
// EXTRA CREDIT - the helper methods should be private, not public for a couple main reasons.
// Making them private makes them more secure and helps prevent glitches/bugs. 
// It also helps reduce the liklihood of bugs in the program, since they can only be accessed
// by the class they are part of. Otherwise they could be accidentally called from elsewhere
// in the program, which can cause issues.






/**
 * This class creates a GeoSet object using the data from the specified file name 
 *
 * @author Anthony Wocken
 * @version 1.8.0_66
 */
/** import declarations */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GeoSet
{
    /** instance variables */
    private int numLocations;
    private String fileName;
    private String locationName;
    private double numLatitude;
    private double numLongitude;
    private double minDist;
    private double distAmt;
    private Location[] locationList;
    private String locationSummary;
    
    /**
     * Constructor for objects of class GeoSet
     * @param filename
     * @throws if file is not found
     */
    public GeoSet(String filename) throws FileNotFoundException {
        
        fileName = filename;
        Scanner input = new Scanner(new File(fileName));
        numLocations = input.nextInt();
        if (numLocations < 2) {
            throw new IllegalArgumentException("Error: file must contain data for 2 or more locations");
        }
        locationList = new Location[numLocations];
        
        for ( int i = 0; i < numLocations; i++) {
            locationName = input.next();
            numLatitude = input.nextDouble();
            numLongitude = input.nextDouble();
            
            locationList[i] = new Location(locationName, numLatitude, numLongitude);
        }
    }    

    
    /**
     * Gets the number of Locations in this set
     * @return numLocations returns number of Locations in this set
     */
    public int getCount() {
        return numLocations;
    }
    
    
    /**
     * Finds the smallest distance between 2 consecutive Locations in this set
     * @return minDist returns the smallest distance between 2 consecutive Locations in this set
     */
    public double findMinDist() {
        minDist = locationList[0].distance(locationList[1]);
        for ( int i = 2; i < numLocations; i++) {
            distAmt = locationList[i].distance(locationList[i-1]);
            if ( distAmt < minDist) {
                minDist = distAmt;
            }
        }
        return minDist;
    }
    
    /**
     * Searches for location name that matches the parameter. Return null if no match found. 
     * @param name location name to search for
     * @return returns the Location whose name matches the parameter. returns null if no match found. 
     */
    public Location find(String name) {
        String searchName = name;
        for (int i = 0; i < numLocations; i++) {
            locationName = locationList[i].getName();
            if (locationName.equals(searchName)) {
                return locationList[i];
            }
        }
        return null;
    }
    
    /**
     * Finds the 2 locations in this set that are farthest away from eachother
     * @return returns an array of the 2 Location objects that are the farthest from each other
     */
    public Location[] farthest() {
        
        Location[] farthestLoc = new Location[2];
        double maxDist = locationList[0].distance(locationList[1]);
        farthestLoc[0] = locationList[0];
        farthestLoc[1] = locationList[1];
        
        for (int i = 0; i < numLocations-1; i++) {
            for (int x = i + 1; x < numLocations; x++) {
                distAmt = locationList[i].distance(locationList[x]);
                if ( distAmt > maxDist) {
                    maxDist = distAmt;
                    farthestLoc[0] = locationList[i];
                    farthestLoc[1] = locationList[x];
                }
            }
        }
        return farthestLoc;
    }
    
    /**
     * Returns a string summary of the GeoSet
     * @return locationSummary returns a String that contains the String representation for each Location object in this GeoSet
     */
    public String toString() {
        locationSummary = "";
        for(int i = 0; i < numLocations; i++) {
            locationSummary += locationList[i].getName() + " ";
            locationSummary += locationList[i].getLatitude() + " ";
            locationSummary += locationList[i].getLongitude() + "\n";
        }
        return locationSummary;
    }

    
}
