package model;

public class CollaboratorModel {
	private String id;
	private String cpf;
	private String contributorName;
	private String breakfastFood;
	
	public CollaboratorModel() {
		super();
	}
	
	public CollaboratorModel(String id, String cpf, String contributorName, String breakfastFood) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.contributorName = contributorName;
		this.breakfastFood = breakfastFood;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getcontributorName() {
		return contributorName;
	}
	public void setcontributorName(String contributorName) {
		this.contributorName = contributorName;
	}
	public String getbreakfastFood() {
		return breakfastFood;
	}
	public void setbreakfastFood(String breakfastFood) {
		this.breakfastFood = breakfastFood;
	}
}
