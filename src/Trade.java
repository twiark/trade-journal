import java.time.LocalDate;
import java.time.LocalTime;
/*
* Represents a single futures trade, as one line of the trade log CSV.
*
* Author: Theo Winter Iark
* Nov 20th
* CS 193 Final Project
*/

public class Trade {

    private LocalDate date; // Date the trade was taken.

    private LocalTime time; // Time the trade was taken.

    private String symbol; // contract ticker (Ex: "ES", "MES").

    private String direction; // "LONG" or "SHORT", uppercase as in the CSV.

    private double entryVal; // price in index points, not dollars (the multiplier converts it later).

    private double exitVal; // same unit as entryVal

    private int quantity; // number of contracts traded

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

    public int getQuantity() {
        return this.quantity;
    }
}