package org.apache.commons.lang3.text;

import java.util.Map;

public abstract class StrLookup<V>
{
  private static final StrLookup<String> NONE_LOOKUP = new MapStrLookup(null);
  private static final StrLookup<String> SYSTEM_PROPERTIES_LOOKUP;
  
  static
  {
    try
    {
      MapStrLookup localMapStrLookup = new MapStrLookup(System.getProperties());
      SYSTEM_PROPERTIES_LOOKUP = localMapStrLookup;
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        StrLookup localStrLookup = NONE_LOOKUP;
      }
    }
  }
  
  public static <V> StrLookup<V> mapLookup(Map<String, V> paramMap)
  {
    return new MapStrLookup(paramMap);
  }
  
  public static StrLookup<?> noneLookup()
  {
    return NONE_LOOKUP;
  }
  
  public static StrLookup<String> systemPropertiesLookup()
  {
    return SYSTEM_PROPERTIES_LOOKUP;
  }
  
  public abstract String lookup(String paramString);
  
  static class MapStrLookup<V>
    extends StrLookup<V>
  {
    private final Map<String, V> map;
    
    MapStrLookup(Map<String, V> paramMap)
    {
      this.map = paramMap;
    }
    
    public String lookup(String paramString)
    {
      if (this.map == null) {}
      do
      {
        return null;
        paramString = this.map.get(paramString);
      } while (paramString == null);
      return paramString.toString();
    }
  }
}


/* Location:              C:\Users\Administrator\Desktop\classes-dex2jar.jar!\org\apache\commons\lang3\text\StrLookup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */