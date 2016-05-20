package woo.db.gen.tables.type;

import woo.db.gen.utils.NumberUtils;

public class NumberMysqlTransfer
  implements TypeTransfer
{
  public static final String DB_TYPE = "INT";
  public static final String JAVA_TYPE = "Integer";
  public static final String JAVA_TYPE2 = "Double";
  
  public String getType(Object... paramObjs)
  {
    if ("INT".equals(paramObjs[0]))
    {
      if (paramObjs.length > 1)
      {
        int scale = NumberUtils.parseInt(paramObjs[1]);
        if (scale > 0) {
          return "Double";
        }
      }
      return "Integer";
    }
    return "UNKNOWN";
  }
}
