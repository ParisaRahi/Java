import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList list = new LinkedList<>();
        list.addLast(10);
        list.addFirst(20);
        list.add(30);
        list.addFirst(5);
    

        list.removeFirst();

        System.out.println(list.contains(10));

        System.out.println(list.indexOf(10));
        System.out.println(list.size());
        var array = list.toArray();
        System.out.println(Arrays.toString(array));

        var list2 = new LinkedList<>();
        list2.addLast(10);
        list2.addLast(20);
        list2.addLast(30);
        list2.removeFirst();
        list2.removeLast();

        System.out.println(list2.contains(10));
        System.out.println(list2);

        
    }
    
}
