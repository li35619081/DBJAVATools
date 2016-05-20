package woo.db.gen.config;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import woo.db.gen.utils.FileSystem;
import woo.db.gen.utils.StringUtil;

public class ConfigFactory
{
  private Properties properties = new Properties();
  
  public static ConfigFactory getInstance()
  {
    return Init.configFactory;
  }
  
  public String get(String key)
  {
    return this.properties.getProperty(key);
  }
  
  public String[] getTables()
  {
    return this.properties.getProperty("tables").toUpperCase().split(",");
  }
  
  public String[] getGenType()
  {
    return this.properties.getProperty("generate").split(",");
  }
  
  public void print()
  {
    System.out.println(this.properties);
  }
  
  private static class Init
  {
    private static ConfigFactory configFactory = new ConfigFactory();
    
    static
    {
      try
      {
        String path = System.getProperty("tool.path.config");
        System.out.println("tool.path.config:" + path);
        if (StringUtil.isEmpty(path)) {
          configFactory.properties.load(FileSystem.readToStream("generate.properties"));
        } else {
          configFactory.properties.load(FileSystem.readToStream(path));
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    }
  }
}
