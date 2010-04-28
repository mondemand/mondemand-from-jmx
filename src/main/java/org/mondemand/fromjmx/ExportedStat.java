package org.mondemand.fromjmx;

/**
 * This class represents the value of an MBean attribute at a
 * given point in time.
 * 
 * @author Joel Meyer (joel.meyer@openx.org)
 */
public class ExportedStat {
  /** The name of the exported stat. */
  public final String name;
  
  /** The value of the exported stat. */
  public final long value;

  public ExportedStat(String name, long value) {
    this.name = name;
    this.value = value;
  }
}