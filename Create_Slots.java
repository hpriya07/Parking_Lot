import java.util.HashMap;

public class Create_Slots {
    private int size;
    private HashMap<Integer, Integer> slots = new HashMap<>();

    Create_Slots(int size) {
        this.size = size;
        create_parking_lots();
    }
    private void create_parking_lots() {
        for (int i = 0; i < size; i++) {
            slots.put(i, 0); // 0 = available
        }
    }

    public HashMap<Integer, Integer> getter_lots() {
        return slots;
    }
    public int setter() {
        for(int i=0;i<slots.size();i++){
            if (slots.get(i) == 0) {
                slots.put(i, 1);
                System.out.println("parking lot allocate at id:"+i);
                return i;
            }
        }
        return -1;
    }
    public void update_setter_free(int id){
        if(slots.containsKey(id) && slots.get(id)==1){
            slots.put(id,0);
        }
        else{
            System.out.println("entered slot is already free");
        }
    }
}
class unit_test_Create_Slots{
    public static void main(String[] args) {
        Create_Slots parking = new Create_Slots(3);
        System.out.println("Initial slots: " + parking.getter_lots());

        int slot1 = parking.setter();
        int slot2 = parking.setter();
        int slot3 = parking.setter();
        int slot4 = parking.setter(); 

        System.out.println("Booked slot IDs: " + slot1 + ", " + slot2 + ", " + slot3 + ", " + slot4);
        System.out.println("Slots after booking: " + parking.getter_lots());

        parking.update_setter_free(slot2);
        System.out.println("Slots after freeing slot " + slot2 + ": " + parking.getter_lots());

        parking.update_setter_free(slot2);
    }
}
