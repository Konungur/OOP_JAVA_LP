
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
public class add implements Serializable {
    private static  LinkedList<TradePoint> list =  new LinkedList<>();
    private static int find(TradePoint value){
        return list.indexOf(value);
    }
    private static void remove(TradePoint value){
        list.remove(value);
    }
    private static void add(TradePoint value){
        list.add(value);
    }
    private static void sort(LinkedList<TradePoint> list){
        Collections.sort(list, (object1, object2) -> object1.name.getName().compareTo(object2.name.getName()));
    }
    public static void main(String[] args) throws IOException {
        TradePoint tradePoint = new TradePoint( "Bob", "Adress",123, "Programmer", "Monday", "20:00");
        TradePoint secondPoint = new TradePoint( "Andrew", "MainStreet",880553535, "Trader", "Sunday", "18:00");
        TradePoint thirdPoint = new TradePoint( "Joe", "SalmanelaStreet",742625725, "Cook", "Tuesday", "17:00");
        TradePoint forthPoint = new TradePoint( "Anton", "RynokStreet",450236234, "Manger", "Wednesday", "9:00");
        add(tradePoint);
        add(secondPoint);
        add(thirdPoint);
        add(forthPoint);
        for (Object i: list)
            System.out.println(i);
        sort(list);
        System.out.println();
        for (Object i: list)
            System.out.println(i);
        remove(thirdPoint);
        for (Object i: list)
            System.out.println(i);
        System.out.println("Find index of tradepoint " + find(tradePoint));
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.flush();
        oos.close();
    }
}
