package vendingSystem;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class VendingMachine {
    //    •	buttonCapacity - int
//•	drinks – List<Drink>
        private int buttonCapacity;
        private List<Drink> drinks;

        public VendingMachine(int buttonCapacity) {
            this.buttonCapacity = buttonCapacity;
            this.drinks = new ArrayList<>();
        }

        public int getCount() {
            return drinks.size();
        }

        public void addDrink(Drink drink) {
            if (drinks.size() < buttonCapacity) {
                drinks.add(drink);
            }
        }

        public boolean removeDrink(String name) {
            for (Drink drink : drinks) {
                if (drink.getName().equals(name)) {
                    drinks.remove(drink);
                    return true;
                }
            }
            return false;
        }

        public Drink getLongest() {
            Drink longestDrink = null;
            int maxVolume = 0;
            for (Drink drink : drinks) {
                if (drink.getVolume() > maxVolume) {
                    maxVolume = drink.getVolume();
                    longestDrink = drink;
                }
            }
            return longestDrink;
        }

        public Drink getCheapest() {
            Drink cheapestDrink = null;
            BigDecimal minPrice = BigDecimal.valueOf(Double.MAX_VALUE);
            for (Drink drink : drinks) {
                if (drink.getPrice().compareTo(minPrice) < 0) {
                    minPrice = drink.getPrice();
                    cheapestDrink = drink;
                }
            }
            return cheapestDrink;
        }

        public String buyDrink(String name) {
            for (Drink drink : drinks) {
                if (drink.getName().equals(name)) {
                    return drink.toString();
                }
            }
            return null;
        }

        public String report() {
            StringBuilder report = new StringBuilder("Drinks available:\n");
            for (Drink drink : drinks) {
                report.append(drink.toString()).append("\n");
            }
            return report.toString();
        }
    }
