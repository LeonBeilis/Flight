public class Flight {

    static final int MAX_CAPACITY = 250;
    static final int MIN_CAPACITY = 0;
    static final int MINUTES_IN_DAY = 1440;
    static final int MINUTES_IN_HOUR = 60;

    private String _origin, _destination;
    Time1 _departure;
    private int _flightDuration, _noOfPassengers, _price;
    private boolean _isFull;

    public Flight(
        String origin, String destination,
        int departureHours, int departureMinutes, int flightDuration,
        int noOfPassengers, int price
    ){
        _origin = origin;
        _destination = destination;
        _departure = new Time1(departureHours,departureMinutes);
        _flightDuration = flightDuration;
        _noOfPassengers = validatePassengersCapacity(noOfPassengers);
        _isFull = (_noOfPassengers == MAX_CAPACITY) ? true : false; 
        _price = price;
    }

    public Flight(Flight other){
        _origin = other._origin;
        _destination =other._destination;
        _departure = other._departure;
        _flightDuration = other._flightDuration;
        _noOfPassengers = other._noOfPassengers;
        _isFull = (_noOfPassengers == MAX_CAPACITY) ? true : false; 
        _price = other._price;
    }

    private static int validatePassengersCapacity(int num){
        if (num > MAX_CAPACITY){
            return MAX_CAPACITY;            
        } else if(num < MIN_CAPACITY) {
            return MIN_CAPACITY;
        } else {
            return num;
        }
    }

    public boolean equals(Flight other){
        return (_origin.equals(other._origin) && _destination.equals(other._destination) && _departure.equals(other._departure));
    }

    /**
     * todo: add support for earlier depart time
     */
    public void getArrivalTime(){
        int totalMinutes = _departure.getMinute() + (_departure.getHour() * MINUTES_IN_HOUR) + _flightDuration;
        totalMinutes = (totalMinutes >= MINUTES_IN_DAY) ? totalMinutes -= MINUTES_IN_DAY : totalMinutes;
        int arrivalHour = totalMinutes / MINUTES_IN_HOUR;
        int arrialMinute = totalMinutes % MINUTES_IN_HOUR;
        System.out.println("the Landing time is " + _departure.formatInt(arrivalHour) + ":" + _departure.formatInt(arrialMinute));
    }

    private boolean addPassengers(int num){
        if( (_noOfPassengers + num) < MAX_CAPACITY) {
            _noOfPassengers += num;
            _isFull = false;
            return true;
        } else if ( _noOfPassengers >= MAX_CAPACITY) {
            _isFull = true;
            return false;
        } else if( (_noOfPassengers + num) >= MAX_CAPACITY) {
            _isFull = false;
            return false;
        } else {
            _isFull = false;
            return false;
        }
    }

    public boolean isCheaper( Flight other ){
        return (_price < other._price) ? true : false;
    }

    public double totalPrice(){
        return ( _noOfPassengers * (double) _price );
    }
    
    public boolean landsEarlier(Flight other){
        int totalMinutesFirstFlight = _departure.getMinute() + (_departure.getHour() * MINUTES_IN_HOUR) + _flightDuration;
        int totalMinutesSecondFlight = other._departure.getMinute() + (other._departure.getHour() * MINUTES_IN_HOUR) + other._flightDuration;
        return (totalMinutesFirstFlight < totalMinutesSecondFlight) ? true : false;
    }

    public String toString(){
        String passengersAvailableStatus = (_isFull) ? "" : "not";
        return ("Flight from " + _origin + " to " + _destination + " departs at " + _departure +
                            " Flight is " + passengersAvailableStatus + " full.");
    }

    /**
     * todo's
     *     - create get/set methods by the class api, good luck.
     */

}