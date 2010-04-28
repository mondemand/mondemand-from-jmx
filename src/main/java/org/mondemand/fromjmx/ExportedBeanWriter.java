// Copyright OpenX Limited 2010. All Rights Reserved.
package org.mondemand.fromjmx;

import java.io.PrintStream;
import java.util.List;

/**
 * Writes a list of {@link ExportedBean}s to a {@link PrintStream}.
 * 
 * @author Joel Meyer (joel.meyer@openx.org)
 */
public class ExportedBeanWriter {
  protected final PrintStream out;
  
  public ExportedBeanWriter(PrintStream out) {
    this.out = out;
  }
  
  public void writeAll(List<ExportedBean> exportedBeans) {
    for (ExportedBean exportedBean : exportedBeans) {
      out.println(exportedBean.getObjectNameIdentifier());
      
      List<ExportedAttribute> exportedAttributes = exportedBean.getExportedAttributes();
      for (ExportedAttribute exportedAttribute : exportedAttributes) {
        out.println(String.format("\t%s\t%s", exportedAttribute.name, exportedAttribute.exportName));
      }
    }
  }
}
