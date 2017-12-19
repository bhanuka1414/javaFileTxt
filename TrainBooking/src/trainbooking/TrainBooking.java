package trainbooking;

/**
 *
 * @author bp
 */
public class TrainBooking {

    
    public static void main(String[] args){
        
        TrainFacade tf = TrainFacade.getTrainFacade();
        tf.selectRoute();
        
    }
    
}
