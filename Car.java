import java.util.ArrayList;

/**
 * The Car class represents a car in a train, which can hold passengers.
 */
public class Car {
    // Attributes
    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;
    public int seatsRemaining;

public boolean inOnboard (Passenger p) {
    return this.passengersOnboard.contains(p);
}

    /**
     * Constructor for Car.
     * @param maxCapacity The maximum passenger capacity of the car.
     */
    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengersOnboard = new ArrayList<>();
    }

    /**
     * Gets the maximum passenger capacity of the car.
     * @return The maximum passenger capacity of the car.
     */
    public int getCapacity() {
        return maxCapacity;
    }
    /**
     * Gets the number of seats remaining in the car.
     * @return The number of seats remaining in the car.
     */
    public int seatsRemaining() {
        return maxCapacity - passengersOnboard.size();
    }

    /**
     * Gets the list of passengers currently onboard.
     * @return The list of passengers currently onboard.
     */
    public ArrayList<Passenger> getPassengersOnboard() {
        return new ArrayList<>(passengersOnboard);
    }

    /**
     * Adds a passenger to the car.
     * @param p The passenger to add.
     * @return True if the passenger was successfully added, false otherwise.
     */
    public Boolean addPassenger(Passenger p) {
        if (seatsRemaining() > 0) {
            passengersOnboard.add(p);
            return true;
        } else {
            return false;
        }
    }
    /**
     * Removes a passenger from the car.
     * @param p The passenger to remove.
     * @return True if the passenger was successfully removed, false otherwise.
     */
    public Boolean removePassenger(Passenger p) {
        if (passengersOnboard.remove(p)) {
            seatsRemaining++; // Update seatsRemaining
            return true;
        } else {
            return false;
        }
    }


     /**
     * Prints the manifest of passengers in the car.
     */
    public void printManifest() {
        for (Passenger p : passengersOnboard) {
            System.out.println(p);
        }
    }
    
    
}