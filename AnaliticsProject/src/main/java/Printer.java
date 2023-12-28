import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Printer {
    public static void print(ArrayList<String[]> data) {


        Scanner input = new Scanner(System.in);
        String inputStr = input.nextLine();
        // балл
        if (inputStr.equals("баллы")) {
            System.out.println("введите полное имя");
            String ds = input.nextLine();
            // Ищем соответствующую запись в данных
            for (int ia = 0; ia < data.size(); ia++) {
                if (data.get(ia)[0].equals(ds)) {
                    // Выводим баллы по каждому заданию
                    for (String[] s : new Balls(data.get(ia)[0], data.get(ia)[1], Arrays.copyOfRange(data.get(ia), 2, data.get(ia).length), Arrays.copyOfRange(data.get(1), 2, data.get(1).length)).getvalues()) {
                        System.out.println(Arrays.toString(s));
                    }
                }
            }
        }
        // балл за задание
        else if (inputStr.equals("балл за задание")) {
            System.out.println("Введите полное имя и заголовок задания, разделитель - запятая (без пробелов)");
            String ds = input.nextLine();
            // Ищем соответствующую запись в данных
            for (int ia = 0; ia < data.size(); ia++) {
                if (data.get(ia)[0].equals(ds.split(",")[0])) {
                    // Выводим баллы по заданию с указанным заголовком
                    for (String[] s : new Balls(data.get(ia)[0], data.get(ia)[1], Arrays.copyOfRange(data.get(ia), 2, data.get(ia).length), Arrays.copyOfRange(data.get(1), 2, data.get(1).length)).getvalues()) {
                        if (s[0].contains(ds.split(",")[1])) {
                            System.out.println(Arrays.toString(s));
                        }
                    }
                }
            }
        }
        else if (inputStr.equals("выход")){
            System.exit(0);
        }
    }
}


