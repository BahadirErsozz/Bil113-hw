import java.util.ArrayList;
public class TripReservation{
	ArrayList<BusCompany> registeredBusCompanies;
	ArrayList<Ticket> soldTickets;
	ArrayList<Trip> designatedTrips;
	
	public TripReservation(ArrayList<BusCompany> registeredBusCompanies){
		designatedTrips = new ArrayList<Trip>();
		int a = 1;
		this.registeredBusCompanies = new ArrayList<BusCompany>();
		
		for(int i= 0; i< registeredBusCompanies.size(); i++){
			for(int j = 0; j < registeredBusCompanies.get(i).designatedTrips.size(); j++){
				if(registeredBusCompanies.get(i) != null){
					designatedTrips.add(registeredBusCompanies.get(i).designatedTrips.get(j));
					if (!this.registeredBusCompanies.contains(registeredBusCompanies.get(i)))
						this.registeredBusCompanies.add(registeredBusCompanies.get(i));
					
						
				}
			}
		
		}
		soldTickets = new ArrayList<Ticket>();
		
	}
	public void printAllRegisteredCompanies(){
		for(int i = 0; i < registeredBusCompanies.size(); i++){
			if (registeredBusCompanies.get(i) == null );
			else
				System.out.println(registeredBusCompanies.get(i).name);
		}
	}
	public ArrayList<Trip> findAllTrips(String source, String destination, Date date1, Date date2, String seatType)
	{
		ArrayList<Trip> suitableTrips = new ArrayList<Trip>();
		
		for(int i = 0; i < designatedTrips.size(); i++){
			if(date1.compareTo(designatedTrips.get(i).date) == -1 && date2.compareTo(designatedTrips.get(i).date) == 1){
				if(designatedTrips.get(i).seatType == seatType){
					
					if(designatedTrips.get(i).destination == destination && designatedTrips.get(i).source == source){
						suitableTrips.add(designatedTrips.get(i));
						
					}				
				}
			
			}
		}
		return suitableTrips;
	}
	
	public ArrayList<Trip> findAllTrips(String source, String destination, Date date)
	{	
		ArrayList<Trip> suitableTrips = new ArrayList<Trip>();
		
		for(int i = 0; i < designatedTrips.size(); i++){
			if(designatedTrips.get(i).date.compareTo(date) == 0){
			
				if(designatedTrips.get(i).destination == destination && designatedTrips.get(i).source == source){
						suitableTrips.add(designatedTrips.get(i));
							
				}
			}
		}
		return suitableTrips;
	}
	public ArrayList<Trip> findAllTrips(String source, String destination, Date date, String seatType)
	{
		ArrayList<Trip> suitableTrips = new ArrayList<Trip>();
		
		for(int i = 0; i < designatedTrips.size(); i++){
			if(designatedTrips.get(i).date.compareTo(date) == 0){
				
				if(designatedTrips.get(i).seatType == seatType){
					
					if(designatedTrips.get(i).destination == destination && designatedTrips.get(i).source == source){
						suitableTrips.add(designatedTrips.get(i));
							
					}				
				}
			
			}
		}
		return suitableTrips;
	
	}
	public ArrayList<Trip> findAllTrips(String source, String destination, Date date1, Date date2)
	{
		ArrayList<Trip> suitableTrips = new ArrayList<Trip>();
		
		for(int i = 0; i < designatedTrips.size(); i++){
			if(date1.compareTo(designatedTrips.get(i).date) !=1 && date2.compareTo(designatedTrips.get(i).date) != -1){
				
				if(designatedTrips.get(i).destination == destination && designatedTrips.get(i).source == source){
				
					suitableTrips.add(designatedTrips.get(i));	
				}				
			}
		}
		return suitableTrips;
	}
	
	public Trip findCheapestTrip(String source, String destination, Date date, Date date2, String seatType)
	{
		ArrayList<Trip> suitableTrips = findAllTrips(source, destination, date, date2, seatType);
		
		int minValue = Integer.MAX_VALUE, a = 0;
		for (int i = 0; i < suitableTrips.size(); i++){
			if(suitableTrips.get(i).ticketPrice < minValue){
				minValue = suitableTrips.get(i).ticketPrice;
				a = i;
			}
			
		}
		if (suitableTrips.size() > 0) 
			return suitableTrips.get(a);
		else 
			return null;
	}
	
	public Trip findCheapestTrip(String source, String destination, Date date, String seatType)
	{
		ArrayList<Trip> suitableTrips = findAllTrips(source, destination, date, seatType);
		
		int minValue = Integer.MAX_VALUE, a = 0;
		for (int i = 0; i < suitableTrips.size(); i++){
			if(suitableTrips.get(i).ticketPrice < minValue){
				minValue = suitableTrips.get(i).ticketPrice;
				a = i;
			}
			
		}
		if (suitableTrips.size() > 0) 
			return suitableTrips.get(a);
		else 
			return null;
	
	}
	
	public Trip findCheapestTrip(String source, String destination, Date date, Date date2)
	{
		ArrayList<Trip> suitableTrips = findAllTrips(source, destination, date, date2);
		
		int minValue = Integer.MAX_VALUE, a = 0;
		for (int i = 0; i < suitableTrips.size(); i++){
			if(suitableTrips.get(i).ticketPrice < minValue){
				minValue = suitableTrips.get(i).ticketPrice;
				a = i;
			}
			
		}
		if (suitableTrips.size() > 0) 
			return suitableTrips.get(a);
		else 
			return null;
	}
	public Trip findCheapestTrip(String source, String destination, Date date)
	{
		ArrayList<Trip> suitableTrips = findAllTrips(source, destination, date);
		
		int minValue = Integer.MAX_VALUE, a = 0;
		for (int i = 0; i < suitableTrips.size(); i++){
			if(suitableTrips.get(i).ticketPrice < minValue){
				minValue = suitableTrips.get(i).ticketPrice;
				a = i;
			}
			
		}
		if (suitableTrips.size() > 0) 
			return suitableTrips.get(a);
		else 
			return null;
		
	}
	
	public Ticket sellTicket(Trip trip, String customerName, String customerSurname, String gender)
	{
		if(trip == null || trip.numberOfSeats == 0)
			return null;
		else{
			Ticket ticket = new Ticket(customerName, customerSurname, gender, trip);
			soldTickets.add(ticket);
			trip.numberOfTicketsSold++;
			return ticket;
		}
	}
	public boolean cancelTicket(String customerSurname, String pnrNo){
		for(int i = 0; i < soldTickets.size(); i++){
			Ticket ticket = soldTickets.get(i);
			if(ticket.customerSurname == customerSurname && ticket.pnrNo == pnrNo){
				designatedTrips.add(soldTickets.get(i).trip);
				soldTickets.remove(i);
				ticket.trip.numberOfTicketsSold--;
				ticket.trip.numberOfSeats++;
				return true;
			}
		}
		return false;
	
	
	}
	
}
