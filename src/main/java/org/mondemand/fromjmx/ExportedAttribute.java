package org.mondemand.fromjmx;

/**
 * Identifies an mbean attribute and the name that will be used
 * to identify it when it's exported. The attribute name can be
 * dotted to denote sub-attributes (e.g. an {@link CompositeData}
 * value that has several child values).
 * 
 * @author Joel Meyer (joel.meyer@openx.org)
 */
public class ExportedAttribute {
  /** Name of the bean attribute. */
  public final String name;
  
  /** Name used when exporting the attribute. */
  public final String exportName;
  
  public ExportedAttribute(String name, String exportName) {
    this.name = name;
    this.exportName = exportName;
  }
}
