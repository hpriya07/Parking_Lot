public class Main {
    public static void main(String[] args) {
        Create_Slots create_slots=new Create_Slots(2);
        Show_Slots showSlots = new Show_Slots(create_slots);
        System.out.println("Available slots initially:");
        showSlots.displaySlots();

        Issue_Tickets ticket1 = new Issue_Tickets("TN-01-AB-1234", 2, create_slots);
        ticket1.print_ticket();

        System.out.println("\nAvailable slots after booking:");
        showSlots.displaySlots();

        Payment payment1 = new Credit(123,123);
        payment1.processPayment(ticket1);
        payment1.printReceipt();
    }
}
