import java.util.Scanner;

public class UpdatedCalender {
    static int [] days = {31,28,31,30,31,30,31,31,30,31,30,31};
    static String month [] = {"January", "Febraury", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static String weekDays [] = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
    static Scanner sc = new Scanner(System.in);
    static int space = 21;
    public static void main(String[] args) {
        // int y = 0;
        System.out.println("Enter the year");
        int year = sc.nextInt();
        if (checkLeap(year))    days[1] = 29;
        int x = generate(year);
        // months :
        for (int i=0;i<12;i=i+3){
            for (int j=i;j<i+3;j++){
                String mon = "";
                mon += month[j];
                printSpace(mon);
            }
            System.out.println();
            for (int s = 0;s<3;s++){
                String week = "";
                for (int ss = 0;ss<7;ss++){
                    week += weekDays[ss]+" ";
                }
                printSpace(week);
            }
            System.out.println();
            int xx [] = new int[3];
            xx[0] = x;
            xx[1] = days[i]+xx[0];
            xx[1] %= 7;
            xx[2] = days[i+1]+xx[1];
            xx[2] %= 7;
            int zz [] = {1,1,1};
            boolean stop [] = {true,true,true};
            while (stop[0]||stop[1]||stop[2]) {
                for (int j=0;j<3;j++){
                    String day = "";
                    for(int yy=0;yy<xx[j] && zz[j]==1;yy++){
                        day+="   ";
                    }
                    while(day.length()<space){
                        if (zz[j]>days[i+j]) {
                            stop [j] = false;
                            printSpace(day);
                            break;
                        }
                        if (zz[j]<10)   day += " "+zz[j]+" ";
                        else day += zz[j]+" ";
                        if (zz[j]==days[i+j]){
                            stop [j] = false;
                            if (j==2)   System.out.print(day);
                            else    printSpace(day);
                            zz[j]++;
                            break;
                        }
                        else if (day.length()==space)
                        System.out.print(day+" ");
                        zz[j]++;
                    }
                    
                }
                System.out.println();
            }
            x = days[i+2]+xx[2];
            x %= 7;
            System.out.println();
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

    public static void printSpace (String mon){
        int x = mon.length();
        while (x<=space) {
            mon += " ";
            x++;
        }
        System.out.print(mon);
    }
    
}
