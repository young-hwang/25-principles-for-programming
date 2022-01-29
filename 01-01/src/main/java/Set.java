import java.util.Scanner;

public class Set {

    private static int MAXSET = 10;

    private static Scanner scanner = getScanner();

    private static int num = 0;

    public static void main(String[] args) {
        int[] set = new int[MAXSET];
        int select = 0;
        int element = 0;

        while (true) {
            System.out.print("select menu 1. insert 2. delete 3. exit => ");
            select = readInt();
            if (select == 1) {
                System.out.print("intut element => ");
                element = readInt();
                setInsert(set, element);
            } else if (select == 2) {
                System.out.print("intut element => ");
                element = readInt();
                setDelete(set, element);
            } else if (select == 3) {
                break;
            } else {
                System.out.println("select error");
            }
        }
    }

    private static void setDelete(int[] set, int element) {
        int i;
        for (i = 0; i < num; i++) {
            if (set[i] == element) {
                break;
            }
        }

        if (i == num) {
            System.out.println("delete error : not found " + element);
        } else {
            for (; i < num - 1; i++) {
                set[i] = set[i + 1];
            }
            num--;
        }
    }

    private static void setInsert(int[] set, int element) {
        if (setIsMember(set, element)) {
            System.out.println(num + " is a member");
            return;
        }

        if (num < MAXSET) {
            set[num++] = element;
        } else {
            System.out.println("insert error : set is full");
        }
    }

    private static boolean setIsMember(int[] set, int element) {
        for (int i = 0; i < num; i++) {
            if (set[i] == element) {
                return true;
            }
        }
        return false;
    }

    private static int readInt() {
        return scanner.nextInt();
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }

}
