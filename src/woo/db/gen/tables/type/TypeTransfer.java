package woo.db.gen.tables.type;

public abstract interface TypeTransfer
{
  public static final String UNKNOWN = "UNKNOWN";
  
  public abstract String getType(Object... paramVarArgs);
}


