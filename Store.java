public class Store {
    private Canting[] cantings;
    //private Rate[] rates;
    //public Store() {}
    private int numCantings = 0;
    public Store(int numberofCantings) { this.cantings = new Canting[numberofCantings]; }
    private boolean isFull() { return (numCantings == cantings.length); }
    public boolean isEmpty() { return (numCantings == 0); }




    public boolean addCanting(Canting canting) {
        if (isFull()) {
            return false;
        } else {
            cantings[numCantings] = canting;
            numCantings++;
            return true;
        }
    }

    public String listCantings() {
        if (isEmpty()) {
            return "No Restaurants exist, try to buy a takeaway";
        } else {
            String list = "";
            for (int i = 0; i < numCantings; i++) {
                list += cantings[i].toString();
            }
            return list;
        }


    }
    public Canting cheapestCanting() {
        if (isEmpty()) {
            return null;

        }else {Canting cheapestCanting = cantings[0];
        for (int i = 1; i < numCantings; i++) {
            if (cantings[i].getPrice()< cheapestCanting.getPrice())
                cheapestCanting = cantings[i];
        }
        return cheapestCanting;
    }}
    public double averageRate(){
        if (!isEmpty()) {
            double sum = 0;
            for (int i = 0; i < numCantings; i++) {
                sum += cantings[i].getRates();
            }
            return sum/numCantings;
        }else {
            return -1;
        }

    }
    public double specificalRate(int id){
        for (int i = 0; i < numCantings; i++) {
            if (cantings[i].getId()==id){
                return cantings[i].getRates();
            }
        }return -1;
    }
    public Canting specificalRate2(int id){
        for (int i = 0; i < numCantings; i++) {
            if (cantings[i].getId()==id){
                return cantings[i];
            }
        }return null;
    }

            public String printCAAR(double rate){
        if (!isEmpty()) {
            String str = "";
            for (int i = 0; i < numCantings; i++) {
                if (cantings[i].getRates() < rate)
                    str += i +":"+cantings[i].toString();
            }
            if (str.equals("")){
                return "No Restaurants are above this rate:"+rate;
            }else {
                return str;
            }

        }else return "No restaurant exists";
    }




    // public Rate highestRate() {
     //   if (isEmpty()) {
     //       return null;

      //  }else {Rate highestRate = cantings[0];
       //     for (int i = 1; i < numCantings; i++) {
        //        if (cantings[i].getRates()< highestRate.getRates())
       //             highestRate = cantings[i];
        //    }
       //     return cheapestCanting;
      //  }}



}
