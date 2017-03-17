public class TimeUtils
{
  public static long secondsToMillis( int aSeconds )
  {
    return aSeconds * 1000;
  }

  public static long minutesToMillis( int aMinutes )
  {
    return aMinutes * secondsToMillis( 60 );
  }

  public static long hoursToMillis( int aHours )
  {
    return aHours * minutesToMillis( 60 );
  }
  
  public static long daysToMillis( int aDays )
  {
    return aDays * hoursToMillis( 24 );
  }

  public static long millisToSeconds( long aMillis )
  {
    return aMillis / 1000;
  }

  public static long millisToMinutes( long aMillis )
  {
    return aMillis / ( 60 * 1000 );
  }

  public static long millisToHours( long aMillis )
  {
    return aMillis / ( 60 * 60 * 1000 );
  }

  public static long millisToDays( long aMillis )
  {
    return aMillis / ( 24 * 60 * 60 * 1000 );
  }

  public static long secondsInMinute( long aMillis )
  {
    return millisToSeconds( aMillis ) % 60;
  }

  public static long minutesInHour( long aMillis )
  {
    return millisToMinutes( aMillis ) % 60;
  }

  public static long hoursInDay( long aMillis )
  {
    // Assume 24 hour Earth day.
    return hoursInDay( aMillis, 24 );
  }

  public static long hoursInDay( long aMillis, int aNumberOfHoursInDay )
  {
    return millisToHours( aMillis ) % aNumberOfHoursInDay;
  }

  private static String formatMillis( long aMillis )
  {
    String result = "";
    if ( aMillis >= 100 )
    {
      result += aMillis;
    }
    else if ( aMillis >= 10 )
    {
      result += "0" + aMillis;
    }
    else
    {
      result += "00" + aMillis;
    }

    return result;
  }

  public static String outputTimeOfDay(
      long aDayTimeInMillis, int aNumberOfHoursInDay, boolean aIncludeMilliseconds )
  {
    long hours = hoursInDay( aDayTimeInMillis, aNumberOfHoursInDay );
    long minutes = minutesInHour( aDayTimeInMillis );
    long seconds = secondsInMinute( aDayTimeInMillis );
    long millis = aDayTimeInMillis % 1000;
    if ( aIncludeMilliseconds )
    {
      String millisString = formatMillis( millis );
      return ( hours < 10 ? "0" + hours : hours ) + ":" +
          ( minutes < 10 ? "0" + minutes : minutes ) + ":" +
          ( seconds < 10 ? "0" + seconds : seconds ) + "." + millisString;
    }
    else
    {
      return ( hours < 10 ? "0" + hours : hours ) + ":" +
          ( minutes < 10 ? "0" + minutes : minutes ) + ":" +
          ( seconds < 10 ? "0" + seconds : seconds );
    }
  }

  public static String outputTimeOfDay( long aDayTimeInMillis, int aNumberOfHoursInDay )
  {
    return outputTimeOfDay( aDayTimeInMillis, aNumberOfHoursInDay, false );
  }
}

