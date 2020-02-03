import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main
{

    public static void main(String[] args) throws FileNotFoundException {
    
        
        Location loc2;
        Location[] loc3 = new Location[2];
        System.out.println("initializes a GeoSet object");
        GeoSet file1 = new GeoSet("locations1.txt");
        
        System.out.println();
        
        System.out.println("GeoSet Methods****\n");
        
        System.out.println("getCount:");
        System.out.println(file1.getCount() + "\n");
        
        System.out.println("findMinDist:");
        System.out.println(file1.findMinDist() + "\n");
        
        System.out.println("findStringName:");
        loc2 = file1.find("NYC");
        System.out.println(loc2 + "\n");
        
        System.out.println("farthest:");
        loc3 = file1.farthest();
        System.out.println(loc3[0]);
        System.out.println(loc3[1] + "\n");
        
        System.out.println("toString:");
        System.out.println(file1.toString() + "\n");

        
        System.out.println("Location Methods****\n");
        
        System.out.println("getLatitude:");
        System.out.println(loc2.getLatitude());
        System.out.println();
        
        System.out.println("getLongitude");
        System.out.println(loc2.getLongitude());
        System.out.println();
        
        System.out.println("getName");
        System.out.println(loc2.getName());
        System.out.println();
        
        System.out.println("toString");
        System.out.println(loc2.toString());
        System.out.println();
        
        System.out.println("distance");
        System.out.println(loc2.distance(loc3[0]));
    
    }
}
