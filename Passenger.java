/**
 * The Passenger class represents a passenger with a name.
 */
public class Passenger {
    
    private String name;
    /**
     * Constructor for Passenger.
     * @param name The name of the passenger.
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Boards the passenger onto a specified car.
     * @param c The car to board.
     */
    public void boardCar(Car c) {
        c.addPassenger(this);
    }
    /**
     * Removes the passenger from a specified car.
     * @param c The car to get off from.
     */
    public void getOffCar(Car c) {
    c.removePassenger(this);
    }

}
