import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        dataBases.connect();

        Map<String, String> vkData = ApiVK.createMapCity();
        String[][] csvData = Data.readDataLineByLine("D:\\Учёба\\Прога\\Java\\AnaliticsProject\\data\\basicprogramming_2_1.csv").toArray(new String[0][]);

//        NameMatcher.matchAndPrint(vkData, csvData);
        dataBases.displayStudents();

        System.out.println("\nВведите \"баллы\" или \"балл за задание\"");
        while (true) {
            // Вызываем метод Printer для обработки команд из консоли
            Printer.print(new ArrayList<>(Arrays.asList(csvData)));
        }



    }
}
