import java.util.ArrayList;
import java.util.List;

/**
 * The Train class represents a train with an engine and multiple cars.
 */
public class Train {

    // Attributes
private Engine engine;
private ArrayList<Car> cars;

    /**
     * Constructor for Train.
     * @param fuelType The type of fuel the engine uses.
     * @param fuelCapacity The maximum fuel capacity of the engine.
     * @param nCars The number of cars in the train.
     * @param passengerCapacity The passenger capacity of each car.
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, fuelCapacity, fuelCapacity);
        this.cars = new ArrayList<>();
        for (int i = 0; i < nCars; i++) {
            this.cars.add(new Car(passengerCapacity));
        }
    }

    /**
     * Constructor for Train with a list of cars.
     * @param cars The list of cars to initialize the train with.
     */
    public Train(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }


    

    /**
     * Gets the engine of the train.
     * @return The engine of the train.
     */
    public Engine getEngine() {
        return this.engine;
    }

    /**
     * Gets the car at the specified index.
     * @param i The index of the car.
     * @return The car at the specified index, or null if the index is out of bounds.
     */
    public Car getCar(int i) {
        if (i >= 0 && i < cars.size()) {
            return cars.get(i);
        } else {
            return null;
        }
    }
    /**
     * Gets the maximum passenger capacity of the train.
     * @return The maximum passenger capacity of the train.
     */
    public int getMaxCapacity() {
    int totalCapacity = 0;
        for (Car car : cars) {
            totalCapacity += car.getCapacity();
        }
        return totalCapacity;    
    }
    /**
     * Gets the total number of seats remaining in the train.
     * @return The total number of seats remaining in the train.
     */
    public int seatsRemaining() {
    int totalSeatsRemaining = 0;
        for (Car car : cars) {
            totalSeatsRemaining += car.seatsRemaining();
        }
        return totalSeatsRemaining;
    }

    /**
     * Gets the total number of passengers on the train.
     * @return The total number of passengers on the train.
     */
    public int getTotalPassengerCount() {
        int totalPassengers = 0;
        for (Car car : cars) {
            totalPassengers += car.getPassengersOnboard().size();
        }
        return totalPassengers;
    }

    /**
     * Prints the manifest of each car in the train.
     */
    public void printManifest() {
        System.out.print(generateManifest());
    }

    /**
     * Generates the manifest of each car in the train.
     * @return The manifest as a string.
     */
    public String generateManifest() {
        StringBuilder manifest = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            manifest.append("Car ").append(i + 1).append(" (Capacity: ").append(car.getCapacity()).append("):\n");
            if (car.getPassengersOnboard().isEmpty()) {
                manifest.append("  No passengers onboard.\n");
            } else {
                for (Passenger p : car.getPassengersOnboard()) {
                    manifest.append("  - ").append(p.getName()).append("\n");
                }
            }
        }
        return manifest.toString();
    }
}
