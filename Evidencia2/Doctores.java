package Evidencia2;
import java.io.*;
import java.util.HashMap;

public class Doctores {
    HashMap<String, String> Doctor = new HashMap<String, String>();

    public void save(HashMap<String,String> map){
        try {
            File fileOne=new File("doctores");
            FileOutputStream fos=new FileOutputStream(fileOne);
            ObjectOutputStream oos=new ObjectOutputStream(fos);

            oos.writeObject(map);
            oos.flush();
            oos.close();
            fos.close();
        } catch(Exception e) {}
    }

    public void load(){
        try {
            File toRead=new File("doctores");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);

            Doctor =(HashMap<String,String>)ois.readObject();

            ois.close();
            fis.close();
        } catch(Exception e) {}
    }

    public void list(){
        for (String i : Doctor.keySet()) {
            System.out.println("Nombre: " + i + " Especialidad: " + Doctor.get(i));
        }
    }

    public void create(String name, String spec){
        Doctor.put(name,spec);
    }

    public void delete(String name){
        Doctor.remove(name);
    }
}