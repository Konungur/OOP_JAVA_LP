import java.util.Scanner;

public class lab_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while(!str.equals("break")){
            System.out.println("What are we doing?");
            System.out.println("Chose between number, sentence, date");
            str = scanner.next();
            switch (str) {
                case "number":
                    System.out.println("Input your number:");
                    str = scanner.next();
                    if (str.matches("[0-9]*")) {
                        System.out.println("Awesome");
                    } else {
                        System.out.println("Wrong input, input must consist from numbers only");
                    }
                    break;
                case "sentence":
                    System.out.println("Input your sentence:");
                    str = scanner.next();
                    if (str.matches("[a-zA-Z]*")) {
                        System.out.println("Awesome");
                    } else {
                        System.out.println("Wrong input, input must consist from letters only");
                    }
                    break;
                case "date":
                    System.out.println("Input your date:");
                    str = scanner.next();
                    if (str.matches("^(0[1-9]|[12][0-9]|3[01])[.](0[1-9]|1[012])[.]\\d\\d\\d\\d$")) {
                        System.out.println("Awesome");
                    } else {
                        System.out.println("Wrong input, input must be in type dd.mm.yy");
                    }
                    break;
            }
        }

    }
}
