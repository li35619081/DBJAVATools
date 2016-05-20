package woo.db.gen.tables.type;

import java.util.HashMap;
import java.util.Map;
import woo.db.gen.utils.StringUtil;

public class TypeTransferFactory
{
  private static final Map<String, String> DIRECTION_TYPE = new HashMap();
  private static final Map<String, TypeTransfer> TRANSFER_TYPE_MAPPING = new HashMap();
  
  static
  {
    DIRECTION_TYPE.put("VARCHAR2", "String");
    DIRECTION_TYPE.put("VARCHAR", "String");
    DIRECTION_TYPE.put("CHAR", "String");
    DIRECTION_TYPE.put("DATE", "Date");
    DIRECTION_TYPE.put("DATETIME", "Timestamp");
    DIRECTION_TYPE.put("TIME", "Time");
    
    TRANSFER_TYPE_MAPPING.put("INT", new NumberMysqlTransfer());
    TRANSFER_TYPE_MAPPING.put("NUMBER", new NumberMysqlTransfer());
  }
  
  public static String getType(String data)
  {
    String upperData = data.toUpperCase();
    String javaType = (String)DIRECTION_TYPE.get(upperData);
    if (StringUtil.isEmpty(javaType)) {
      return "UNKNOWN";
    }
    return javaType;
  }
  
  public static String getType(String data, int scale)
  {
    String upperData = data.toUpperCase();
    TypeTransfer typeTransfer = (TypeTransfer)TRANSFER_TYPE_MAPPING.get(upperData);
    if (typeTransfer != null) {
      return typeTransfer.getType(new Object[] { upperData, Integer.valueOf(scale) });
    }
    return "UNKNOWN";
  }
}
