package woo.db.gen.tables.vo;

import java.util.ArrayList;
import java.util.List;

public class TableValue
{
  private String name;
  private List<ColumnValue> columnList;
  private List<ColumnValue> columnPIDList;
  
  public TableValue(String name)
  {
    this.columnList = new ArrayList();
    this.columnPIDList = new ArrayList();
  }
  
  public TableValue(String name, List<ColumnValue> columnValueList)
  {
    this.name = name;
    this.columnList = columnValueList;
    
    this.columnPIDList = new ArrayList();
    for (ColumnValue columnValue : columnValueList) {
      if (columnValue.isPID()) {
        this.columnPIDList.add(columnValue);
      }
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public List<ColumnValue> getColumnPIDList()
  {
    return this.columnPIDList;
  }
  
  public void setColumnPIDList(List<ColumnValue> columnPIDList)
  {
    this.columnPIDList = columnPIDList;
  }
  
  public List<ColumnValue> getColumnList()
  {
    return this.columnList;
  }
  
  public void setColumnList(List<ColumnValue> columnList)
  {
    this.columnList = columnList;
  }
  
  public String toString()
  {
    return "TableValue [name=" + this.name + ", columnList=" + this.columnList + "]";
  }
}
