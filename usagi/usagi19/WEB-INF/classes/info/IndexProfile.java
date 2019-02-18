package info;

public class IndexProfile{
	private int threadno;		//スレッドの通し番号
	private String title;		//スレッドタイトル
	private String time;		//スレッドを立てた時間
	private int threadreport;	//スレッドが報告された数
	private int resno;			//全てのレスの通し番号
	private int serialno;		//スレッドごとのレスの通し番号
	private String name;		//レスをしたユーザの名前
	private String contents;	//レスの内容
	private String restime;		//レスをした日付
	private int rating;			//レスに対しての評価
	private int resreport;		//レスが報告された数
	
	
	public int getThreadno(){
		return threadno;
	}
	public String getTitle(){
		return title;
	}
	public String getTime(){
		return time;
	}
	public int getThreadreport(){
		return threadreport;
	}
	public int getResno(){
		return resno;
	}
	public int getSerialno(){
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
	public int getRating(){
		return rating;
	}
	public int getResreport(){
		return resreport;
	}
	
	
	
	public void setThreadno(int _threadno){
		threadno=_threadno;
	}
	public void setTitle(String _title){
		title=_title;
	}
	public void setTime(String _time){
		time=_time;
	}
	public void setThreadreport(int _threadreport){
		threadreport=_threadreport;
	}
	public void setResno(int _resno){
		resno=_resno;
	}
	public void setSerialno(int _serialno){
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
	public void setRating(int _rating){
		rating=_rating;
	}
	public void setResreport(int _resreport){
		resreport=_resreport;
	}
	
}