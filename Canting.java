public class Canting {
    private int id;
    private String name;
    private int price;
    private String location;
    private double rates;
    private boolean available = false;
    private double opentime;
    private double closetime;

    public boolean available(double RTtime) {
        if(RTtime>= opentime && RTtime<closetime) {
            available = true;
        }else {
            available = false;
        }
        return available;
    }

    public Canting(int id, String name, int price , String location, double rates , boolean available, double opentime, double closetime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.location = location;
        this.rates = rates;
        this.available = available;
        this.opentime = opentime;
        this.closetime = closetime;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getLocation() { return location; }
    public double getRates() { return rates; }
    public boolean isAvailable() { return available; }
    public double getOpentime() { return opentime; }
    public double getClosetime() { return closetime; }
    //我一路tab下来的
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(int price) { this.price = price; }
    public void setLocation(String location) { this.location = location; }
    public void setRates(double rates) { this.rates = rates; }
    public void setAvailable(boolean available) { this.available = available; }
    public void setOpentime(double opentime) { this.opentime = opentime; }
    public void setClosetime(double closetime) {this.closetime = closetime;}

    public String toString() {
        return "The name of the restaurant is " + name +"\n"
        + "and its ID is " + id +"\n"
                + "and its price is " + price+"\n"
                + "and its location is " + location+"\n"
                + "and its rates is " + rates+"\n"
                + "and is it available now " + available+"\n"
                + "and its opentime is " + opentime+"\n"
                + "its closetime is" + closetime+"\n";

    }
}
