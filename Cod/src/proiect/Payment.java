
package proiect;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Payment {
    private int paymentId;
    private float paymentAmount;
    private LocalDateTime paymentDate;
    private String paymentMethod;

    public Payment(int paymentId, float paymentAmount, LocalDateTime paymentDate, String paymentMethod) {
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }
    
    public void processPayment(String paymentDetails, int userInput) {
        System.out.println("Are you sure you want to proceed with the payment?\n" + "1 - Yes\n" + "0 - No\n");
        switch(userInput) {
            case 1: 
                System.out.println("Payment processed!\n");
                break;
            case 0: 
                System.out.println("Payment not processed!\n");
                break;
        }
    }

    
   public void processPayment(String paymentDetails) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure you want to proceed with the payment?\n" + "1 - Yes\n" + "0 - No\n");
        int action = scanner.nextInt();
        switch(action) {
            case 1: 
                System.out.println("Payment processed!\n");
                break;
            case 0: 
                System.out.println("Payment not completed!\n");
                break;
        }
        scanner.nextLine();
    }
}
