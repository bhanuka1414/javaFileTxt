/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainbooking;

import java.util.Scanner;

/**
 *
 * @author bp
 */
public class TrainFacade {
    SlowTrain st;
    IntercityTrain it;
    private String route;
    private String cls;
    private String destination;
    private String nic;
    private int seat;
    Scanner scanner = new Scanner(System.in);
    private TrainFacade(){
        st = SlowTrain.getSlowTrain();
        it = IntercityTrain.getIntercityTrain();
    }
    private static final TrainFacade TRAIN_FACADE = new TrainFacade();
    
    public static TrainFacade getTrainFacade(){
        return TRAIN_FACADE;
    }
    public void selectRoute(){
        System.out.println("Enter (A) for route A5 : ");
        System.out.println("Enter (B) for route B4 : ");
        this.route = scanner.next().trim().toLowerCase();
        int train = 0;
        
        switch(route){
            case "a":
                System.out.println("Enter 1 for slow train-1");
                System.out.println("Enter 2 for slow train-2");
                System.out.println("Enter 3 for intercity train-1");
                train = scanner.nextInt();
                break;
            case "b":
                System.out.println("Enter 4 for slow train-1");
                System.out.println("Enter 5 for slow train-2");
                System.out.println("Enter 6 for slow train-3");
                System.out.println("Enter 7 for slow train-4");
                System.out.println("Enter 8 for intercity train-1");
                System.out.println("Enter 9 for intercity train-1");
                train = scanner.nextInt();
                break; 
            default:
                System.out.println("\n"+"Invalid input!");
                break;
        }
        showSeats(train);
        
    }
    public void showSeats(int opt){
        
        switch(opt){
            case 1:
                st.showSeats("tsa1.txt");
                slowData();
                st.booking(seat, destination, nic);
                break;
            case 2:
                st.showSeats("tsa2.txt");
                slowData();
                st.booking(seat, destination, nic);
                break;
            case 3:
                getCls();
                it.showSeats("tia1.txt", cls);
                intercityData();
                it.booking(seat, nic);
                break;
            case 4:
                st.showSeats("tsb1.txt");
                slowData();
                st.booking(seat, destination, nic);
                break;    
            case 5:
                st.showSeats("tsb2.txt");
                slowData();
                st.booking(seat, destination, nic);
                break;
            case 6:
                st.showSeats("tsb3.txt");
                slowData();
                st.booking(seat, destination, nic);
                break;
            case 7:
                st.showSeats("tsb4.txt");
                slowData();
                st.booking(seat, destination, nic);
                break;
            case 8:
                getCls();
                it.showSeats("tib1.txt", cls);
                intercityData();
                it.booking(seat, nic);
                break; 
            case 9:
                getCls();
                it.showSeats("tib2.txt", cls);
                intercityData();
                it.booking(seat, nic);
                break;  
            default:
                System.out.println("\n"+"Invalid input!");
                break;
        }
    }
    
    private void getCls(){
        System.out.println("Enter (1) for 1st class : ");
        System.out.println("Enter (2) for 2nd class : ");
        System.out.println("Enter (3) for 3rd class : ");
        String c = scanner.next();
        
        switch(Integer.parseInt(c)){
            case 1:
                cls = "1st";
                break;
            case 2:
                cls = "2nd";
                break;
            case 3:
                getCls();
                cls = "3rd";
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
        
        
    }
    public void slowData(){
        System.out.println("Enter your NIC : ");
        nic = scanner.next();
        System.out.println("Enter destination : ");
        destination = scanner.next();
        System.out.println("Enter seat number : ");
        seat = Integer.parseInt(scanner.next());
    }
    
    public void intercityData(){
        System.out.println("Enter your NIC : ");
        nic = scanner.next();
        System.out.println("Enter seat number : ");
        seat = Integer.parseInt(scanner.next());
    }
    
}
