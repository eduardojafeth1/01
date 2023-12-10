package com.example.algoritmos;

import java.io.*;

public class Serializar {


    public void serializar(Llist l,String n){
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;

        try {
            fos=new FileOutputStream(n+".dat");
            oos=new ObjectOutputStream(fos);
            oos.writeObject(l);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if(fos!=null){
                fos.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Llist desSerializar()  {
        Llist<Movimiento> l = null;
        FileInputStream fis = null;
        ObjectInputStream ois;
        try {

            fis = new FileInputStream("list.dat");
            ois = new ObjectInputStream(fis);
            while (0 < fis.available()) {
                l = (Llist<Movimiento>) ois.readObject();
                l.getValue().getValue();
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println("nose");
        } catch (ClassNotFoundException e) {
        }finally {
            try{ if(fis!=null){
                fis.close();
            }}
            catch (IOException e) {
                throw new RuntimeException(e);}
        }


        return l;
    }

}
