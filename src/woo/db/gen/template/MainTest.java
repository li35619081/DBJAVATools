package woo.db.gen.template;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import woo.db.gen.tables.vo.FileValue;

public class MainTest
{
  public static void main(String[] args)
  {
    Map<String, Object> map = new HashMap();
    
    map.put("aaa", "aaa");
    map.put("bbb", "");
    
    FileValue file = VelocityCore.gen("template/vo.java.vm", map);
    
    System.out.println(file);
  }
}
