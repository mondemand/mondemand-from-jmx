package org.mondemand.fromjmx;

import java.util.List;

import org.mondemand.Client;

/**
 * This class exports a list of {@link ExportedStat}s to mondemand.
 * 
 * @author Joel Meyer (joel.meyer@openx.org)
 */
public class MonDemandStatsExporter implements StatsExporter {
  protected final Client client;

  public MonDemandStatsExporter(Client client) {
    this.client = client;
  }

  @Override
  public void exportAll(List<ExportedStat> exportedStats){
    for (ExportedStat exportedStat : exportedStats) {
      client.setKey(exportedStat.name, exportedStat.value);
    }
  }
}
