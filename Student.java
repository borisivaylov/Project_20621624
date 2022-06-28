package bg.tu_varna.sit;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 2L;

    private String id;
    private String fullName;
    private double grades;

    public Student(String id, String fullName, double grades) {
        this.id = id;
        this.fullName = fullName;
        this.grades = grades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getGrades() {
        return grades;
    }

    public void setGrades(double grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
       return "  <Student>\n" +
                "       <Student id> " + id +" <Student id>\n"+
                "       <Student fullName> " + fullName + " </Student fullName>\n" +
                "       <grades> " + grades +" </grades>\n" +
                "   </Student>\n";
    }
}
