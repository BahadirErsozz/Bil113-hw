import java.util.ArrayList;
import java.util.Random;
public class Ticket{
	String customerName, customerSurname, gender, pnrNo;
	Trip trip;
	public Ticket(String customerName, String customerSurname, String gender, Trip trip){
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.gender = gender;
		this.trip = trip;
		Random rand = new Random();
		pnrNo = "" + rand.nextInt(99999999);
		
	}
	
	public String toString(){
		return String.format("Ad soyad:%s %s Yolculuk tarihi:%s Saat:%s Kalkis:%s Varis:%s Firma:%s Koltuk Tipi :%s PNR:%s " , customerName, customerSurname, trip.getDate().toString(), trip.getDepartureTime(), trip.getSource(), trip.getDestination(), trip.getCompanyName(), trip.getSeatType(), pnrNo);
	}
	public String getPnrNo(){
		return this.pnrNo;
	}
}
