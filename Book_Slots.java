public class Book_Slots {
    private Create_Slots obj_book;
    private int booked_id;

    Book_Slots(Create_Slots obj) {
        obj_book = obj;  // use the same Create_Slots instance
    }

    public void book() {
        booked_id = obj_book.setter();
        if (booked_id == -1) {
            System.out.println("No slots available to book.");
        } else {
            System.out.println("Booked slot ID: " + booked_id);
        }
    }

    public void free() {
        if (booked_id != -1) {
            obj_book.update_setter_free(booked_id);
            System.out.println("Freed slot ID: " + booked_id);
            booked_id = -1;
        } else {
            System.out.println("No slot to free.");
        }
    }

    public int getBookedId() {
        return booked_id;
    }
}
class Main1 {
    public static void main(String[] args) {
        Create_Slots parking = new Create_Slots(2);

        // First person books
        Book_Slots person1 = new Book_Slots(parking);
        person1.book();

        // Second person books
        Book_Slots person2 = new Book_Slots(parking);
        person2.book();

        // Third person tries (should fail)
        Book_Slots person3 = new Book_Slots(parking);
        person3.book();

        System.out.println("Current slots: " + parking.getter_lots());

        // Free a slot
        person1.free();
        System.out.println("After freeing, slots: " + parking.getter_lots());

        // Another booking
        person3.book();
        System.out.println("Final slots: " + parking.getter_lots());
    }
}
