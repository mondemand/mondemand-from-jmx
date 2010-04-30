package org.mondemand.fromjmx;

import java.io.IOException;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * @author Joel Meyer (joel.meyer@openx.org)
 *
 */
public class RemoteMBeanServerProvider implements MBeanServerProvider {
  private final String host;
  private final int port;

  private MBeanServerConnection mbeanServerConn;

  public RemoteMBeanServerProvider(String host, int port) {
    this.host = host;
    this.port = port;
  }

  public void connect() throws IOException {
    JMXServiceURL jmxURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + host + ":" + port + "/jmxrmi");
    JMXConnector jmxConnector = JMXConnectorFactory.connect(jmxURL);
    MBeanServerConnection conn = jmxConnector.getMBeanServerConnection();
    this.mbeanServerConn = conn;
  }

  /**
   * @see org.mondemand.fromjmx.MBeanServerProvider#getMBeanServer()
   */
  @Override
  public MBeanServerConnection getMBeanServer() {
    return mbeanServerConn;
  }
}
