package info;

public class UsagiProfile{
	private String threadno;		//�X���b�h�̒ʂ��ԍ�
	private String title;		//�X���b�h�^�C�g��
	private String time;		//�X���b�h�𗧂Ă�����
	private String threadreport;	//�X���b�h���񍐂��ꂽ��
	private String resno;			//�S�Ẵ��X�̒ʂ��ԍ�
	private String serialno;		//�X���b�h���Ƃ̃��X�̒ʂ��ԍ�
	private String name;		//���X���������[�U�̖��O
	private String contents;	//���X�̓��e
	private String restime;		//���X���������t
	private String rating;			//���X�ɑ΂��Ă̕]��
	private String resreport;		//���X���񍐂��ꂽ��
	
	
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