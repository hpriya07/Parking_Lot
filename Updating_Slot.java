public class Updating_Slot {
    private int update_id;
    private Create_Slots obj_update;

    Updating_Slot(int update_id, Create_Slots obj) {
        this.update_id = update_id;
        this.obj_update = obj;
    }
    public void freeSlot() {
        obj_update.update_setter_free(update_id);
    }

    // Book a new slot (ignores update_id, books first free slot)
    public void bookSlot() {
        int bookedId = obj_update.setter();
        if (bookedId == -1) {
            System.out.println("No free slots available.");
        }
    }
}
class Unit_Testing_Update {
    public static void main(String[] args) {
        Create_Slots parking = new Create_Slots(3);

        // Book using Book_Slots
        Book_Slots user1 = new Book_Slots(parking);
        user1.book(); // should book slot 0

        Book_Slots user2 = new Book_Slots(parking);
        user2.book(); // should book slot 1

        System.out.println("Current slots: " + parking.getter_lots());

        // Free slot 1 using Updating_Slot
        Updating_Slot updater = new Updating_Slot(1, parking);
        updater.freeSlot();
        System.out.println("After freeing slot 1: " + parking.getter_lots());

        // Try booking a new slot with Updating_Slot
        Updating_Slot updater2 = new Updating_Slot(0, parking);
        updater2.bookSlot();
        System.out.println("After booking with updater: " + parking.getter_lots());
    }
}
