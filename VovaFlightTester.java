

public class VovaFlightTester
{
    public static void main(String args[])
    {
        //Copy Constructor aliasing check.
        System.out.println("==========================================");
        System.out.println("COPY CONSTRUCTOR ALIASING CHECK.");
        System.out.println("==========================================");
        Flight firstFlight = new Flight("London","TLV",12,15,400,45,1000);
        Flight secondFlight = new Flight(firstFlight);
        secondFlight.setPrice(3000);
        System.out.println("first flight price: " +firstFlight.getPrice()+" Need to be 1000");
        System.out.println("second flight price: " +secondFlight.getPrice()+" Need to be 3000");
        secondFlight.setPrice(1000);
        
        //getArrival aliasing check.
        System.out.println("==========================================");
        System.out.println("GETARRIVAL ALIASING CHECK.");
        System.out.println("==========================================");
        
        secondFlight.setFlightDuration(500);
        System.out.println("The arrival time of the first flight: " +firstFlight.getArrivalTime()+" Need to be 18:55");
        System.out.println("The arrival time of the second flight: " +secondFlight.getArrivalTime() +" Need to be 20:35");
        secondFlight.setFlightDuration(400);
        
        //setDeparture aliasing check.
        System.out.println("==========================================");
        System.out.println("SETDEPARTURE ALIASING CHECK.");
        System.out.println("==========================================");
        
        Time1 depTemp = new Time1(10,15);
        secondFlight.setDeparture(depTemp);
        depTemp.setHour(20);
        depTemp.setMinute(20);
        System.out.println("The departure time of the first flight: " +firstFlight.getDeparture()+ " Need to be 12:15");
        System.out.println("The departure time of the second flight: " +secondFlight.getDeparture() + " Need to be 10:15");
        depTemp.setHour(12);
        depTemp.setMinute(15);
        secondFlight.setDeparture(depTemp);
        
        //getDestination aliasing check.
        System.out.println("==========================================");
        System.out.println("GETDESTINATION ALIASING CHECK.");
        System.out.println("==========================================");
        
        String destTemp = secondFlight.getDestination();
        destTemp = "Dublin";
        System.out.println("The destination of the second flight: " +secondFlight.getDestination()+ " Need to be TLV");
        
        //getOrigin aliasing check
        System.out.println("==========================================");
        System.out.println("GETORIGIN ALIASING CHECK");
        System.out.println("==========================================");
        
        destTemp = secondFlight.getOrigin();
        destTemp = "Dublin";
        System.out.println("second flight origin: " +secondFlight.getOrigin()+" Need to be London");
        
        //getDeparture aliasing check.
        System.out.println("==========================================");
        System.out.println("GETDEPARTURE ALIASING CHECK.");
        System.out.println("==========================================");
        
        Time1 depTimeSet = secondFlight.getDeparture();
        depTimeSet.setHour(20);
        depTimeSet.setMinute(20);
        System.out.println("The departure time of the second flight: " +secondFlight.getDeparture() + " Need to be 12:15");
        
        //setDestination aliasing check.
        System.out.println("==========================================");
        System.out.println("SETDESTINATION ALIASING CHECK.");
        System.out.println("==========================================");
        
        String destTempSet = "Rio";
        secondFlight.setDestination(destTempSet);
        destTempSet = "L.A";
        System.out.println("The destination of the second flight: " +secondFlight.getDestination()+ " Need to be Rio");
        secondFlight.setDestination("TLV");
        
        //setOrigin aliasing check
        System.out.println("==========================================");
        System.out.println("SETORIGIN ALIASING CHECK");
        System.out.println("==========================================");
        
        String originTempSet = "Jerusalem";
        secondFlight.setOrigin(originTempSet);
        originTempSet="Haifa";
        System.out.println("second flight origin: " +secondFlight.getOrigin()+ " Need to be Jerusalem");
        secondFlight.setOrigin("London");
    
        
        //addPassengers,setNoOfPassengers,isFull,toString and getPassengers test.
        System.out.println("==========================================");
        System.out.println("addPassengers,setNoOfPassengers,isFull,toString and getPassengers test.");
        System.out.println("==========================================");
        
        System.out.println("The number of passangers of the second flight: " +secondFlight.getNoOfPassengers());
        System.out.println("Were 200 passengers added?: " +secondFlight.addPassengers(200)+" Need to be true");
        System.out.println("The number of passangers of the second flight: " +secondFlight.getNoOfPassengers()+" Need to be 245");
        System.out.println(secondFlight);
        System.out.println("Were 5 passengers added?: " +secondFlight.addPassengers(5)+" Need to be true");
        System.out.println("The number of passangers of the second flight: " +secondFlight.getNoOfPassengers()+" Need to be 250");
        System.out.println(secondFlight);
        System.out.println("Were 10 passengers added?: " +secondFlight.addPassengers(10)+" Need to be false");
        System.out.println("The number of passangers of the second flight: " +secondFlight.getNoOfPassengers()+" Need to be 250");
        System.out.println(secondFlight);
        System.out.println("second flight full?: " +secondFlight.getIsFull()+" Need to be true");
        secondFlight.setNoOfPassengers(249);
        System.out.println("The number of passangers of the second flight: " +secondFlight.getNoOfPassengers()+" Need to be 249");
        System.out.println("second flight full?: " +secondFlight.getIsFull()+" Need to be false");
        secondFlight.setNoOfPassengers(-1);
        System.out.println("The number of passangers of the second flight: " +secondFlight.getNoOfPassengers()+" Need to be 249");
        secondFlight.setNoOfPassengers(0);
        System.out.println("The number of passangers of the second flight: " +secondFlight.getNoOfPassengers()+" Need to be 0");
        secondFlight.setNoOfPassengers(200);
        secondFlight.setNoOfPassengers(251);
        System.out.println("The number of passangers of the second flight: " +secondFlight.getNoOfPassengers()+" Need to be 200");
        
        //getArrival,landsEarliear  tests.
        System.out.println("==========================================");
        System.out.println("GETARRIVAL,LANDSEARLIEAR  TESTS.");
        System.out.println("==========================================");
        
        System.out.println("The arrival time of the first flight: " +firstFlight.getArrivalTime()+" Need to be 18:55");
        System.out.println("The arrival time of the second flight: " +secondFlight.getArrivalTime()+" Need to be 18:55");
        System.out.println("The flight duration of the second flight: " +secondFlight.getFlightDuration()+" Need to be 400");
        secondFlight.setFlightDuration(500);
        System.out.println("The flight duration of the second flight: " +secondFlight.getFlightDuration()+" Need to be 500");
        System.out.println("The arrival time of the first flight: " +firstFlight.getArrivalTime()+" Need to be 18:55");
        System.out.println("The arrival time of the second flight: " +secondFlight.getArrivalTime() +" Need to be 20:35");
        System.out.println("Is the first flight lands before the second:" +firstFlight.landsEarlier(secondFlight)+" Need to be true");
        System.out.println("Is the second flight lands before the first:" +secondFlight.landsEarlier(firstFlight)+" Need to be false");
        firstFlight.setFlightDuration(50000);
        System.out.println("The flight duration of the first flight: " +firstFlight.getFlightDuration()+" Need to be 50000");
        System.out.println("The arrival time of the first flight: " +firstFlight.getArrivalTime()+" Need to be 05:35");
        System.out.println("Is the first flight lands before the second:" +firstFlight.landsEarlier(secondFlight)+" Need to be false");
        System.out.println("Is the second flight lands before the first:" +secondFlight.landsEarlier(firstFlight)+" Need to be true");
        
        //getPrice,isCheper and total price tests.
        System.out.println("==========================================");
        System.out.println("getPrice,isCheper and total price tests.");
        System.out.println("==========================================");
        
        System.out.println("first flight price: " +firstFlight.getPrice()+" Need to be 1000");
        System.out.println("second flight price: " +secondFlight.getPrice()+" Need to be 1000");
        secondFlight.setPrice(5000);
        System.out.println("second flight price: " +secondFlight.getPrice()+" Need to be 5000");
        System.out.println("Is the first flight cheaper than the second:" +firstFlight.isCheaper(secondFlight)+" Need to be true");
        System.out.println("Is the second flight cheaper than the first:" +secondFlight.isCheaper(firstFlight)+" Need to be false");
        System.out.println("The number of passangers of the first flight: " +firstFlight.getNoOfPassengers());
        System.out.println("Total price of the first flight:" +firstFlight.totalPrice()+" Need to be 45000");
        System.out.println("The number of passangers of the second flight: " +secondFlight.getNoOfPassengers());
        System.out.println("Total price of the second flight:" +secondFlight.totalPrice()+" Need to be 1000000");
      
    }
}
