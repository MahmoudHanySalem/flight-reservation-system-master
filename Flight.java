package advanced2;


/**
 *
 * @author Mahomod
 */
public class Flight {
    String to, from,takeOffdate,landingDate;
    int flightNumber, numOfSeats;
    double cost;
            
    public Flight(int flightNumber,String to, String from, int numOfSeats,String takeOffdate,String landingDate,double cost) {
        this.flightNumber =flightNumber;
        this.to = to;
        this.from = from;
        this.numOfSeats = numOfSeats;
        this.takeOffdate=takeOffdate;
        this.landingDate=landingDate;
        this.cost=cost;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public String getTakeOffdate() {
        return takeOffdate;
    }

    public void setTakeOffdate(String takeOffdate) {
        this.takeOffdate = takeOffdate;
    }

    public String getLandingDate() {
        return landingDate;
    }

    public void setLandingDate(String landingDate) {
        this.landingDate = landingDate;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
