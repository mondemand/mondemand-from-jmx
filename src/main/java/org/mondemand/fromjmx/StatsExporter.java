package org.mondemand.fromjmx;

import java.util.List;

/**
 * The interface implemented by classes wishing to
 * export {@link ExportedStat}s.
 * 
 * @author Joel Meyer (joel.meyer@openx.org)
 */
public interface StatsExporter {
  void exportAll(List<ExportedStat> exportedStats);
}
