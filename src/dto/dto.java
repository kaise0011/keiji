package dto;

public class dto{
	private String name;
	private String time;
	private String text;


	public dto(String name,String time,String text) {
		super();
		this.name = name;
		this.time = time;
		this.text = text;
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

}