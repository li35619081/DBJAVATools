package woo.db.gen.utils.style;

import woo.db.gen.utils.Symbol;

public class XmlStyle
  implements Style
{
  static final String START = "[\\s\\S]*<[^/]*>[\\s\\S]*";
  static final String END = "[\\s\\S]*</[\\s\\S]*>[\\s\\S]*";
  
  public String setStyle(String xmlString)
  {
    String[] classStrs = xmlString.split("\n|\r\n");
    StringBuffer newClassStr = new StringBuffer();
    
    int i = 0;
    for (String str : classStrs)
    {
      String temp = str.trim();
      if ((!temp.matches("[\\s\\S]*</[\\s\\S]*>[\\s\\S]*")) || (!temp.matches("[\\s\\S]*<[^/]*>[\\s\\S]*"))) {
        if ((temp.matches("[\\s\\S]*</[\\s\\S]*>[\\s\\S]*")) && (i > 0)) {
          i--;
        }
      }
      newClassStr.append(Symbol.TABS(i));
      newClassStr.append(temp);
      newClassStr.append(Symbol.getEnter());
      if ((!temp.matches("[\\s\\S]*</[\\s\\S]*>[\\s\\S]*")) || (!temp.matches("[\\s\\S]*<[^/]*>[\\s\\S]*"))) {
        if (temp.matches("[\\s\\S]*<[^/]*>[\\s\\S]*")) {
          i++;
        }
      }
    }
    return newClassStr.toString();
  }
}
