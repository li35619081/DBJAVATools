package woo.db.gen.template;

import java.io.StringWriter;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import woo.db.gen.tables.vo.FileValue;
import woo.db.gen.utils.StringUtil;

public class VelocityCore
{
  private static final VelocityEngine VELOCITY_ENGINE = new VelocityEngine();
  private static final VelocityContext CONTEXT = new VelocityContext();
  
  static
  {
    VELOCITY_ENGINE.setProperty("resource.loader", "file");
    
    VELOCITY_ENGINE.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
    
    VELOCITY_ENGINE.setProperty("input.encoding", "UTF-8");
    VELOCITY_ENGINE.setProperty("output.encoding", "UTF-8");
    
    try {
		VELOCITY_ENGINE.init();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    CONTEXT.put("StringUtil", new StringUtil());
  }
  
  public static FileValue gen(String fileName, Map<String, Object> paramMap)
  {
    VelocityContext peivateContext = (VelocityContext)CONTEXT.clone();
    for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
      peivateContext.put((String)entry.getKey(), entry.getValue());
    }
    try
    {
      StringWriter writer = new StringWriter();
      
      VELOCITY_ENGINE.getTemplate(fileName).merge(peivateContext, writer);
      
      return new FileValue(String.valueOf(peivateContext.get("className")), writer.toString());
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
}
