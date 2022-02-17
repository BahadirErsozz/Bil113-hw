import java.util.ArrayList;
public class BusCompany{
	String name;
	ArrayList<Trip> designatedTrips;

	public BusCompany(String name, ArrayList<Trip> designatedTrips){
		this.designatedTrips = designatedTrips;
		this.name = name;
	}

}
