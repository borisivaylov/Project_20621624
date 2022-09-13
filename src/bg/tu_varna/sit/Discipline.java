package bg.tu_varna.sit;

import java.io.Serializable;

public class Discipline implements Serializable {

    public static final int level=1;
    protected String discName;
    protected Specialty specialty;

    public Discipline(String discName, Specialty specialty) {
        this.discName = discName;
        this.specialty = specialty;
    }

    public String getDiscName() {
        return discName;
    }

    public void setDiscName(String discName) {
        this.discName = discName;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return  "       <Discipline>\n" +
                "               <discName> " + discName +" </discName>\n" +
                "               "+specialty+"\n"+
                "       </Discipline>";
    }
}
