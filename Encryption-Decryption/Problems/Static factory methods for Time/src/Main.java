import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    public static Time noon() {
        // write your code here
        Time noon = new Time();
        noon.hour = 12;
        noon.minute = 0;
        noon.second = 0;

        return noon;
    }

    public static Time midnight() {
        // write your code here
        Time midnight = new Time();
        midnight.hour = 0;
        midnight.minute = 0;
        midnight.second = 0;

        return midnight;
    }

    public static Time ofSeconds(long seconds) {
        // write your code here
        Time normalTime = new Time();

        normalTime.hour = (int) seconds / 3600;
        int azora = normalTime.hour;
        while (normalTime.hour > 24){
            normalTime.hour -= 24;

        }

        normalTime.minute = (int) (seconds - azora * 3600) / 60;
        normalTime.second = (int) (seconds - azora * 3600 - normalTime.minute *60);
        return normalTime;
    }

    public static Time of(int hour, int minute, int second) {
        // write your code here
        if ((0 <= hour && hour <= 23) && (0 <= minute && minute <= 59) && (0 <= second && second <= 59)){
            Time sec = new Time();
            sec.second = second;
            sec.minute = minute;
            sec.hour = hour;
            return sec;
        }
        else return null;

    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}