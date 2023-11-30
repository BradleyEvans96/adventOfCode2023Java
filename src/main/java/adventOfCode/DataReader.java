package adventOfCode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class DataReader {
    private int dayNumber;
    private String folderPath = "src/data/Day";

    public DataReader(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public String[] getExampleData() throws IOException {
        String filePath = this.folderPath + this.dayNumber + "/example.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String> lines = new ArrayList<String>();
        boolean isDataRead = false;
        while(!isDataRead) {
            String line = reader.readLine();
            if(line == null) {
                isDataRead = true;
            } else {
                lines.add(line);
            }
        }
        return lines.toArray(new String[]{});
    }

    public String[] getTestData() throws IOException {
        String filePath = this.folderPath + this.dayNumber + "/test.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String> lines = new ArrayList<String>();
        boolean isDataRead = false;
        while(!isDataRead) {
            String line = reader.readLine();
            if(line == null) {
                isDataRead = true;
            } else {
                lines.add(line);
            }
        }
        return lines.toArray(new String[]{});
    }
}
