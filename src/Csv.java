import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Csv {
    private String[] header;
    private ArrayList<String[]> data;

    public Csv() {
        data = new ArrayList<String[]>();
    }

    public String[] getHeader() {
        return header;
    }

    public ArrayList<String[]> getData() {
        return data;
    }

    public void setHeader(String[] header) {
        this.header = header;
        this.data.add(header);
    }

    public void addData(String[] data) {
        this.data.add(data);
    }

    public void clear() {
        this.data.clear();
    }

    public void writeCSV(String fileName) {

        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            for (String[] str : data) {
                for (String s : str) {
                    writer.write(s + ";");
                }
                writer.write("\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private ArrayList<String> getRecordFromLine(String line) {
        ArrayList<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(";");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    public void readCSVFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                ArrayList<String> str = getRecordFromLine(scanner.nextLine());
                data.add(str.toArray(new String[0]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printCSV() {
        for (String[] str : data) {
            for (String s : str) {
                System.out.print(s + ";");
            }
            System.out.println();
        }
    }
}
