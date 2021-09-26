import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String[] header = {"Value 1","Value 2","Value 3"};
        Csv csv = new Csv();

        csv.setHeader(header);

        csv.addData(new String[] {"1","2","3"});
        csv.addData(new String[] {"4","5","6"});
        csv.addData(new String[] {"7","8","9"});
        csv.addData(new String[] {"11","12","13"});
        csv.addData(new String[] {"10","20","30"});

        csv.writeCSV("test.csv");
        csv.clear();

        csv.readCSVFile("test.csv");
        csv.printCSV();
    }
}
