package woo.db.gen.tables.db;

import java.sql.Connection;

public abstract interface DBConnection
{
  public abstract Connection getConnection();
}

