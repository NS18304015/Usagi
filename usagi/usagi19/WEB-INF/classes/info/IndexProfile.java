package info;

public class IndexProfile{
	private int threadno;		//�X���b�h�̒ʂ��ԍ�
	private String title;		//�X���b�h�^�C�g��
	private String time;		//�X���b�h�𗧂Ă�����
	private int threadreport;	//�X���b�h���񍐂��ꂽ��
	private int resno;			//�S�Ẵ��X�̒ʂ��ԍ�
	private int serialno;		//�X���b�h���Ƃ̃��X�̒ʂ��ԍ�
	private String name;		//���X���������[�U�̖��O
	private String contents;	//���X�̓��e
	private String restime;		//���X���������t
	private int rating;			//���X�ɑ΂��Ă̕]��
	private int resreport;		//���X���񍐂��ꂽ��
	
	
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