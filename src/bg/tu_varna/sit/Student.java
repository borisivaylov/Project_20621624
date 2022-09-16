package bg.tu_varna.sit;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;

public class Student implements Serializable {

    private static final long serialVersionUID = 2L;

    public HashMap<String, Object> values;

    public String id;
    public String name;
    public String age;
    public Discipline discipline = null;

    public Student(String id, String name, String age) {
        this.values = new HashMap<String, Object>();
        this.id = id;
        this.name = name;
        this.age = age;
        // this.discipline=discipline;
        //values.put("id",this.getId());
        //values.put("name", this.getName());
        //values.put("age", this.getAge());
        //  values.put("discipline",this.getDiscipline());
    }

    public Student(String id) {
        this.values = new HashMap<String, Object>();
        this.id = id;
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

    public String getAge() {
        return age;
    }

    public void setAge(String grades) {
        this.age = grades;

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

    public void addValue(String name, Object value) {
        values.put(name, value);
    }

    public void removeValue(String name) {
        //values.remove(name);
        values.put(name, "");
    }

    public String getValue(String name) {
        return values.get(name).toString();
    }

    @Override
    public String toString() {
        System.out.println("<Student id= " + getId() + " >");

        System.out.println("       <Name> " + getName() + " </Name>");
        System.out.println("       <Age> " + getAge() + " </Age>");
        if(discipline==null)
        {
            System.out.println("       <Discipline> </Discipline>");
        }
        else {
            System.out.println("       " + getDiscipline());
        }

        for (String name : values.keySet()) {
            Object value = values.get(name);

            System.out.println(value);
        }
        return ("</Student>");
    }


}


