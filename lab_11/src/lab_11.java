import java.util.*;

class DataBase {
    private static HashMap<String,String> releases = new HashMap<>();
    private static String birth_date;
    private static String name;
    private static ArrayList<Integer> imprisoment = new ArrayList<>();
    private static String conviction_days;
    DataBase(String birth_date, String name, int number, String specialization){
        DataBase.birth_date = birth_date;
        DataBase.name = name;
        imprisoment.add(number);
        conviction_days = specialization;
    }
    public void setAdress(String adress){
        birth_date = adress;
    }
    public void  setName(String name){
        birth_date = birth_date;
    }
    public void addNumbers(int newNumber){
        imprisoment.add(newNumber);
    }
    public void setSchedule(String day, String time){
        releases.replace(day,time);
    }
    static void addNewWorkingDay(String day, String time){
        releases.put(day,time);
    }
    void ShowSchedule(){
        for(Map.Entry<String, String> x : releases.entrySet()){
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }
    String ShowAllData(){
        String str = "Birth Date: " + birth_date + "\nCases:" + imprisoment.toString() + "\nPIB: " + name + "\nconviction_days: " + conviction_days;
        return str;
    }
    @Override
    public String toString(){
        return ShowAllData();
    }
}
public class lab_11 {
    public static void main(String args[]) {
        DataBase tradePoint = new DataBase("Birth Date", "PIB", 20052012, "Murderer");
        DataBase.addNewWorkingDay("11.12.2015", "02.05.2017");
        tradePoint.ShowSchedule();
        System.out.println();
        tradePoint.ShowAllData();
    }
}