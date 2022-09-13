package bg.tu_varna.sit;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class DeleteAttribute {

    public void deleteAttribute(ArrayList<Student> fileData, String id, String attribName)

    {
        Student foundStudent = null;
        Class clazz=null;
        for (Student fileDatum : fileData) {
            if (fileDatum.getId().equalsIgnoreCase(id)) {
                foundStudent = fileDatum;
                clazz = foundStudent.getClass();
            }
        }
        if (!(foundStudent==null))
        {
            for (Field field : clazz.getDeclaredFields())
            {
                if(field.getName().equalsIgnoreCase(attribName))
                {
                    //foundStudent.setAttribute(attribName,null);
                }
            }
        }
        else
        {
            System.out.println("Student with this id was not found.....");
            //препрадка към командния ред
        }
    }
}
