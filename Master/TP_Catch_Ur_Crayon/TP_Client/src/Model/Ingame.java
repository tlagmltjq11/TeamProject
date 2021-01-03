package Model;
public class Ingame {
	private String title;	
	private String pw;		
	private String info;	
	private String round;
	private String theme;
	
	public Ingame(String i) {
		title = "";
		pw = "";
		info = i;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getRound() {
		return round;
	}

	public void setRound(String round) {
		this.round = round;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
