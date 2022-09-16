package bg.tu_varna.sit;

import java.io.Serializable;
import java.util.HashMap;

public class ChildWithAttribute implements Serializable
{
    public HashMap<String,Object> values;
    private String childId;
    private String attributeValue=null;
    private String attributeName=null;
    private String childText="";


    public ChildWithAttribute(String childId) {
        this.childId = childId;
        this.values=new HashMap<String,Object>();
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public HashMap<String, Object> getValues() {
        return values;
    }

    public void setValues(HashMap<String, Object> values) {
        this.values = values;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeKey) {
        this.attributeValue = attributeKey;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getChildText() {
        return childText;
    }

    public void setChildText(String childText) {
        this.childText = childText;
    }

    public void addElement(String name, Object value)
    {
        values.put(name, value);
    }
    public void removeChildElement(String name)
    {
        values.remove(name);
    }


    @Override
    public String toString() {

        if((attributeValue==null)&&(attributeName==null)&&values.isEmpty())
        {
            return ("       <" + getChildId() + ">"+getChildText()+"</"+getChildId()+">");
        }
        else if(values.isEmpty())
        {
            return ("     <" + getChildId() +" "+ getAttributeName()+"="+getAttributeValue()+ " >"+getChildText()+"</"+getChildId()+">");
        }
        else{
            System.out.println("       <" + getChildId() +" "+ getAttributeName()+"="+getAttributeValue()+ ">/n" +
                                "           <Text> "+getChildText()+" </Text>");


            for (String name: values.keySet())
            {
                Object value = values.get(name);
                System.out.println("            <" + name + "> " +value + " </" + name + ">");
            }

            return
                    "</"+getChildId()+">";
        }

    }
}
