public class MyCenerateId {
    private static long counter=1;

    public static long generateId(){
        return counter++;
    }
}
