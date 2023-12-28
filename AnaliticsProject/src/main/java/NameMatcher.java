import java.util.Map;

public class NameMatcher {
    public static void matchAndPrint(Map<String, String> vkData, String[][] csvData) {
        System.out.println("Совпадения имен:");

        for (Map.Entry<String, String> entry : vkData.entrySet()) {
            String vkName = entry.getKey();
            String vkCity = entry.getValue();

            for (String[] csvRow : csvData) {
                String csvFullName = csvRow[0];

                if (vkName.equals(csvFullName)) {
                    System.out.println(vkName + ", Город: " + vkCity);

                    dataBases.insertStudent(csvFullName, vkCity);
                }
            }
        }
    }
}
