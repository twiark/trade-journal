import java.io.*;
import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Trade> trades = readTrades(args[0]);
        if (trades.isEmpty() == true) {
            IO.println("There are no trades in this file.");
        }
    }

    public static ArrayList<Trade> readTrades(String path) {
        ArrayList<Trade> tradeList = new ArrayList<Trade>();
        if (path.length() == 0) {
            IO.println("Empty file.");
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                String line = br.readLine(); // Skipping the headline.
                line = br.readLine();
                while (line != null) {
                    String[] arr = line.split(",");
                    if (arr.length == 7) {
                        try {
                            Trade t = new Trade(LocalDate.parse(arr[0]), LocalTime.parse(arr[1]), arr[2], arr[3],
                                    Double.parseDouble(arr[4]), Double.parseDouble(arr[5]), Integer.parseInt(arr[6]));
                            tradeList.add(t);
                        } catch (NumberFormatException e) {
                            IO.println("File Structure not correct.");
                        } catch (DateTimeParseException z) {
                            IO.println("File Structure not correct.");
                        }
                    } else {
                        IO.println("File Structure not correct.");
                    }
                    line = br.readLine();
                }
                br.close();
            } catch (FileNotFoundException e) {
                IO.println("File not found.");
            } catch (IOException s) {
                IO.println("IOException error");
            }
        }
        return tradeList;

    }

}
