import java.util.ArrayList;
public class Balls {
    private final String[] point;
    private final ArrayList<String[]> values = new ArrayList<>(); // Список для хранения пар значений (название задания, оценка)
    private final String[] title;
    private final String name;
    private final String course;

    public Balls(String name, String course, String[] point, String[] title) {
        this.name = name;
        this.course = course;
        this.point = point;
        this.title = title;
        for (int i = 0; i < title.length; i++) {
            // Заполняем список значениями из массивов оценок и названий заданий
            values.add(new String[]{title[i], point[i]});
        }
    }

    public ArrayList<String[]> getvalues() {
        return values;
    }


    public String getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student " +
                "name = " + name +
                ", course = " + course;
    }
}
