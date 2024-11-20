import java.util.Scanner;
public class Menu {
    private  Scanner input = new Scanner(System.in);
    private Store store;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Menu();
    }
    public Menu() {
        store = new Store(1114);
        listorder();


    }

    private int theMenu() {
        System.out.println("""
                Welcome to the Menu
                -------------------
                1.list the restaurants
                2.list the average rate of the restaurant
                3.give rates to the restaurants
                4.add restaurant
                5.exit
                6.list the cheapest restaurants
                7.find the restaurants that above your exception
                8.check the availability of restaurants
                -------------------
                  """);
        int choice = input.nextInt();
        return choice;
    }
    private void listorder() {
        int choice = theMenu();
        while (choice != 5) {
            switch (choice) {
                case 1:
                    listthelist();
                    break;
                case 2:
                    listtherates();
                    break;
                case 3:
                    addrates();
                    break;
                case 4:
                    addrestaurants();
                    break;
                case 5:
                    break;
                case 6:
                    listthecheapestCanting();
                    break;
                case 7:
                    listRestaurantAboveArate();
                    break;
                case 8:
                    checktheava();
                    break;

                default:
            }
            System.out.println("Press any key to continue...");
            input.nextLine();
            input.nextLine();
            choice = theMenu();
        }
        System.out.println("Thanku for using Bye");
        System.exit(5);

    }
    private void listthelist() {
        if(store.isEmpty()){
            System.out.println("There are no restaurants in the store");
        }else{
        System.out.println("List of restaurants is below:");
        System.out.print(store.listCantings());}
      //  theMenu();
    }
    private void listthecheapestCanting() {
        Canting cheapestCanting =store.cheapestCanting();
        if (cheapestCanting != null) {
            System.out.println("The cheapest restaurant is:"+cheapestCanting);
        }
        else {
            System.out.println("404 no found");
        }
    }
    private int listtherates() {
        int choice2 = 0;
        while (choice2 != 3) {
            System.out.println("""
                    Which rate you want to check?
                    1.the average rate of all restaurants
                    2.the rate of one specific restaurant
                    3.return to the menu
                    """);
            choice2 = input.nextInt();
            switch (choice2) {
                case 1:
                    averageRate();
                    break;
                case 2:
                    qidong();
                    break;
                case 3:
                    theMenu();
                    break;

                default:
                    System.out.println("你应该问一下你自己为什么会看到这句话");
            }

        }
        return choice2;
    }

private void averageRate() {
        double averageRate = store.averageRate();
        if (averageRate != -1) {
           System.out.println("The average rate of the restaurant is:"+averageRate);
       }else{
           System.out.println("404 no found");}}
    private void qidong() {
        System.out.println("Enter the restaurantID you want to check:");
        int id = input.nextInt();
        double rate = store.specificalRate(id);
        if (rate != -1) {
            System.out.println("The rate of this restaurant is:"+rate);
        }else
            System.out.println("404 no found");

    }
//从这
    private void addrates() {
        System.out.println("Enter the restaurantID you want to add rate:");
        int id = input.nextInt();
        Canting canting = store.specificalRate2(id);
        if (canting != null) {
            double RRRR = addrate();
            canting.setRates(RRRR);
    }else{
            System.out.println("404 no found");
            theMenu();
        }
    }
    private double addrate(){
        input.nextLine();
        System.out.println("Enter the rate:");
        double rates = input.nextDouble();
        return rates;
    }
    //
    private void addrestaurants() {
        System.out.println("How many restaurants would you like to add?");
        int  numberofrestaurants = input.nextInt();
        store = new Store(numberofrestaurants);
        for (int i = 0; i < numberofrestaurants; i++) {
            addrestaurant();
        }
    }
   // public double settime() {
    //    System.out.println("Please enter the time now");
     //   double recentTime = input.nextDouble();
     //   return recentTime;
   // }
    private void addrestaurant() {
        input.nextLine(); //别动！！！！！！！！
        System.out.println("Enter the restaurant name:");
        String name = input.nextLine();
        System.out.println("Enter the restaurant ID:");
        int id = input.nextInt();
        input.nextLine();//别动！！！！！！！！
        System.out.println("Enter the restaurant address:");
        String location = input.nextLine();
        System.out.println("Enter the average cost of the restaurant :");
        int price = input.nextInt();
       // double rates =0;
       

        System.out.println("When is this restaurant Open? for example 12:00AM should be entered as 12.00");
        double Opentime = input.nextDouble();
        System.out.println("When is this restaurant Closed?");
        double Closetime = input.nextDouble();
        boolean available = false;
        double recentTime = 12.00;
        if ((recentTime >= Opentime) && (recentTime <= Closetime))
            available = true;
        double rates = addrate();
        boolean isAdded = store.addCanting(new Canting(id, name, price, location,rates,available,Opentime,Closetime));
        //rate  我打算在另一块里输入
        if (isAdded) {
            System.out.println("Added restaurant successfully");
        } else {
            System.out.println("Not added restaurant successfully");
        }


    }
    private void listRestaurantAboveArate() {
        System.out.println("View the restaurant rating above this rate:");
        double rating = input.nextDouble();
        System.out.println(store.printCAAR(rating));
    }
    private  void checktheava() {
        System.out.println("What time is it now?");
        double RTtime = input.nextDouble();
        System.out.println("Enter the restaurantID you want to check:");
        int id = input.nextInt();
        Canting canting = store.specificalRate2(id);
        if(canting.available(RTtime)){
            System.out.println("the restaurant is available now");
        }else{
            System.out.println("the restaurant is not available yet"+"\n"+
                    "their available time is from" + canting.getOpentime()+"to"+ canting.getClosetime());
        }

    }


}
