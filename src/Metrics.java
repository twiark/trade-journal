import java.util.ArrayList;

public class Metrics {

    private ArrayList<Trade> trades;

    public Metrics(ArrayList<Trade> trades) {
        this.trades = trades;
    }

    public double getTotalPnl() {
        double pnl = 0.0;
        for (int i = 0; i < trades.size(); i++) {
            pnl += trades.get(i).getPnl();
        }

        return pnl;
    }

    public double getWinRate() {
        double wins = 0;
        int losses = 0;
        for (int i = 0; i < trades.size(); i++) {
            if (trades.get(i).getPnl() > 0) {
                wins++;
            } else if (trades.get(i).getPnl() <= 0) {
                losses++;
            }
        }
        double tot = wins + losses;

        if (tot != 0) {
            double winrate = wins / tot;
            return winrate;
        } else {
            return 0.0;
        }

    }

    public double getAvgGain() {
        int wins = 0;
        double positivePnl = 0;
        for (int i = 0; i < trades.size(); i++) {
            if (trades.get(i).getPnl() > 0) {
                wins++;
                positivePnl += trades.get(i).getPnl();
            }
        }

        if (wins != 0) {
            double avgGain = positivePnl / wins;

            return avgGain;
        } else {
            return 0.0;
        }

    }

    public double getAvgLoss() {
        int losses = 0;
        double negativePnl = 0;

        for (int i = 0; i < trades.size(); i++) {
            if (trades.get(i).getPnl() <= 0) {
                losses++;
                negativePnl += trades.get(i).getPnl();
            }
        }

        if (losses != 0) {
            double avgLoss = negativePnl / losses;

            return avgLoss;
        } else {
            return 0.0;
        }

    }

    public double getExpectancy() {
        double expec = this.getWinRate() * this.getAvgGain() + (1 - this.getWinRate()) * this.getAvgLoss();

        return expec;
    }

}
