import java.io.*;
import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 0) {
            ArrayList<Trade> trades = readTrades(args[0]);
            if (trades.isEmpty()) {
                IO.println("There are no trades in this file.");
            }
        } else {
            IO.println("No arguments in method call");
        }

    }

    public static ArrayList<Trade> readTrades(String path) {
        ArrayList<Trade> tradeList = new ArrayList<Trade>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine(); // Skipping the headline.
            line = br.readLine();
            int lineNum = 2;
            while (line != null) {
                String[] arr = line.split(",");
                if (arr.length == 7) {
                    try {
                        Trade t = new Trade(LocalDate.parse(arr[0]), LocalTime.parse(arr[1]), arr[2], arr[3],
                                Double.parseDouble(arr[4]), Double.parseDouble(arr[5]), Integer.parseInt(arr[6]));
                        if (t.getMultiplier() != 0) {
                            if (t.getDirection().equals("SHORT") || t.getDirection().equals("LONG")) {
                                tradeList.add(t);
                            } else {
                                IO.println("Skipping line number " + lineNum + " unknown direction.");
                            }
                        } else {
                            IO.println("Skipping line number " + lineNum + " unknown symbol.");
                        }

                    } catch (NumberFormatException | DateTimeParseException z) {
                        IO.println("File Structure not correct. Error at line: " + lineNum);
                    }
                } else {
                    IO.println("File Structure not correct. Error at line: " + lineNum);
                }
                line = br.readLine();
                lineNum++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            IO.println("File not found.");
        } catch (IOException s) {
            IO.println("IOException error");
        }

        return tradeList;

    }

}
