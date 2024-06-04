package testare;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import proiect.Payment;

public class TestPayment {

    @Test
    void testPaymentProcessConfirm() {
        System.out.println("Testing payment process confirmation...");
        Payment payment = new Payment(1, 100.0f, LocalDateTime.now(), "Credit Card");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent)); // Redirecting System.out to capture output

        payment.processPayment("Payment details are confidential.", 1); // Simulating user confirming the payment

        String expectedOutput = "Payment processed!\n"; // for case 1
        assertTrue(outContent.toString().contains(expectedOutput), "Output should confirm that payment was processed.");
    }

    @Test
    void testPaymentProcessDeny() {
        System.out.println("Testing payment process denial...");
        Payment payment = new Payment(1, 100.0f, LocalDateTime.now(), "Credit Card");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent)); // Redirecting System.out to capture output

        payment.processPayment("Payment details are confidential.", 0); // Simulating user denying the payment

        String expectedOutput = "Payment not processed!\n"; // for case 0
        assertTrue(outContent.toString().contains(expectedOutput), "Output should confirm that payment was not made.");
    }
}
