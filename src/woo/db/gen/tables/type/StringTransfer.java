 package woo.db.gen.tables.type;
 
 public class StringTransfer implements TypeTransfer
 {
   public static final String DB_TYPE = "VARCHAR2";
   public static final String JAVA_TYPE = "String";
   
   public String getType(Object... paramObjs) {
     if ("VARCHAR2".equals(paramObjs[0])) {
       return "String";
     }
     return "UNKNOWN";
   }
 }


