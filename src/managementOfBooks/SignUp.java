package managementOfBooks;

public class SignUp {
	private String id;
	private String passWord;
	private String name;

	public SignUp(String id, String passWord, String name) {
		this.id = id;
		this.passWord = passWord;
		this.name = name;
	}

	public String getID() {
		return id;
	}

	public String getPW() {
		return passWord;
	}

	public String getName() {
		return name;
	}

	public void setID(String id) {
		this.id = id;
	}

	public void setPW(String passWord) {
		this.passWord = passWord;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ID : " + id + " PW : " + passWord + " Name : " + name;
	}
}
