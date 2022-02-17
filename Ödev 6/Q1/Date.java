public class Date{
	int day, month, year;
	
	public Date(String date){
		day = Integer.parseInt(date.substring(0, date.indexOf("/")));
		date = date.substring(date.indexOf("/") + 1, date.length());
		month = Integer.parseInt(date.substring(0, date.indexOf("/")));
		year = Integer.parseInt(date.substring(date.indexOf("/") + 1, date.length()));
	}
	
	public Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String toString(){ 
		return String.format("%d/%d/%d", day, month, year);
	}
	public int getDay()
	{
		return this.day;
	}
	public int getMonth()
	{
		return this.month;
	}
	public int getYear()
	{
		return this.year;	
	}
	public int compareTo(Date date){
		
		if(this.year < date.year){
			return -1;
		}
		else if(this.year > date.year){
			return 1;
		}
		else{
			if(this.month < date.month){
				return -1;
			}
			else if(this.month > date.month){
				return 1;
			}
			else{
				if(this.day < date.day){
					return -1;
				}
				else if(this.day > date.day){
					return 1;
				}
				else{
					return 0;
				}		
			}
		}
	
	}

}
