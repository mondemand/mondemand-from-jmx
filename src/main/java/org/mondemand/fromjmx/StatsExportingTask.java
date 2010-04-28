// Copyright OpenX Limited 2010. All Rights Reserved.
package org.mondemand.fromjmx;

import java.util.List;

/**
 * This class represents a task that, when executed, collects
 * {@link ExportedStat}s from the {@link JmxStatExporter} and
 * exports them using a {@link StatsExporter}.
 * 
 * @author Joel Meyer (joel.meyer@openx.org)
 */
public class StatsExportingTask implements Runnable {
  protected final JmxStatExporter jmxStatExporter;
  protected final StatsExporter exportedStatExporter;
  
  public StatsExportingTask(JmxStatExporter jmxStatExporter, StatsExporter exportedStatExporter) {
    this.jmxStatExporter = jmxStatExporter;
    this.exportedStatExporter = exportedStatExporter;
  }
  
  /**
   * Grabs the exported stats and exports them.
   * @see java.lang.Runnable#run()
   */
  @Override
  public void run() {
    List<ExportedStat> exportedStats = jmxStatExporter.getExportedStats();
    exportedStatExporter.exportAll(exportedStats);
  }
}
