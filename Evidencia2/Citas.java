package Evidencia2;
import java.io.*;
import java.util.HashMap;

public class Citas {
    HashMap<String, String> Cita = new HashMap<String, String>();
    HashMap<String, String> Personas = new HashMap<String, String>();

    public void save(HashMap<String,String> map, HashMap<String,String> map2){
        try {
            File fileOne=new File("citas");
            FileOutputStream fos=new FileOutputStream(fileOne);
            ObjectOutputStream oos=new ObjectOutputStream(fos);

            oos.writeObject(map);
            oos.flush();
            oos.close();
            fos.close();

            File fileTwo=new File("citas2");
            FileOutputStream foos=new FileOutputStream(fileTwo);
            ObjectOutputStream ooss=new ObjectOutputStream(foos);

            ooss.writeObject(map2);
            ooss.flush();
            ooss.close();
            foos.close();
        } catch(Exception e) {}
    }

    public void load(){
        try {
            File toRead=new File("citas");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);

            Cita =(HashMap<String,String>)ois.readObject();

            ois.close();
            fis.close();

            File tooRead=new File("citas2");
            FileInputStream fiis=new FileInputStream(tooRead);
            ObjectInputStream oiis=new ObjectInputStream(fiis);

            Personas =(HashMap<String,String>)oiis.readObject();

            oiis.close();
            fiis.close();
        } catch(Exception e) {}
    }

    public void list(){
        for (String i : Cita.keySet()) {
            System.out.println("Fecha y hora: " + i + " Motivo: " + Cita.get(i));
        }
        for (String i : Personas.keySet()){
            System.out.println("Doctor: " + i + " Paciente: " + Personas.get(i));
        }
    }

    public void create(String fyh, String motivo, String d, String p){
        Cita.put(fyh,motivo);
        Personas.put(d,p);
    }

    public void delete(String fyh, String d){
        Cita.remove(fyh);
        Personas.remove(d);
    }
}