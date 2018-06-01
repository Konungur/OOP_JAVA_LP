import java.io.*;
import java.util.*;

public class lab_9 {
    public static void main(String[] args) {
        MyArrayList collection = new MyArrayList();
        collection.add("asd");
        collection.add("bfd");
        System.out.println("Collection created: " + collection);

        collection.clear();
        System.out.println("Collection cleared: " +collection);

        collection.add("bk");
        collection.add("cf");
        collection.add("d");
        collection.add("al");
        System.out.println("New collection created: " + collection);

        System.out.println("Remove 'd' from collection: " + collection.remove("d"));

        ArrayList<String> list = new ArrayList<>();
        list.add("cf");
        list.add("bk");
        System.out.println("Collection contains all list: " + collection.containsAll(list));

        Iterator<String> iterator = collection.iterator();
        System.out.print("Work of iterator: ");
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println(iterator.next());

        try {
            String fileName = collection.serialize(collection);
            MyArrayList newCollection = collection.deserialize(fileName);
            System.out.println("Deserialized collection: " + newCollection);
        } catch (IOException e) {
            System.out.println("IOException detected!");
        } catch ( ClassNotFoundException e) {
            System.out.println("ClassNotFoundException detected!");
        }
    }
}

class MyArrayList implements Serializable {
    private final int SIZE = 2;
    private String[] array = new String[SIZE];
    private int pointer = 0;
    private int position = 0;

    @Override
    public String toString() {
        if (array[0] == null)
            return "[]";
        StringBuffer result = new StringBuffer("[" + array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == null)
                break;
            result = result.append(" ").append(array[i]);
        }
        result.append("]");
        return result.toString();
    }

    void add(String item) {
        if (pointer == array.length - 1)
            resize(array.length * 2);
        array[pointer++] = item;
    }

    private void resize(int newLength) {
        String[] newArray = new String[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    private boolean contains(String item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
                position = i;
                return true;
            }
        } return false;
    }

    boolean containsAll(Collection collection) {
        for (Object aCollection : collection) {
            if (!contains((String) aCollection))
                return false;
        }
        return true;
    }

    private void remove(int index) {
        System.arraycopy(array, index + 1, array, index, pointer - index);
        array[pointer] = null;
        pointer--;
    }

    boolean remove(String item) {
        if (contains(item)) {
            remove(position);
            return true;
        } return false;
    }

    void clear() {
        for (int i = 0; i < array.length - 1; i++)
            array[i] = null;
        pointer = 0;
    }

    Iterator<String> iterator() {
        return new Iterator<>() {
            int position = 0;

            @Override
            public boolean hasNext() {
                return position != array.length - 1;
            }

            @Override
            public String next() {
                String current = array[position];
                if (hasNext()) {
                    position++;
                    if (current == null)
                        return "";
                    return current;
                }
                return "Collection is empty!";
            }

            @Override
            public void remove() {
                System.arraycopy(array, position - 1 + 1, array, position - 1, pointer - position - 1);
                array[pointer] = null;
                pointer--;
                position--;
            }
        };
    }

    String serialize(MyArrayList collection) throws IOException {
        String fileName = "output.txt";
        FileOutputStream fos = new FileOutputStream(new File(fileName));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Serializor ser = new Serializor();
        ser.setObject(collection);

        oos.writeObject(ser);
        oos.flush();
        oos.close();
        System.out.println("Serialization complete!");
        return fileName;
    }

    public MyArrayList deserialize (String name) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(new File(name));
        ObjectInputStream oin = new ObjectInputStream(fis);
        Serializor ser = (Serializor)oin.readObject();
        return ser.getObject();
    }
}

class Serializor implements Serializable {
    private MyArrayList object;
    void setObject(MyArrayList object) {
        this.object = object;
    }
    MyArrayList getObject(){
        return object;
    }

}