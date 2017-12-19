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
public class SlowTrain {
    private String file;
    private Map<Integer,String> seaMap = new HashMap();
    
    private SlowTrain(){}
    
    private static final SlowTrain SLOW_TRAIN = new SlowTrain();
    public static SlowTrain getSlowTrain(){
        return SLOW_TRAIN;
    }
    
    public void showSeats(String file){
        this.file = file;
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
                if (newtxt[1].trim().equals("not")) {
                    
                    System.out.println("Seat No: " + newtxt[0]);
                }
                
            }
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void booking(int seat, String des,String nic){
        try{
            String record;
            if (seaMap.get(seat).equals("not")) {
                seaMap.put(seat, des+","+nic);
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
                            + "NIC : "+nic+"\t SeatNo is : "+seat);
                    System.out.println("\n**********************");
            }else{
                System.out.println("cannot book that seat");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
