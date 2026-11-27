import java.io.*;

public class Report {
    private Metrics m;

    public Report(Metrics m) {
        this.m = m;
    }

    public void getReport() {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("TRADES_REPORT.txt"));

            pw.println("----- TRADES REPORT  -----");
            pw.println("Total PNL: $" + String.format("%.2f", m.getTotalPnl()));
            pw.println("Winrate: " + String.format("%.2f", (m.getWinRate() * 100)) + "%");
            pw.println("Average Win Value: $" + String.format("%.2f", m.getAvgGain()));
            pw.println("Average Loss Value: -$" + String.format("%.2f", (m.getAvgLoss() * -1)));
            pw.println("Expectancy: $" + String.format("%.2f", m.getExpectancy()));
            pw.println("");

            pw.close();
        } catch (IOException e) {
            IO.println("IO Exception Error.");
        }
    }
}
