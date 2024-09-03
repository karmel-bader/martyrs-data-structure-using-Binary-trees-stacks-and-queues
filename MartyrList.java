package application;

public class MartyrList implements Comparable<MartyrList>{
	
	private String name;
	private int age;
	private String gender;
	public MartyrList(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public MartyrList(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public int compareTo(MartyrList o) {
		if(this.age == o.age) return this.gender.toLowerCase().compareTo(o.gender.toLowerCase());
		else return this.age - o.age;
	}
	@Override
	public String toString() {
		return  name + " ";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MartyrList) {
			return name.equals(((MartyrList)obj).getName());
		}
		return false;
	}
	
	
	
	

}
