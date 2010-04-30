package org.mondemand.fromjmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServerConnection;

/**
 * @author Joel Meyer (joel.meyer@openx.org)
 *
 */
public class LocalMBeanServerProvider implements MBeanServerProvider {

  /**
   * @see org.mondemand.fromjmx.MBeanServerProvider#getMBeanServer()
   */
  @Override
  public MBeanServerConnection getMBeanServer() {
    return ManagementFactory.getPlatformMBeanServer();
  }
}
