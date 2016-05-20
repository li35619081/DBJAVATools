package woo.db.gen.utils.style;

import java.io.PrintStream;
import woo.db.gen.utils.Symbol;

public class CodeStyle
  implements Style
{
  public String setStyle(String classString)
  {
    String[] classStrs = classString.split("\n|\r\n");
    StringBuffer newClassStr = new StringBuffer();
    
    int i = 0;
    for (String str : classStrs)
    {
      String temp = str.trim();
      if ((temp.indexOf("}") > -1) && (i > 0))
      {
        i--;
        temp = temp + Symbol.getEnter();
      }
      newClassStr.append(Symbol.TABS(i));
      newClassStr.append(temp);
      newClassStr.append(Symbol.getEnter());
      if (temp.indexOf("{") > -1) {
        i++;
      }
    }
    return newClassStr.toString();
  }
  
  public static void main(String[] args)
  {
    String test = "asdf\r\n";
    System.out.println(test.trim() + 1);
  }
}
