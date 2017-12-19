/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainbooking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author bp
 */
public class IntercityTrain {
    private String file;
    private String cls;
    private Map<Integer,String> seaMap = new HashMap();
    
    private IntercityTrain(){}
    
    private static final IntercityTrain INTERCITY__TRAIN = new IntercityTrain();
    public static IntercityTrain getIntercityTrain(){
        return INTERCITY__TRAIN;
    }
    
    public void showSeats(String file,String cls){
        this.file = file;
        this.cls = cls;
        seaMap.clear();
        System.out.println("");
        System.out.println("Available Seats:");
        System.out.println("");
        try {
            File f = new File(file);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            
            while ((readLine = b.readLine()) != null) {
              String[] newtxt = readLine.split(":");
              //get all records to hashmap
              seaMap.put(Integer.parseInt(newtxt[0].trim()), newtxt[1].trim());
              String[] clss = newtxt[1].trim().split(",");
                if (clss[0].trim().equals("not")&& clss[1].trim().equals(cls)) {
                    
                    System.out.println("Seat No: " + newtxt[0]+"\tClass :  "+clss[1]);
                }
                
            }
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void booking(int seat,String nic){
        try{
            String record;
            if (seaMap.get(seat).trim().equals("not,"+cls)) {
                seaMap.put(seat, nic+","+cls);
                    Iterator it = seaMap.entrySet().iterator();
                    File f = new File(this.file);
                    FileWriter fw = new FileWriter(f);
                    Writer w = new BufferedWriter(fw);
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry)it.next();
                        record  = pair.getKey()+":"+pair.getValue();
                        w.write(record);
                        w.write(System.getProperty("line.separator"));
                        System.out.println(record); 
                    }
                    w.close();
                    System.out.println("\n**********************");
                    System.out.println("booking succesful!\n"
                            + "NIC : "+nic+"\t SeatNo is : "+seat+
                            "Class : "+cls);
                    System.out.println("\n**********************");
            }else{
                System.out.println("cannot book that seat");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
