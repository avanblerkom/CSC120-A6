import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TrainTest {

    // Engine Tests
    @Test
    public void testEngineConstructor() {
        FuelType fuelType = FuelType.STEAM;
        double fuelCapacity = 100.0;
        Engine engine = new Engine(fuelType, fuelCapacity, fuelCapacity);
        assertEquals(fuelType, engine.getFuelType());
        assertEquals(fuelCapacity, engine.getMaxFuelLevel(), 0.01);
        assertEquals(fuelCapacity, engine.getFuelLevel(), 0.01);
    }


    @Test
    public void testEngineGo() {
        FuelType fuelType = FuelType.STEAM;
        double fuelCapacity = 100.0;
        Engine engine = new Engine(fuelType, fuelCapacity, fuelCapacity);
        // Call go() method and check fuel level
        engine.go();
        assertEquals(99.0, engine.getFuelLevel(), 0.01);
        // Call go() again and check fuel level
        engine.go();
        assertEquals(98.0, engine.getFuelLevel(), 0.01);
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        Passenger p = new Passenger("Pete");
        Car c = new Car(1);
        assertFalse(c.inOnboard(p));
        int initialPassengerCount = c.getPassengersOnboard().size();
        c.addPassenger(p);
        assertTrue(c.inOnboard(p));
        assertEquals(0, c.seatsRemaining());
        assertEquals(initialPassengerCount + 1, c.getPassengersOnboard().size()); 
    }

    @Test
    public void testCarRemovePassenger() {
        Passenger p = new Passenger("Pete");
        Car c = new Car(1);
        int initialPassengerCount = c.getPassengersOnboard().size();
        c.addPassenger(p);
        assertTrue(c.inOnboard(p));
        c.removePassenger(p);
        assertFalse(c.inOnboard(p));
        assertEquals(1, c.seatsRemaining());
        assertEquals(initialPassengerCount, c.getPassengersOnboard().size()); 
    }
    

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        Passenger p = new Passenger("Pete");
        Car c = new Car(1);
        assertFalse(c.inOnboard(p));
        c.addPassenger(p);
        assertTrue(c.inOnboard(p));
        assertTrue(c.seatsRemaining == 0);
    }

    @Test
    public void testPassengerBoardCarFull() {
        Passenger p = new Passenger("Pete");
        Car c = new Car(0);
        assertFalse(c.inOnboard(p));
        c.addPassenger(p);
        assertFalse(c.inOnboard(p));
    }


    // Train Tests
    @Test
    public void testTrainConstructor() {
        // Create a list of cars
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(10));
        cars.add(new Car(20));
        cars.add(new Car(30));

        // Initialize the train with the list of cars
        Train train = new Train(cars);

        // Verify that the train has the correct number of cars
        // Verify that each car in the train has the correct capacity
        assertEquals(10, train.getCar(0).getCapacity());
        assertEquals(20, train.getCar(1).getCapacity());
        assertEquals(30, train.getCar(2).getCapacity());
    }
    

    @Test
    public void testTrainPassengerCount() {
        // Create a list of cars
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(10));
        cars.add(new Car(20));
        cars.add(new Car(30));

        // Initialize the train with the list of cars
        Train train = new Train(cars);

        // Verify initial passenger count is 0
        assertEquals(0, train.getTotalPassengerCount());

        // Create passengers
        Passenger p1 = new Passenger("Alice");
        Passenger p2 = new Passenger("Bob");
        Passenger p3 = new Passenger("Charlie");

        // Board passengers
        cars.get(0).addPassenger(p1);
        cars.get(1).addPassenger(p2);
        cars.get(2).addPassenger(p3);

        // Verify passenger count after boarding
        assertEquals(3, train.getTotalPassengerCount());

        // Remove passengers
        cars.get(0).removePassenger(p1);
        cars.get(1).removePassenger(p2);

        // Verify passenger count after removing
        assertEquals(1, train.getTotalPassengerCount());
    }

    @Test
    public void testTrainGetCar() {
        // Create a list of cars
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car(10);
        Car car2 = new Car(20);
        Car car3 = new Car(30);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        // Initialize the train with the list of cars
        Train train = new Train(cars);

        // Verify that the getCar method returns the expected cars
        assertEquals(car1, train.getCar(0));
        assertEquals(car2, train.getCar(1));
        assertEquals(car3, train.getCar(2));
    }

    @Test
    public void testTrainPrintManifest() {
        // Create a list of cars
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car(10);
        Car car2 = new Car(20);
        Car car3 = new Car(30);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        // Add passengers to cars
        Passenger p1 = new Passenger("Alice");
        Passenger p2 = new Passenger("Bob");
        Passenger p3 = new Passenger("Charlie");
        car1.addPassenger(p1);
        car2.addPassenger(p2);
        car3.addPassenger(p3);

        // Initialize the train with the list of cars
        Train train = new Train(cars);

        // Generate the manifest
        String manifest = train.generateManifest();

        // Expected output
        String expectedOutput = 
            "Car 1 (Capacity: 10):\n" +
            "  - Alice\n" +
            "Car 2 (Capacity: 20):\n" +
            "  - Bob\n" +
            "Car 3 (Capacity: 30):\n" +
            "  - Charlie\n";

        // Verify the output
        assertEquals(expectedOutput, manifest);
    }
    
}
