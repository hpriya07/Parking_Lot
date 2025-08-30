public class Show_Slots {
    private Create_Slots obj_show;

    Show_Slots(Create_Slots obj) {
        obj_show = obj;
    }

    public void displaySlots() {
        System.out.println(obj_show.getter_lots());
    }
}
