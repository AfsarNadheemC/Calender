import java.util.Scanner;

public class Calender {
    static int [] days = {31,28,31,30,31,30,31,31,30,31,30,31};
    static String month [] = {"January", "Febraury", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static String weekDays [] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int y = 0;
        System.out.println("Enter the year");
        int year = sc.nextInt();
        if (checkLeap(year))    days[1] = 29;
        int x = generate(year);
        for(int i=0;i<12;i++){
            System.out.println(month[i]);
            for (int j=0;j<7;j++){
                System.out.print(weekDays[j]+" ");
            }
            System.out.println();
            if (i>0)
            x = days[i-1]+y;
            x = x%7;
            for (int j=0;j<x;j++){
                System.out.print("    ");
            }
            y = x;
            for (int j=1;j<=days[i];j++){
                if (j>9) System.out.print(" "+j+" ");
                else System.out.print("  "+j+" ");
                if ((j+x)%7==0) System.out.println();
            }
            System.out.println("\n");
            
        }
    }

    public static boolean checkLeap(int year){
        if( year%400==0 ) return true;
        else if ( year % 100!=0 && year % 4 ==0) return true;
        return false;
    }

    public static int generate(int year){
        int x = 6;
        for (int i=2000;i<year;i++){
            if(checkLeap(i))    x++;
            x++;
        }
        return x%7;
    }
    
}
