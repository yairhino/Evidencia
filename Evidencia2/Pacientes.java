package Evidencia2;
import java.io.*;
import java.util.HashMap;

public class Pacientes {
    HashMap<String, String> Paciente = new HashMap<String, String>();

    public void save(HashMap<String,String> map){
        try {
            File fileOne=new File("pacientes");
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
            File toRead=new File("pacientes");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);

            Paciente =(HashMap<String,String>)ois.readObject();

            ois.close();
            fis.close();
        } catch(Exception e) {}
    }

    public void list(){
        for (String i : Paciente.keySet()) {
            System.out.println("Id: " + i + " Nombre: " + Paciente.get(i));
        }
    }

    public void create(String number, String name){
        Paciente.put(number,name);
    }

    public void delete(String number){
        Paciente.remove(number);
    }
}