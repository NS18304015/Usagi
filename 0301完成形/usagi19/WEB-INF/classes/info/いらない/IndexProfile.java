package info;

public class IndexProfile{
	private String title;
	private String name;
	private String contents;
	private String no;
	
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
		return no;
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
	public void setNo(String _no){
		no=_no;
	}

}