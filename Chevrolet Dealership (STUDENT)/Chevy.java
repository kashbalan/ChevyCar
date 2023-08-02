package Unit3_LAB.soln;

/**
 * This class represents a Chevy vehicle and provides methods to manage and calculate its properties.
 */
public class Chevy {

    // Class-level private fields to represent the properties of a Chevy vehicle
    private int year;                // The manufacturing year of the vehicle
    private int mileage;             // The total mileage of the vehicle
    private double fuelEfficiency;  // The fuel efficiency of the vehicle in miles per gallon
    private double basePrice;       // The base price of the vehicle
    private String model;           // The model name of the vehicle
    private String color;           // The color of the vehicle
    private boolean hasLuxuryPackage;    // A flag indicating if the vehicle has a luxury package
    private boolean hasWDPackage;        // A flag indicating if the vehicle has a WD (Wheel Drive) package
    private boolean hasSportsPackage;    // A flag indicating if the vehicle has a sports package

    // Class-level constants for Chevrolet vehicles
    public static final String MAKE = "chevrolet";  // The make of all Chevy vehicles is "chevrolet"
    public static final double TAX_RATE = 0.122;   // The tax rate applied to the total price
    public static final double LUXURY_INCREASE = 0.20;  // The increase in price due to the luxury package
    public static final double WD_INCREASE = 3500;     // The increase in price due to the WD package
    public static final double SPORT_INCREASE = 0.15;   // The increase in price due to the sports package
    public static final double SPORT_DECREASE = 0.20;   // The decrease in fuel efficiency due to the sports package

    // Default constructor to initialize the Chevy object with default values
    public Chevy() {
        this.year = 2021;          // Set the default manufacturing year to 2021
        this.color = "White";      // Set the default color to White
        this.model = "Trax";       // Set the default model to Trax
        this.basePrice = 16000.0;  // Set the default base price to $16,000.0
        this.fuelEfficiency = 35;  // Set the default fuel efficiency to 35 miles per gallon
        this.mileage = 0;          // Set the default mileage to 0
        this.hasLuxuryPackage = false;  // The default status of the luxury package is not present
        this.hasWDPackage = false;      // The default status of the WD package is not present
        this.hasSportsPackage = false;  // The default status of the sports package is not present
    }

    // Parameterized constructor to initialize the Chevy object with custom values
    public Chevy(int year, int mileage, double fuelEfficiency, double basePrice, String model, String color,
            boolean hasLuxuryPackage, boolean hasWDPackage, boolean hasSportsPackage) {
        // Assign the provided values to the corresponding fields
        this.year = year;
        this.mileage = mileage;
        this.fuelEfficiency = fuelEfficiency;
        this.basePrice = basePrice;
        this.model = model;
        this.color = color;
        this.hasLuxuryPackage = hasLuxuryPackage;
        this.hasWDPackage = hasWDPackage;
        this.hasSportsPackage = hasSportsPackage;
    }

    // Method to compare two Chevy objects based on their price
    public double compareTo(Chevy other) {
        // Calculate the price difference between this Chevy object and the other Chevy object
        return this.basePrice - other.basePrice;
    }

    // Method to calculate the total price of the Chevy vehicle including packages and tax
    public double calculateTotalPrice() {
        double total = basePrice;  // Start with the base price

        // Add price increase for luxury package if present
        if (hasLuxuryPackage) {
            total += (basePrice * LUXURY_INCREASE);
        }

        // Add price increase for WD package if present
        if (hasWDPackage) {
            total += WD_INCREASE;
        }

        // Add price increase for sports package and decrease fuel efficiency if present
        if (hasSportsPackage) {
            total += (basePrice * SPORT_INCREASE);
            fuelEfficiency -= (fuelEfficiency * SPORT_DECREASE);
        }

        // Add tax to the total price and return the final total
        return total + (total * TAX_RATE);
    }

    // Method to check if two Chevy objects are equal based on their model, color, and mileage
    public boolean equals(Chevy other) {
        // Check if the model and color are the same and if both vehicles have mileage below 200 or above 200
        return (this.model.equals(other.model) && this.color.equals(other.color)
                && ((this.mileage < 200 && other.mileage < 200) || (this.mileage >= 200 && other.mileage >= 200)));
    }

    // Method to represent the Chevy object as a String with its properties
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        // Build the string representation of the Chevy object with its properties
        output.append(year).append(" Chevrolet ").append(model).append(" (").append(color).append(")\n");
        output.append("Base Price: ").append(calculateTotalPrice()).append("\n");
        output.append("Miles: ").append(mileage).append("\n");
        output.append("Fuel Efficiency: ").append(fuelEfficiency).append(" mpg\n");
        output.append("Packages: ");

        // Check which packages are present and include them in the output string
        if (hasLuxuryPackage) {
            output.append("- Luxury package ");
        }
        if (hasWDPackage) {
            output.append("- WD package ");
        }
        if (hasSportsPackage) {
            output.append("- Sports package ");
        }

        return output.toString().trim(); // Remove trailing whitespace and return the final string representation
    }

    // Getters and setters for the private fields (not shown here for brevity)
    // ...
}

