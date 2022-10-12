
public class Student {
	private String first_name;
	private double gpa;
	private String email;
	private String gender;
	
	// overloaded student constructor 
	public Student(String first_name, String gender, String email, double gpa) {
		this.first_name = first_name;
		this.gpa = gpa;
		this.email = email;
		this.gender = gender;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
    public String toString() {
        return "Student{" +
                "first_name='" + first_name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", gpa='" + gpa + '\'' +
                '}';
	}
	
}
