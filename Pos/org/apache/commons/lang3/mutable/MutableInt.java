package org.apache.commons.lang3.mutable;

public class MutableInt
  extends Number
  implements Comparable<MutableInt>, Mutable<Number>
{
  private static final long serialVersionUID = 512176391864L;
  private int value;
  
  public MutableInt() {}
  
  public MutableInt(int paramInt)
  {
    this.value = paramInt;
  }
  
  public MutableInt(Number paramNumber)
  {
    this.value = paramNumber.intValue();
  }
  
  public MutableInt(String paramString)
    throws NumberFormatException
  {
    this.value = Integer.parseInt(paramString);
  }
  
  public void add(int paramInt)
  {
    this.value += paramInt;
  }
  
  public void add(Number paramNumber)
  {
    this.value += paramNumber.intValue();
  }
  
  public int compareTo(MutableInt paramMutableInt)
  {
    int i = paramMutableInt.value;
    if (this.value < i) {
      return -1;
    }
    if (this.value == i) {
      return 0;
    }
    return 1;
  }
  
  public void decrement()
  {
    this.value -= 1;
  }
  
  public double doubleValue()
  {
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MutableInt))
    {
      bool1 = bool2;
      if (this.value == ((MutableInt)paramObject).intValue()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public float floatValue()
  {
    return this.value;
  }
  
  public Integer getValue()
  {
    return Integer.valueOf(this.value);
  }
  
  public int hashCode()
  {
    return this.value;
  }
  
  public void increment()
  {
    this.value += 1;
  }
  
  public int intValue()
  {
    return this.value;
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public void setValue(int paramInt)
  {
    this.value = paramInt;
  }
  
  public void setValue(Number paramNumber)
  {
    this.value = paramNumber.intValue();
  }
  
  public void subtract(int paramInt)
  {
    this.value -= paramInt;
  }
  
  public void subtract(Number paramNumber)
  {
    this.value -= paramNumber.intValue();
  }
  
  public Integer toInteger()
  {
    return Integer.valueOf(intValue());
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:              C:\Users\Administrator\Desktop\classes-dex2jar.jar!\org\apache\commons\lang3\mutable\MutableInt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */