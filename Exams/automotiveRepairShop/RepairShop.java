package automotiveRepairShop;

import java.util.ArrayList;
import java.util.List;

public class RepairShop {
        private int capacity;
        private List<Vehicle> vehicles;

        public RepairShop(int capacity) {
            this.capacity = capacity;
            this.vehicles = new ArrayList<>();
        }

        public void addVehicle(Vehicle vehicle) {
            if (vehicles.size() < capacity) {
                vehicles.add(vehicle);
            }
        }

        public boolean removeVehicle(String vin) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getVIN().equals(vin)) {
                    vehicles.remove(vehicle);
                    return true;
                }
            }
            return false;
        }

        public int getCount() {
            return vehicles.size();
        }

        public Vehicle getLowestMileage() {

            if (vehicles.isEmpty()) {
                return null;

            }

            Vehicle lowestMileageVehicle = vehicles.get(0);
            for (int i = 1; i < vehicles.size(); i++) {

                Vehicle currentVehicle = vehicles.get(i);

                if (currentVehicle.getMileage() < lowestMileageVehicle.getMileage()) {
                    lowestMileageVehicle = currentVehicle;
                }
            }
            return lowestMileageVehicle;
        }

        public String report() {
            StringBuilder reportBuilder = new StringBuilder("Vehicles in the preparatory:\n");
            for (Vehicle vehicle : vehicles) {

                reportBuilder.append(vehicle.toString()).append("\n");

            }

            return reportBuilder.toString();
        }
    }
