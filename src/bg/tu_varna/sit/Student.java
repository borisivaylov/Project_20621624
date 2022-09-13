package bg.tu_varna.sit;

import java.io.Serializable;
import java.util.HashMap;

public class Student implements Serializable {

    private static final long serialVersionUID = 2L;

    public HashMap<String,Object> values;

    public String id;
    public String name;
    public String grades;
    public Discipline discipline;

    public Student(String id, String name, String grades,Discipline discipline) {
        this.values=new HashMap<String,Object>();
        this.id = id;
        this.name = name;
        this.grades = grades;
        this.discipline=discipline;
        values.put("id",this.getId());
        values.put("name",this.getName());
        values.put("discipline",this.getDiscipline());
        values.put("grades",this.getGrades());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public HashMap<String, Object> getValues() {
        return values;
    }

    public void setValues(HashMap<String, Object> values) {
        this.values = values;
    }

    public void addValue(String name, Object value)
    {
        values.put(name,value);
    }
    public void removeValue(String name)
    {
        values.remove(name);
    }
    public String getValue(String name)
    {
        return  values.get(name).toString();
    }

    @Override
    public String toString() {
        System.out.println("<Student>");

        for(String name: values.keySet())
        {
            Object value = values.get(name);
            if(value instanceof String) {
                System.out.println("       <" + name + "> " + value + " </" + name + ">");
            }
            else if(value instanceof Discipline)
            {
                System.out.println( value );
            }
        }
        System.out.println("</Student>");
        return ("");
    }
}
