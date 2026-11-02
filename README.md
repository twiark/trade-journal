# Trade Journal

A Java command line tool that analyzes a futures trade log and reports
whether a trader's strategy actually makes money.

## Project Goal

Many beginner futures traders only look at their account balance, which
does not show whether their strategy works. A trader who wins 60% of
trades with an average win of $50 and an average loss of $100 still
loses $10 per trade: (0.6 x 50) - (0.4 x 100) = -$10. This tool reads a
trade log and reports the numbers that expose problems like this, so
traders can judge their results with data instead of feelings.

## MVP Scope (Version 1.0)

- Read a CSV file of trades (one trade per line) into `Trade` objects
- Calculate dollar P&L per trade using the contract multiplier
  (ES = $50/point, MES = $5/point)
- Report win rate, average win, average loss, expectancy per trade,
  and total result
- Print the results as a formatted report in the terminal

## Future Plans (Version 2.0+)

- Maximum drawdown
- Win rate and results by time of day
- Comparison of the next trade's result after a loss vs. after a win
- Bash script that compiles, runs the program, and saves a report with
  the date in the file name

The system diagram in `docs/` shows the full planned flow, including
the Version 2.0 features.

## Tech Stack

- Java (standard library only: `java.io`, `java.util`, `java.time`)
- Bash for the wrapper script (planned for Version 2.0)
- Git and GitHub for version control
- Data storage: plain CSV file in, plain text report out

## Project Structure

- `src/`: Java source code
- `data/`: sample trade CSV files
- `docs/`: Eisenhower matrix (PDF) and system diagram (PNG and draw.io source)

## Usage (planned)

    java Main data/sample_trades.csv

## Status

In development. See `docs/` for the design.
