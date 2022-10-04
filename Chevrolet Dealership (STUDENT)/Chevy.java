package Unit3_LAB.soln;

public class Chevy {
    private  int year;
    private int mileage;
    private double fuelEffiency;
    private double price;

    private String model;
    private String color;
    private boolean luxuryPackageStatus;
    private boolean WDPackageStatus;
    private boolean sportsPackageStatus;
    public static final String MAKE = "chevrolet";
     public static final double taxRate = 0.122;
    public static final double luxaryincrease = 0.20;
    public static final double wdincrease = 3500;
     public static double sportIncrease = 0.15;
     public static final double sportDecrease = 0.20;


    public Chevy( ){
        this.year = 2021;
        color = "White";
        model = "Trax";
        price = 16000.0;

        this.fuelEffiency = 35;
        this.mileage = 0;
        luxuryPackageStatus = false;
        WDPackageStatus = false;
        sportsPackageStatus = false;

    }
    public Chevy(int y, int m, double f, double p, String mo, String co, boolean lux, boolean wd, boolean sport){
        year = y;
        mileage = m;
        fuelEffiency = f;
        price = p;

        model = mo;
        color = co;
        luxuryPackageStatus = lux;
        WDPackageStatus = wd;
        sportsPackageStatus = sport;
    }
    public double compareTo(Chevy other){
        return(this.price - other.price);

    }
    public double calcPrice(){
        double total = price;
        if(luxuryPackageStatus == true){
            total += (price * luxaryincrease);
        }
        if(WDPackageStatus == true){
            total += wdincrease;
        }
        if(sportsPackageStatus == true){
            total += (price * sportIncrease);
            fuelEffiency -= (fuelEffiency * sportDecrease);
        }
        return total + (total * taxRate);
    }


    public boolean equals(Chevy other) {

        return (this.model.equals(other.model) && this.color.equals(other.color) && ((this.mileage < 200 && other.mileage < 200) || (this.mileage >= 200 && other.mileage >= 200)));
    }



    public String toString(){
        String output = " ";
        output+= this.year + " Chevrolet " + this.model + " (" + this.color + ") " + "\n";
        output+= "Base Price: " + calcPrice() + "\n";
        output+= "Miles: " + this.mileage + "\n";
        output+= "Fuel efficency:" + this.fuelEffiency + "mpg \n";
        output+= "Packages: " + this.luxuryPackageStatus + "\n";

        if(luxuryPackageStatus){
            output+= "- luxary package";
        }
        else{
            output+=" ";
        }
        if(WDPackageStatus){
            output += "- WD package";
        }
        else{
            output+="none";

        }
        if(sportsPackageStatus){
            output+= "- sports package";
        }
        else{
            output+= "-none";
        }


        return output;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getFuelEffiency() {
        return fuelEffiency;
    }

    public void setFuelEffiency(double fuelEffiency) {
        this.fuelEffiency = fuelEffiency;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isLuxuryPackageStatus() {
        return luxuryPackageStatus;
    }

    public void setLuxuryPackageStatus(boolean luxuryPackageStatus) {
        this.luxuryPackageStatus = luxuryPackageStatus;
    }

    public boolean isWDPackageStatus() {
        return WDPackageStatus;
    }

    public void setWDPackageStatus(boolean WDPackageStatus) {
        this.WDPackageStatus = WDPackageStatus;
    }

    public boolean isSportsPackageStatus() {
        return sportsPackageStatus;
    }

    public void setSportsPackageStatus(boolean sportsPackageStatus) {
        this.sportsPackageStatus = sportsPackageStatus;
    }
}
