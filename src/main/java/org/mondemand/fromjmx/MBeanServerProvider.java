// Copyright OpenX Limited 2010. All Rights Reserved.
package org.mondemand.fromjmx;

import javax.management.MBeanServerConnection;

/**
 * @author Joel Meyer (joel.meyer@openx.org)
 *
 */
public interface MBeanServerProvider {
  public MBeanServerConnection getMBeanServer();
}
