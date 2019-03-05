package AdminsqlMod;

public class SQLNotice {
	private String N_no;
	private String subject;//公告类型
	private String time;
	private String content;
	private String A_sum;
	private String H_sum;
	private String A_id;
		
	public SQLNotice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SQLNotice(String N_no,String subject, String time, String content, String a_id) {
		super();
		this.N_no=N_no;
		this.subject = subject;
		this.time = time;
		this.content = content;
		A_id = a_id;
	}

	public String getN_no() {
		return N_no;
	}

	public void setN_no(String n_no) {
		N_no = n_no;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getA_sum() {
		return A_sum;
	}
	public void setA_sum(String a_sum) {
		A_sum = a_sum;
	}
	public String getH_sum() {
		return H_sum;
	}
	public void setH_sum(String h_sum) {
		H_sum = h_sum;
	}
	public String getA_id() {
		return A_id;
	}
	public void setA_id(String a_id) {
		A_id = a_id;
	}
	

}
