import java.io.Serializable;
import java.util.*;
class NameSecFather implements Serializable{
    private String name_sec_father;
    NameSecFather(String name){
        this.name_sec_father = name;
    }

    String getName_sec_father(){
        return name_sec_father;
    }
}
class BirthDate implements Serializable{
    private String birth_date;
    BirthDate(String birth_date){
        this.birth_date = birth_date;
    }

    String birth_date(){
        return birth_date;
    }
}
class ConvictionDate implements Serializable{
    private ArrayList<String> conviction_dates;
    ConvictionDate(String number){
        this.conviction_dates = new ArrayList<>();
        conviction_dates.add(number);
    }

    @Override
    public String toString(){
        return conviction_dates.toString();
    }
}
class Imprisoment implements Serializable{
    private String d_imprisoment;
    Imprisoment(String d_imprisoment){
        this.d_imprisoment = d_imprisoment;
    }

    String getD_imprisoment(){
        return d_imprisoment;
    }
}
class Releases implements Serializable{
    private HashMap<String,String> releases;
    Releases(String day, String time){
        this.releases = new HashMap<>();
        releases.put(day,time);
    }

    @Override
    public String toString(){
        return releases.toString();
    }
}

class DataBase implements Serializable {
    private NameSecFather name;
    private BirthDate birth_date;
    private Imprisoment imprisoment;
    private ConvictionDate conviction_dates;
    private Releases releases;
    DataBase(String name1, String birth1, String conv1, String case1, String release1, String releases1){
        this.name = new NameSecFather(name1);
        this.birth_date = new BirthDate(birth1);
        this.imprisoment = new Imprisoment(case1);
        this.conviction_dates = new ConvictionDate(conv1);
        this.releases = new Releases(release1, releases1);
    }

    private String ShowAllData(){
        return name.getName_sec_father() + " " + birth_date.birth_date() + " " + imprisoment.getD_imprisoment() + " " + conviction_dates + " " + releases;
    }
    @Override
    public String toString(){
        return ShowAllData();
    }
}
public class lab_10 {
    public static void main(String args[]) {
        DataBase database1 = new DataBase( "John Wick", "02.09.1964","20052012", "Murderer", "11.12.2015", "02.05.2017");
        DataBase database2 = new DataBase( "Leonardo", "07.12.1987","18.12.2014", "Thief", "18.12.2014", "20.12.2018");
        System.out.println(database1);
        System.out.println(database2);
    }
}