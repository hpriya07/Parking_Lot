import java.time.LocalTime;

public class Issue_Tickets {
    Book_Slots obj1_book_slots;
    Create_Slots obj_created_slots;
    String vehicle_no;
    LocalTime start_time;
    int slot_id;

    Issue_Tickets(String vno, int slot_id, Create_Slots obj_created_slots) {
        this.start_time = LocalTime.now(); // issue ticket at current time
        this.vehicle_no = vno;
        this.slot_id = slot_id;
        this.obj_created_slots = obj_created_slots;

        obj1_book_slots = new Book_Slots(obj_created_slots);
        obj1_book_slots.book();
    }

    public void print_ticket() {
        System.out.println("========== PARKING TICKET ==========");
        System.out.println("Vehicle No : " + vehicle_no);
        System.out.println("Slot ID    : " + slot_id);
        System.out.println("Start Time : " + start_time);
        System.out.println("====================================");
    }
}
