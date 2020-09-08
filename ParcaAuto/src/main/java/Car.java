
public class Car implements Leasing {
        private String make;
        private String model;
        private String color;
        private int price;
        private String fuelType;
        private int yearMake;
        private boolean sold = false;


        public Car(String make, String model, String color, int price, String fuelType, int yearMake) {
            this.make = make;
            this.model = model;
            this.color = color;
            this.price = price;
            this.fuelType = fuelType;
            this.yearMake = yearMake;
        }

        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getPrice() {
            return price;
        }

        public String getFuelType() {
            return fuelType;
        }

        public int getYearMake() {
            return yearMake;
        }

        public int compareTo(Car o) {
            if (this.yearMake < o.getYearMake()) {
                return -1;
            } else if (this.yearMake > o.getYearMake()) {
                return 1;
            } else {
                return 0;
            }
        }

        public int installments() {
            return 24;
        }

        public int payRate() {
            return this.price / installments();
        }

        public boolean getSold() {
            if ((this.make.equals("Audi") || this.make.equals("BMW") || this.make.equals("Opel") || this.make.equals("VW")) && this.color.equals("negru") && this.fuelType.equals("benzina")) {
                return true;
            }else{
                return false;
            }
        }
    }


