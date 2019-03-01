package info;

public class UsagiProfile{
	private String threadno;		//スレッドの通し番号
	private String title;		//スレッドタイトル
	private String time;		//スレッドを立てた時間
	private String threadreport;	//スレッドが報告された数
	private String resno;			//全てのレスの通し番号
	private String serialno;		//スレッドごとのレスの通し番号
	private String name;		//レスをしたユーザの名前
	private String contents;	//レスの内容
	private String restime;		//レスをした日付
	private String rating;			//レスに対しての評価
	private String resreport;		//レスが報告された数
	
	
	public String getThreadno(){
		return threadno;
	}
	public String getTitle(){
		return title;
	}
	public String getTime(){
		return time;
	}
	public String getThreadreport(){
		return threadreport;
	}
	public String getResno(){
		return resno;
	}
	public String getSerialno(){
		return serialno;
	}
	public String getName(){
		return name;
	}
	public String getContents(){
		return contents;
	}
	public String getRestime(){
		return restime;
	}
	public String getRating(){
		return rating;
	}
	public String getResreport(){
		return resreport;
	}
	
	
	
	public void setThreadno(String _threadno){
		threadno=_threadno;
	}
	public void setTitle(String _title){
		title=_title;
	}
	public void setTime(String _time){
		time=_time;
	}
	public void setThreadreport(String _threadreport){
		threadreport=_threadreport;
	}
	public void setResno(String _resno){
		resno=_resno;
	}
	public void setSerialno(String _serialno){
		serialno=_serialno;
	}
	public void setName(String _name){
		name = _name;
	}
	public void setContents(String _contents){
		contents=_contents;
	}
	public void setRestime(String _restime){
		restime=_restime;
	}
	public void setRating(String _rating){
		rating=_rating;
	}
	public void setResreport(String _resreport){
		resreport=_resreport;
	}
	
}