package ac.at.fhcampuswien.characters;

import java.io.*;

public abstract class Orc implements ICreature, Serializable {
    protected String location;  // all subclasses can access this variable

    public Orc(String location){
        this.location = location;
    }

    public void attackRoar(){
        System.out.println("Orc attack! Grrrr!");
    }

    public void attack(){
        System.out.println("Do attack");
        this.attackRoar();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void walk(int distance) {
        System.out.println("Orc walk " + distance);
    }

    protected void eat(){
        System.out.println("mhhh lecker Hobbits.");
    }


    public static void serializeOrc(Orc orc, String filename){
        FileOutputStream fos;
        ObjectOutputStream out;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(orc);
            out.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Orc deserializeOrc(String filename){
        Orc orc = null;
        FileInputStream fis;
        ObjectInputStream in;

        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            orc = (Orc)in.readObject();
            in.close();
        } catch(IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return orc;
    }

}
