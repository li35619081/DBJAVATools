package woo.db.gen.tables.reader;

import java.util.List;
import woo.db.gen.tables.db.DBConnection;
import woo.db.gen.tables.vo.TableValue;

public abstract interface TableReader
{
  public abstract List<TableValue> getTables(DBConnection paramDBConnection, String paramString, String... paramVarArgs);
}
