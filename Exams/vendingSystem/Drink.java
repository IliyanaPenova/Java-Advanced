package vendingSystem;

import java.math.BigDecimal;

public class Drink {
//    •	name - String
//•	price - BigDecimal
//•	volume - int
        private String name;
        private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public Drink(String name, BigDecimal price, int volume) {
            this.name = name;
            this.price = price;
            this.volume = volume;
        }

        @Override
        public String toString() {
            return String.format("Name: %s, Price: $%s, Volume: %d ml", name, price, volume);
        }
    }