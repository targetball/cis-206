import java.util.LinkedList;
import java.util.List;

class Mountain {
    private String mountain;
    private String country;
    private double height;

    public Mountain(String mountain, String country, double height) {
        this.mountain = mountain;
        this.country = country;
        this.height = height;
    }

    public String getMountain() {
        return mountain;
    }

    public String getCountry() {
        return country;
    }

    public double getHeight() {
        return height;
    }

    public void setMountain(String mountain) {
        this.mountain = mountain;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double toMeters() {
        return height / 3.2808;
    }
}

public class main {
    public static void main(String[] args) {
        List<Mountain> mountains = createMountainList();

        System.out.printf("%-32s%-25s%-15s%s\n", "  Mountain", "Country", "Elevation (ft) ", "Elevation (meters)");
        System.out.println("-".repeat(90));

        for (Mountain mountain : mountains) {
            System.out.printf("%-30s%-25s%-15.0f%.2f\n", mountain.getMountain(), mountain.getCountry(),
                    mountain.getHeight(), mountain.toMeters());
        }

       Mountain minMountain = minHeight(mountains);
        System.out.println("\nThe shortest mountain is: " + minMountain.getMountain()
                + " " + minMountain.getHeight() + " feet");
    }

    public static List<Mountain> createMountainList() {
        List<Mountain> mountains = new LinkedList<>();
        mountains.add(new Mountain("| Chimborazo                   |", " Ecuador             |", 20549));
        mountains.add(new Mountain("| Matterhorn                   |", " Switzerland         |", 14692));
        mountains.add(new Mountain("| Olympus                      |", " Greece (Macedonia)  |", 9573));
        mountains.add(new Mountain("| Everest                      |", " Nepal               |", 29029));
        mountains.add(new Mountain("| Mount Marcy - Adirondacks    |", " United States       |", 5344));
        mountains.add(new Mountain("| Mount Mitchell - Blue Ridge  |", " United States       |", 6684));
        mountains.add(new Mountain("| Zugspitze                    |", " Switzerland         |", 9719));
        return mountains;
        
    }

    public static Mountain minHeight(List<Mountain> mountains) {
        Mountain minMountain = null;
        double minHeight = Double.MAX_VALUE; 
        System.out.println("-".repeat(90));
        for (Mountain mountain : mountains) {
            if (mountain.getHeight() < minHeight) {
                minHeight = mountain.getHeight();
                minMountain = mountain;
            }
        }

        return minMountain;
    }
}