package bg.tu_varna.sit;

import java.io.Serializable;

public class Specialty implements Serializable {
    public static final int level=2;
    protected String faculty_name;
    protected String spec_name;

    public Specialty(String faculty_name, String spec_name) {
        this.faculty_name = faculty_name;
        this.spec_name = spec_name;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public String getSpec_name() {
        return spec_name;
    }

    public void setSpec_name(String spec_name) {
        this.spec_name = spec_name;
    }

    @Override
    public String toString() {
        return  "<Specialty>"+
                "\n                         <faculty_name> " + faculty_name + " </faculty_name>\n" +
                "                         <spec_name> " + spec_name + " </spec_name>\n"+
                "               </Specialty>";

    }
}