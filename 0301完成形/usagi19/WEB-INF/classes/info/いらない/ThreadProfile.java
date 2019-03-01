package info;

public class ThreadProfile{
	private String sno;
	private String name;
	private String contents;
	private String rating;
	private String title;
	
	public String getTitle(){
		return title;
	}
	
	public String getName(){
		return name;
	}
	
	public String getContents(){
		return contents;
	}
	
	public String getNo(){
		return sno;
	}
	public String getRating(){
		return rating;
	}

	
	public void setName(String _name){
		name=_name;
	}
	
	public void setTitle(String _title){
		title=_title;
	}
	public void setContents(String _contents){
		contents=_contents;
	}
	public void setNo(String _sno){
		sno=_sno;
	}
	public void setRating(String _rating){
		rating=_rating;
	}

}