import java.time.LocalDate;
import java.time.LocalTime;
/*
* Represents a single futures trade, as one line of the trade log CSV.
*
* Author: Theo Winter Iark
* Nov 20th
* CS 193 Final Project
*/

//       ▄██▄
//     ▄▓████▓▄        ██████╗ ███████╗██╗     ██╗
//    ▒▓██████▓▒       ██╔══██╗██╔════╝██║     ██║
//    ▒▓██████▓▒       ██████╔╝█████╗  ██║     ██║
//   ░▒▓██████▓▒░      ██╔══██╗██╔══╝  ██║     ██║
//  ░▒▓████████▓▒░     ██████╔╝███████╗███████╗███████╗
// ░▒▓██████████▓▒░    ╚═════╝ ╚══════╝╚══════╝╚══════╝
//       ▀██▀

public class Trade {

    private LocalDate date; // Date the trade was taken.

    private LocalTime time; // Time the trade was taken.

    private String symbol; // This represents the ticker of the contract traded (Ex: ES Represents a
                           // futures contract on the S&P500).

    private String direction; // This represents the direction of the trade, a short means the seller thinks
                              // the price is going
                              // down, a long means the trader believes the price will go up. For every
                              // futures trade there is
                              // one entity on each side "betting" the price is going on either direction.

    private double entryVal; // This is the price the contract was at when the trader decided to go long or
                             // short.

    private double exitVal; // This is the price the contract was at when the trader decided to leave the
                            // trade, or when the contract
                            // expired. If the trader entered long and this price is higher than entryVal he
                            // made a profit. Otherwise
                            // the other entity in the trade would.

    private int quantity; // Amount of contracts the trader decided to buy. This will multiply your
                          // exposition to the underlined asset
                          // by the amount of contracts you bought (Example: if you bought 5 contracts and
                          // the profit for one was $100,
                          // would have made $500, but the same applies to losses, they would be 5'xed
                          // aswell).

    // Constructor for the Trade object.
    public Trade(LocalDate date, LocalTime time, String symbol, String direction, double entryVal, double exitVal,
            int quantity) {
        this.date = date;
        this.time = time;
        this.symbol = symbol;
        this.direction = direction;
        this.entryVal = entryVal;
        this.exitVal = exitVal;
        this.quantity = quantity;

    }

    // Getters for each value of the CSV Line.
    public LocalDate getDate() {
        return this.date;
    }

    public LocalTime getTime() {
        return this.time;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getDirection() {
        return this.direction;
    }

    public double getEntryVal() {
        return this.entryVal;
    }

    public double getExitVal() {
        return this.exitVal;
    }

    private int getQuantity() {
        return this.quantity;
    }

    public static void main(String[] args) {
        Trade t = new Trade(LocalDate.of(2026, 10, 5), LocalTime.of(9, 35), "ES", "LONG", 5000.00, 5004.00, 1);
        IO.println("Direction: " + t.getDirection());
        IO.println("Date: " + t.getDate());
        IO.println("Time: " + t.getTime());
        IO.println("Symbol: " + t.getSymbol());
        IO.println("Entry value: " + t.getEntryVal());
        IO.println("Exit value: " + t.getExitVal());
        IO.println("Quantity: " + t.getQuantity());
    }

}
