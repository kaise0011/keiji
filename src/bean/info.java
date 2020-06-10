package bean;

public class info {
	int id;
	String name;
	String mail;
	String time;
	String text;


	public info(int id,String name,String mail,String time,String text) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.time = time;
		this.text = text;


	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}

	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}

}