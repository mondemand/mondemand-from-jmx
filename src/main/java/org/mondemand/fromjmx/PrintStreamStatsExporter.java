package org.mondemand.fromjmx;

import java.io.PrintStream;
import java.util.List;

/**
 * Exports a list of {@link ExportedStat}s to a {@link PrintStream}.
 * 
 * @author Joel Meyer (joel.meyer@openx.org)
 */
public class PrintStreamStatsExporter implements StatsExporter {
  protected final PrintStream out;
  protected final String separator;

  public PrintStreamStatsExporter(PrintStream out, String separator) {
    this.out = out;
    this.separator = separator;
  }

  @Override
  public void exportAll(List<ExportedStat> exportedStats) {
    for (ExportedStat exportedStat : exportedStats) {
      out.print(exportedStat.name);
      out.print(separator);
      out.println(exportedStat.value);
    }
  }
}
