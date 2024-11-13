package tka.com.entity;

public class Candidate {
	
	private int id;
	private String name;
	private String gender;
	private String party;
	private String state;
	private String assembly;
	
	public Candidate() {
		super();
	}

	public Candidate(int id, String name, String gender, String party, String state, String assembly) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.party = party;
		this.state = state;
		this.assembly = assembly;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAssembly() {
		return assembly;
	}

	public void setAssembly(String assembly) {
		this.assembly = assembly;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", gender=" + gender + ", party=" + party + ", state=" + state
				+ ", assembly=" + assembly + "]";
	}
	
	

}
