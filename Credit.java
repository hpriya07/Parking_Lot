import java.time.Duration;
import java.time.LocalTime;

public class Credit implements Payment {
    private int credit_number;
    private int password;
    private int amt;
    private LocalTime end_time;
    private Issue_Tickets obj_ticket;
    private String vno;

    Credit(int credit_number, int password) {
        this.credit_number = credit_number;
        this.password = password;
    }

    public void processPayment(Issue_Tickets obj_ticket) {
        this.obj_ticket = obj_ticket;
        this.end_time = LocalTime.now();
        vno=obj_ticket.vehicle_no;
        long minutes = Duration.between(obj_ticket.start_time, end_time).toMinutes();
        long hours = (minutes / 60) + 1;
        amt = (int) (hours * 60);
    }

    public void printReceipt() {
        System.out.println("========== CREDIT PAYMENT RECEIPT ==========");
        System.out.println("Vehicle No : " + vno);
        System.out.println("Slot ID    : " + obj_ticket.slot_id);
        System.out.println("Start Time : " + obj_ticket.start_time);
        System.out.println("End Time   : " + end_time);
        System.out.println("Amount     : Rs " + amt);
        System.out.println("Paid using Credit Card: " + credit_number);
        System.out.println("============================================");
    }
}
