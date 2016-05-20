package woo.db.gen.tables.vo;

public class ColumnValue
{
  private String name;
  private String dbType;
  private String javaType;
  private boolean isPID;
  private boolean isAI;
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getDbType()
  {
    return this.dbType;
  }
  
  public void setDbType(String dbType)
  {
    this.dbType = dbType;
  }
  
  public String getJavaType()
  {
    return this.javaType;
  }
  
  public void setJavaType(String javaType)
  {
    this.javaType = javaType;
  }
  
  public boolean isPID()
  {
    return this.isPID;
  }
  
  public void setPID(boolean isPID)
  {
    this.isPID = isPID;
  }
  
  public boolean isAI()
  {
    return this.isAI;
  }
  
  public void setAI(boolean isAI)
  {
    this.isAI = isAI;
  }
  
  public String toString()
  {
    return "ColumnValue [name=" + this.name + ", dbType=" + this.dbType + ", javaType=" + this.javaType + ", isPID=" + this.isPID + ", isAI=" + this.isAI + "]";
  }
}
