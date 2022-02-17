public class Trip{
	String companyName, source, destination, departureTime, arrivalTime, seatType;
	int ticketPrice, numberOfSeats, numberOfTicketsSold;
	Date date;

	public Trip(String companyName,String source,String destination,int ticketPrice, Date date,String departureTime,String arrivalTime,String seatType,int numberOfSeats){
		
		this.companyName = companyName;
		this.source = source;
		this.destination = destination;
		this.ticketPrice = ticketPrice;
		this.date = date;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.seatType = seatType;
		this.numberOfSeats = numberOfSeats;
		numberOfTicketsSold = 0;
	
	}
	
	public String toString(){
		return String.format("%s tarihinde %s saatinde %s sehrinden %s sehrine %s firmasinin %s araci bulunmaktadir. Fiyat: %d TL, bos koltuk sayisi:%d", date.toString(), departureTime, source, destination, companyName, seatType,ticketPrice, (numberOfSeats - numberOfTicketsSold));
	}

	public Date getDate()
	{
		return this.date;
	}
	
	public String getDepartureTime()
	{
		return this.departureTime;
	}
	
	public String getSource()
	{
		return this.source;
	}
	
	public String getDestination()
	{
		return this.destination;
	}
	
	public String getCompanyName()
	{
		return this.companyName;
	}

	public String getSeatType()
	{
		return this.seatType;
	}

}
