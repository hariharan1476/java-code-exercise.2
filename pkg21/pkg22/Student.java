package pkg21.pkg22;


public class Student {
    private String studentName;
    private String rollNumber;
    private String sraID; 

    public Student(String studentName, String rollNumber, String sraID) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.sraID = sraID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getSraID() {
        return sraID;
    }
}