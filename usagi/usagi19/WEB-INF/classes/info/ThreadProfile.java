package info;

public class ThreadProfile{
	private String serialno;
	private String username;
	private String time;
	private String contents;
	private String rating;
	
	public String getSerialno(){
		return serialno;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getTime(){
		return time;
	}
	
	public String getContents(){
		return contents;
	}
	
	public String getRating(){
		return rating;
	}
	
	
	
	public void setSerialno(String _serialno){
		serialno=_serialno;
	}
	
	public void setUsername(String _username){
		username=_username;
	}
	
	public void setTime(String _time){
		time=_time;
	}
	
	public void setContents(String _contents){
		contents=_contents;
	}
	
	public void setRating(String _rating){
		rating=_rating;
	}
}