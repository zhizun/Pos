package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DateUtils
{
  public static final long MILLIS_PER_DAY = 86400000L;
  public static final long MILLIS_PER_HOUR = 3600000L;
  public static final long MILLIS_PER_MINUTE = 60000L;
  public static final long MILLIS_PER_SECOND = 1000L;
  private static final int MODIFY_CEILING = 2;
  private static final int MODIFY_ROUND = 1;
  private static final int MODIFY_TRUNCATE = 0;
  public static final int RANGE_MONTH_MONDAY = 6;
  public static final int RANGE_MONTH_SUNDAY = 5;
  public static final int RANGE_WEEK_CENTER = 4;
  public static final int RANGE_WEEK_MONDAY = 2;
  public static final int RANGE_WEEK_RELATIVE = 3;
  public static final int RANGE_WEEK_SUNDAY = 1;
  public static final int SEMI_MONTH = 1001;
  private static final int[][] fields = { { 14 }, { 13 }, { 12 }, { 11, 10 }, { 5, 5, 9 }, { 2, 1001 }, { 1 }, { 0 } };
  
  private static Date add(Date paramDate, int paramInt1, int paramInt2)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(paramInt1, paramInt2);
    return localCalendar.getTime();
  }
  
  public static Date addDays(Date paramDate, int paramInt)
  {
    return add(paramDate, 5, paramInt);
  }
  
  public static Date addHours(Date paramDate, int paramInt)
  {
    return add(paramDate, 11, paramInt);
  }
  
  public static Date addMilliseconds(Date paramDate, int paramInt)
  {
    return add(paramDate, 14, paramInt);
  }
  
  public static Date addMinutes(Date paramDate, int paramInt)
  {
    return add(paramDate, 12, paramInt);
  }
  
  public static Date addMonths(Date paramDate, int paramInt)
  {
    return add(paramDate, 2, paramInt);
  }
  
  public static Date addSeconds(Date paramDate, int paramInt)
  {
    return add(paramDate, 13, paramInt);
  }
  
  public static Date addWeeks(Date paramDate, int paramInt)
  {
    return add(paramDate, 3, paramInt);
  }
  
  public static Date addYears(Date paramDate, int paramInt)
  {
    return add(paramDate, 1, paramInt);
  }
  
  public static Calendar ceiling(Calendar paramCalendar, int paramInt)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    paramCalendar = (Calendar)paramCalendar.clone();
    modify(paramCalendar, paramInt, 2);
    return paramCalendar;
  }
  
  public static Date ceiling(Object paramObject, int paramInt)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    if ((paramObject instanceof Date)) {
      return ceiling((Date)paramObject, paramInt);
    }
    if ((paramObject instanceof Calendar)) {
      return ceiling((Calendar)paramObject, paramInt).getTime();
    }
    throw new ClassCastException("Could not find ceiling of for type: " + paramObject.getClass());
  }
  
  public static Date ceiling(Date paramDate, int paramInt)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    modify(localCalendar, paramInt, 2);
    return localCalendar.getTime();
  }
  
  private static long getFragment(Calendar paramCalendar, int paramInt1, int paramInt2)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    long l6 = getMillisPerUnit(paramInt2);
    long l1 = 0L;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      l2 = l1;
      l3 = l1;
      l4 = l1;
      l5 = l1;
      switch (paramInt1)
      {
      case 3: 
      case 4: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      default: 
        throw new IllegalArgumentException("The fragment " + paramInt1 + " is not supported");
        l1 = 0L + paramCalendar.get(6) * 86400000L / l6;
        continue;
        l1 = 0L + paramCalendar.get(5) * 86400000L / l6;
      }
    }
    long l2 = l1 + paramCalendar.get(11) * 3600000L / l6;
    long l3 = l2 + paramCalendar.get(12) * 60000L / l6;
    long l4 = l3 + paramCalendar.get(13) * 1000L / l6;
    long l5 = l4 + paramCalendar.get(14) * 1 / l6;
    return l5;
  }
  
  private static long getFragment(Date paramDate, int paramInt1, int paramInt2)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return getFragment(localCalendar, paramInt1, paramInt2);
  }
  
  public static long getFragmentInDays(Calendar paramCalendar, int paramInt)
  {
    return getFragment(paramCalendar, paramInt, 6);
  }
  
  public static long getFragmentInDays(Date paramDate, int paramInt)
  {
    return getFragment(paramDate, paramInt, 6);
  }
  
  public static long getFragmentInHours(Calendar paramCalendar, int paramInt)
  {
    return getFragment(paramCalendar, paramInt, 11);
  }
  
  public static long getFragmentInHours(Date paramDate, int paramInt)
  {
    return getFragment(paramDate, paramInt, 11);
  }
  
  public static long getFragmentInMilliseconds(Calendar paramCalendar, int paramInt)
  {
    return getFragment(paramCalendar, paramInt, 14);
  }
  
  public static long getFragmentInMilliseconds(Date paramDate, int paramInt)
  {
    return getFragment(paramDate, paramInt, 14);
  }
  
  public static long getFragmentInMinutes(Calendar paramCalendar, int paramInt)
  {
    return getFragment(paramCalendar, paramInt, 12);
  }
  
  public static long getFragmentInMinutes(Date paramDate, int paramInt)
  {
    return getFragment(paramDate, paramInt, 12);
  }
  
  public static long getFragmentInSeconds(Calendar paramCalendar, int paramInt)
  {
    return getFragment(paramCalendar, paramInt, 13);
  }
  
  public static long getFragmentInSeconds(Date paramDate, int paramInt)
  {
    return getFragment(paramDate, paramInt, 13);
  }
  
  private static long getMillisPerUnit(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    default: 
      throw new IllegalArgumentException("The unit " + paramInt + " cannot be represented is milleseconds");
    case 5: 
    case 6: 
      return 86400000L;
    case 11: 
      return 3600000L;
    case 12: 
      return 60000L;
    case 13: 
      return 1000L;
    }
    return 1L;
  }
  
  public static boolean isSameDay(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    if ((paramCalendar1 == null) || (paramCalendar2 == null)) {
      throw new IllegalArgumentException("The date must not be null");
    }
    return (paramCalendar1.get(0) == paramCalendar2.get(0)) && (paramCalendar1.get(1) == paramCalendar2.get(1)) && (paramCalendar1.get(6) == paramCalendar2.get(6));
  }
  
  public static boolean isSameDay(Date paramDate1, Date paramDate2)
  {
    if ((paramDate1 == null) || (paramDate2 == null)) {
      throw new IllegalArgumentException("The date must not be null");
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate1);
    paramDate1 = Calendar.getInstance();
    paramDate1.setTime(paramDate2);
    return isSameDay(localCalendar, paramDate1);
  }
  
  public static boolean isSameInstant(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    if ((paramCalendar1 == null) || (paramCalendar2 == null)) {
      throw new IllegalArgumentException("The date must not be null");
    }
    return paramCalendar1.getTime().getTime() == paramCalendar2.getTime().getTime();
  }
  
  public static boolean isSameInstant(Date paramDate1, Date paramDate2)
  {
    if ((paramDate1 == null) || (paramDate2 == null)) {
      throw new IllegalArgumentException("The date must not be null");
    }
    return paramDate1.getTime() == paramDate2.getTime();
  }
  
  public static boolean isSameLocalTime(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    if ((paramCalendar1 == null) || (paramCalendar2 == null)) {
      throw new IllegalArgumentException("The date must not be null");
    }
    return (paramCalendar1.get(14) == paramCalendar2.get(14)) && (paramCalendar1.get(13) == paramCalendar2.get(13)) && (paramCalendar1.get(12) == paramCalendar2.get(12)) && (paramCalendar1.get(11) == paramCalendar2.get(11)) && (paramCalendar1.get(6) == paramCalendar2.get(6)) && (paramCalendar1.get(1) == paramCalendar2.get(1)) && (paramCalendar1.get(0) == paramCalendar2.get(0)) && (paramCalendar1.getClass() == paramCalendar2.getClass());
  }
  
  public static Iterator<?> iterator(Object paramObject, int paramInt)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    if ((paramObject instanceof Date)) {
      return iterator((Date)paramObject, paramInt);
    }
    if ((paramObject instanceof Calendar)) {
      return iterator((Calendar)paramObject, paramInt);
    }
    throw new ClassCastException("Could not iterate based on " + paramObject);
  }
  
  public static Iterator<Calendar> iterator(Calendar paramCalendar, int paramInt)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    int k = 1;
    int m = 7;
    Calendar localCalendar2;
    Object localObject;
    int i;
    Calendar localCalendar1;
    int j;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("The range style " + paramInt + " is not valid.");
    case 5: 
    case 6: 
      paramCalendar = truncate(paramCalendar, 2);
      localCalendar2 = (Calendar)paramCalendar.clone();
      localCalendar2.add(2, 1);
      localCalendar2.add(5, -1);
      localObject = localCalendar2;
      i = m;
      localCalendar1 = paramCalendar;
      j = k;
      if (paramInt == 6)
      {
        j = 2;
        i = 1;
        localCalendar1 = paramCalendar;
        localObject = localCalendar2;
      }
      break;
    }
    for (;;)
    {
      paramInt = j;
      if (j < 1) {
        paramInt = j + 7;
      }
      j = paramInt;
      if (paramInt > 7) {
        j = paramInt - 7;
      }
      paramInt = i;
      if (i < 1) {
        paramInt = i + 7;
      }
      i = paramInt;
      if (paramInt > 7) {
        i = paramInt - 7;
      }
      while (localCalendar1.get(7) != j) {
        localCalendar1.add(5, -1);
      }
      localCalendar2 = truncate(paramCalendar, 5);
      Calendar localCalendar3 = truncate(paramCalendar, 5);
      localObject = localCalendar3;
      i = m;
      localCalendar1 = localCalendar2;
      j = k;
      switch (paramInt)
      {
      case 1: 
      default: 
        localObject = localCalendar3;
        i = m;
        localCalendar1 = localCalendar2;
        j = k;
        break;
      case 2: 
        j = 2;
        i = 1;
        localObject = localCalendar3;
        localCalendar1 = localCalendar2;
        break;
      case 3: 
        j = paramCalendar.get(7);
        i = j - 1;
        localObject = localCalendar3;
        localCalendar1 = localCalendar2;
        break;
      case 4: 
        j = paramCalendar.get(7) - 3;
        i = paramCalendar.get(7) + 3;
        localObject = localCalendar3;
        localCalendar1 = localCalendar2;
      }
    }
    while (((Calendar)localObject).get(7) != i) {
      ((Calendar)localObject).add(5, 1);
    }
    return new DateIterator(localCalendar1, (Calendar)localObject);
  }
  
  public static Iterator<Calendar> iterator(Date paramDate, int paramInt)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return iterator(localCalendar, paramInt);
  }
  
  private static void modify(Calendar paramCalendar, int paramInt1, int paramInt2)
  {
    if (paramCalendar.get(1) > 280000000) {
      throw new ArithmeticException("Calendar value too large for accurate calculations");
    }
    if (paramInt1 == 14) {
      return;
    }
    Object localObject1 = paramCalendar.getTime();
    long l2 = ((Date)localObject1).getTime();
    int i = 0;
    int j = paramCalendar.get(14);
    if (paramInt2 != 0)
    {
      l1 = l2;
      if (j >= 500) {}
    }
    else
    {
      l1 = l2 - j;
    }
    if (paramInt1 == 13) {
      i = 1;
    }
    j = paramCalendar.get(13);
    l2 = l1;
    if (i == 0) {
      if (paramInt2 != 0)
      {
        l2 = l1;
        if (j >= 30) {}
      }
      else
      {
        l2 = l1 - j * 1000L;
      }
    }
    if (paramInt1 == 12) {
      i = 1;
    }
    j = paramCalendar.get(12);
    long l1 = l2;
    if (i == 0) {
      if (paramInt2 != 0)
      {
        l1 = l2;
        if (j >= 30) {}
      }
      else
      {
        l1 = l2 - j * 60000L;
      }
    }
    if (((Date)localObject1).getTime() != l1)
    {
      ((Date)localObject1).setTime(l1);
      paramCalendar.setTime((Date)localObject1);
    }
    j = 0;
    localObject1 = fields;
    int n = localObject1.length;
    int m = 0;
    if (m < n)
    {
      Object localObject2 = localObject1[m];
      int k = localObject2.length;
      i = 0;
      for (;;)
      {
        if (i >= k) {
          break label360;
        }
        if (localObject2[i] == paramInt1)
        {
          if ((paramInt2 != 2) && ((paramInt2 != 1) || (j == 0))) {
            break;
          }
          if (paramInt1 == 1001)
          {
            if (paramCalendar.get(5) == 1)
            {
              paramCalendar.add(5, 15);
              return;
            }
            paramCalendar.add(5, -15);
            paramCalendar.add(2, 1);
            return;
          }
          if (paramInt1 == 9)
          {
            if (paramCalendar.get(11) == 0)
            {
              paramCalendar.add(11, 12);
              return;
            }
            paramCalendar.add(11, -12);
            paramCalendar.add(5, 1);
            return;
          }
          paramCalendar.add(localObject2[0], 1);
          return;
        }
        i += 1;
      }
      label360:
      i = 0;
      k = 0;
      switch (paramInt1)
      {
      default: 
        label392:
        if (k == 0)
        {
          j = paramCalendar.getActualMinimum(localObject2[0]);
          k = paramCalendar.getActualMaximum(localObject2[0]);
          i = paramCalendar.get(localObject2[0]) - j;
          if (i <= (k - j) / 2) {
            break label582;
          }
        }
        break;
      }
      label582:
      for (j = 1;; j = 0)
      {
        if (i != 0) {
          paramCalendar.set(localObject2[0], paramCalendar.get(localObject2[0]) - i);
        }
        m += 1;
        break;
        if (localObject2[0] != 5) {
          break label392;
        }
        j = paramCalendar.get(5) - 1;
        i = j;
        if (j >= 15) {
          i = j - 15;
        }
        if (i > 7) {}
        for (j = 1;; j = 0)
        {
          k = 1;
          break;
        }
        if (localObject2[0] != 11) {
          break label392;
        }
        j = paramCalendar.get(11);
        i = j;
        if (j >= 12) {
          i = j - 12;
        }
        if (i >= 6) {}
        for (j = 1;; j = 0)
        {
          k = 1;
          break;
        }
      }
    }
    throw new IllegalArgumentException("The field " + paramInt1 + " is not supported");
  }
  
  public static Date parseDate(String paramString, String... paramVarArgs)
    throws ParseException
  {
    return parseDateWithLeniency(paramString, paramVarArgs, true);
  }
  
  public static Date parseDateStrictly(String paramString, String... paramVarArgs)
    throws ParseException
  {
    return parseDateWithLeniency(paramString, paramVarArgs, false);
  }
  
  private static Date parseDateWithLeniency(String paramString, String[] paramArrayOfString, boolean paramBoolean)
    throws ParseException
  {
    if ((paramString == null) || (paramArrayOfString == null)) {
      throw new IllegalArgumentException("Date and Patterns must not be null");
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
    localSimpleDateFormat.setLenient(paramBoolean);
    ParsePosition localParsePosition = new ParsePosition(0);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str2 = paramArrayOfString[i];
      String str1 = str2;
      Object localObject = str1;
      if (str2.endsWith("ZZ")) {
        localObject = str1.substring(0, str1.length() - 1);
      }
      localSimpleDateFormat.applyPattern((String)localObject);
      localParsePosition.setIndex(0);
      str1 = paramString;
      if (str2.endsWith("ZZ")) {
        str1 = paramString.replaceAll("([-+][0-9][0-9]):([0-9][0-9])$", "$1$2");
      }
      localObject = localSimpleDateFormat.parse(str1, localParsePosition);
      if ((localObject != null) && (localParsePosition.getIndex() == str1.length())) {
        return (Date)localObject;
      }
      i += 1;
    }
    throw new ParseException("Unable to parse the date: " + paramString, -1);
  }
  
  public static Calendar round(Calendar paramCalendar, int paramInt)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    paramCalendar = (Calendar)paramCalendar.clone();
    modify(paramCalendar, paramInt, 1);
    return paramCalendar;
  }
  
  public static Date round(Object paramObject, int paramInt)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    if ((paramObject instanceof Date)) {
      return round((Date)paramObject, paramInt);
    }
    if ((paramObject instanceof Calendar)) {
      return round((Calendar)paramObject, paramInt).getTime();
    }
    throw new ClassCastException("Could not round " + paramObject);
  }
  
  public static Date round(Date paramDate, int paramInt)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    modify(localCalendar, paramInt, 1);
    return localCalendar.getTime();
  }
  
  private static Date set(Date paramDate, int paramInt1, int paramInt2)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setLenient(false);
    localCalendar.setTime(paramDate);
    localCalendar.set(paramInt1, paramInt2);
    return localCalendar.getTime();
  }
  
  public static Date setDays(Date paramDate, int paramInt)
  {
    return set(paramDate, 5, paramInt);
  }
  
  public static Date setHours(Date paramDate, int paramInt)
  {
    return set(paramDate, 11, paramInt);
  }
  
  public static Date setMilliseconds(Date paramDate, int paramInt)
  {
    return set(paramDate, 14, paramInt);
  }
  
  public static Date setMinutes(Date paramDate, int paramInt)
  {
    return set(paramDate, 12, paramInt);
  }
  
  public static Date setMonths(Date paramDate, int paramInt)
  {
    return set(paramDate, 2, paramInt);
  }
  
  public static Date setSeconds(Date paramDate, int paramInt)
  {
    return set(paramDate, 13, paramInt);
  }
  
  public static Date setYears(Date paramDate, int paramInt)
  {
    return set(paramDate, 1, paramInt);
  }
  
  public static Calendar toCalendar(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar;
  }
  
  public static Calendar truncate(Calendar paramCalendar, int paramInt)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    paramCalendar = (Calendar)paramCalendar.clone();
    modify(paramCalendar, paramInt, 0);
    return paramCalendar;
  }
  
  public static Date truncate(Object paramObject, int paramInt)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    if ((paramObject instanceof Date)) {
      return truncate((Date)paramObject, paramInt);
    }
    if ((paramObject instanceof Calendar)) {
      return truncate((Calendar)paramObject, paramInt).getTime();
    }
    throw new ClassCastException("Could not truncate " + paramObject);
  }
  
  public static Date truncate(Date paramDate, int paramInt)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("The date must not be null");
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    modify(localCalendar, paramInt, 0);
    return localCalendar.getTime();
  }
  
  public static int truncatedCompareTo(Calendar paramCalendar1, Calendar paramCalendar2, int paramInt)
  {
    return truncate(paramCalendar1, paramInt).compareTo(truncate(paramCalendar2, paramInt));
  }
  
  public static int truncatedCompareTo(Date paramDate1, Date paramDate2, int paramInt)
  {
    return truncate(paramDate1, paramInt).compareTo(truncate(paramDate2, paramInt));
  }
  
  public static boolean truncatedEquals(Calendar paramCalendar1, Calendar paramCalendar2, int paramInt)
  {
    return truncatedCompareTo(paramCalendar1, paramCalendar2, paramInt) == 0;
  }
  
  public static boolean truncatedEquals(Date paramDate1, Date paramDate2, int paramInt)
  {
    return truncatedCompareTo(paramDate1, paramDate2, paramInt) == 0;
  }
  
  static class DateIterator
    implements Iterator<Calendar>
  {
    private final Calendar endFinal;
    private final Calendar spot;
    
    DateIterator(Calendar paramCalendar1, Calendar paramCalendar2)
    {
      this.endFinal = paramCalendar2;
      this.spot = paramCalendar1;
      this.spot.add(5, -1);
    }
    
    public boolean hasNext()
    {
      return this.spot.before(this.endFinal);
    }
    
    public Calendar next()
    {
      if (this.spot.equals(this.endFinal)) {
        throw new NoSuchElementException();
      }
      this.spot.add(5, 1);
      return (Calendar)this.spot.clone();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              C:\Users\Administrator\Desktop\classes-dex2jar.jar!\org\apache\commons\lang3\time\DateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */