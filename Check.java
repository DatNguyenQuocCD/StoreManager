import java.util.Scanner;
import java.util.regex.Pattern;

public class Check {
    static String phone;
    static String name;
    static String email;
    static Scanner sc = new Scanner(System.in);

    public static void errorTry_Catch() {
        System.out.println("Error...! Please choose again");
    }

    public void error() {
        System.out.println("Does not exist!");
    }

    public void println() {
        System.out.println("\n");
    }

    public static Pattern checkName = Pattern.compile("^[a-zA-z]{1,50}+$");
    public static Pattern checkPhone = Pattern.compile("^0[0-9]{8,12}+$");

    public static boolean checkEmail(String email) {
        String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(pattern);
    }

    static Pattern checkDate = Pattern.compile(
            "^(20[0123][0-9])-(0?(([13578])|10|12))-(0?[1-9]|[12][0-9]|3[0-1])$|^(20[0123][0-9])-(0?(([469])|11))-(0?[1-9]|[12][0-9]|30)$|^((200[048])|(201[26])|(202[048])|(203[26]))-2-(0?[1-9]|[12][0-9])$|^(((200[1-3|5-7])|2009)|(2011|(201[3-5|7-9]))|((202[1-3|5-7])|2029)|(2031|(203[3-5|7-9])))-2-(0?[1-9]|[12][0-8])$");

    public static String isPhone() {
        while (true) {
            phone = sc.nextLine();
            if (checkPhone.matcher(phone).find()) {
                return phone;
            }
            errorTry_Catch();
        }
    }

    public static String isName() {
        while (true) {
            name = sc.nextLine();
            if (checkName.matcher(name).find()) {
                return name;
            }
            errorTry_Catch();
        }
    }

    public static String isEmail() {
        while (true) {
            email = sc.nextLine();
            if (Check.checkEmail(email)) {
                return email;
            }
            errorTry_Catch();
        }
    }

    public static String isDate() {
        while (true) {
            String date = sc.nextLine();
            if (checkDate.matcher(date).find()) {
                return date;
            }
            errorTry_Catch();
        }
    }

    static float in_Float() {
        while (true) {
            try {
                float c = Float.parseFloat(sc.nextLine());
                return c;
            } catch (Exception e) {
                errorTry_Catch();
            }
        }
    }

    public static float checkFloat() {
        float x = in_Float();
        if (x <= 0) {
            System.out.println("must be bigger " + 0);
            errorTry_Catch();
            return Check.checkFloat();
        } else
            return x;
    }

    static int in_Int() {
        while (true) {
            try {
                int c = Integer.parseInt(sc.nextLine());
                return c;
            } catch (Exception e) {
                errorTry_Catch();
            }
        }
    }

    public static int checkInt() {
        int x = in_Int();
        if (x <= 0) {
            System.out.println("Must be bigger " + 0+"!");
            errorTry_Catch();
            return Check.checkInt();
        } else
            return x;
    }
    public static float precent(int amount){
        float percent;
        if(amount<20){
            percent=0;
        }
        else if(amount<50){
            percent=1;
        }
        else if(amount<=100){
            percent=5;
        }
        else{
            percent=10;
        }
        return percent;
    }
    public static int choose(int a){
        while (true){
            System.out.print("Please choose function: ");
            int x=checkInt();
            if(x>=a){
                System.out.println("Must be smaller "+a+"!");
                errorTry_Catch();
                return Check.choose(a);
            }
            return x;
        }
    }
}
