package org.mondemand.fromjmx;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Reads a list of {@link ExportedBean}s from a {@link BufferedReader}.
 * 
 * @author Joel Meyer (joel.meyer@openx.org)
 */
public class ExportedBeanReader {
  private static final Logger LOG = Logger.getLogger(ExportedBeanReader.class);

  protected final BufferedReader in;

  public ExportedBeanReader(BufferedReader in) {
    this.in = in;
  }

  public List<ExportedBean> readAll() throws IOException {
    List<ExportedBean> exportedBeans = new ArrayList<ExportedBean>();

    ExportedBean exportedBean = null;

    String line = null;
    while ((line = in.readLine()) != null) {
      if (line.matches("^\\s*#")) {
        // Comment, ignore
        LOG.info(String.format("Skipping comment: %s", line));
      } else if (line.startsWith("\t")) {
        // Attribute
        if (exportedBean == null) {
          LOG.error(String.format("Found attribute that can't be tied to a bean, skipping: %s", line.trim()));
        } else {
          String[] attrExportName = line.trim().split("\\t");
          if (attrExportName.length != 2) {
            LOG.error(String.format("Attribute line does not have valid format (name + TAB + exportName), skipping: %s", line.trim()));
          } else {
            exportedBean.addExportedAttribute(new ExportedAttribute(attrExportName[0], attrExportName[1]));
          }
        }
      } else {
        // Bean
        exportedBean = new ExportedBean(line.trim());
        exportedBeans.add(exportedBean);
      }
    }

    return exportedBeans;
  }
}
