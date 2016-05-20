package woo.db.gen.tables.db;

public class MysqlConnection
  extends ConnectionCommon
{
  protected String getDriver()
  {
    return "com.mysql.jdbc.Driver";
  }
}
