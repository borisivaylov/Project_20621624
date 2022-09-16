package bg.tu_varna.sit;

import java.io.Serializable;

public class Discipline implements Serializable {

    public static final int level=1;
    protected String discName;
    protected Specialty specialty;
    protected  String attributeName=null;
    protected  String attributeValue=null;


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

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    @Override
    public String toString() {

        if (attributeName==null && attributeValue==null)
        {
            return "<Discipline>\n" +
                "               <discName> " + discName +" </discName>\n" +
                "               "+specialty+"\n"+
                "       </Discipline>";
        }
        else
        {
            return  " <Discipline "+attributeName+"="+attributeValue+" >\n" +
                    "               <discName> " + discName +" </discName>\n" +
                    "               "+specialty+"\n"+
                    "      </Discipline>";
        }



    }
}
