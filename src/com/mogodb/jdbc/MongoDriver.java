package com.mogodb.jdbc;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by christkv on 9/30/15.
 */
public class MongoDriver implements Driver {
  @Override
  public Connection connect(String url, Properties info) throws SQLException {
    if (info != null && info.size() > 0) {
      throw new UnsupportedOperationException("properties are not supported");
    }

    // Create a mongo client
    return new MongoConnection(url);
  }

  @Override
  public boolean acceptsURL(String url) throws SQLException {
    return false;
  }

  @Override
  public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
    return new DriverPropertyInfo[0];
  }

  @Override
  public int getMajorVersion() {
    return 1;
  }

  @Override
  public int getMinorVersion() {
    return 0;
  }

  @Override
  public boolean jdbcCompliant() {
    return false;
  }

  @Override
  public Logger getParentLogger() throws SQLFeatureNotSupportedException {
    throw new SQLFeatureNotSupportedException("logger not supported");
  }
}
