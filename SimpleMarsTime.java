import java.util.*;
import java.text.*;

// Useful sites:
// http://www.universetoday.com/14717/how-long-is-a-day-on-mars/
// http://jtauber.github.io/mars-clock/
// https://github.com/jtauber/mars-clock/blob/gh-pages/index.html
// https://en.wikipedia.org/wiki/Timekeeping_on_Mars
public class SimpleMarsTime
{
  // Length of Mars day in milliseconds (88,775.244147 seconds, or 24h 39m 35.244147s)
  private static final long MARS_DAY = 88775244;
  private static final String DEFAULT_FORMAT = "dd MMM yyyy HH:mm:ss";

  private SimpleDateFormat dateFormat;

  public static void main( String[] args )
  {
    SimpleMarsTime marsTime = new SimpleMarsTime();
    long time = marsTime.parse( "1 Jan 2017 00:00:00" );
    marsTime.run( time );
  }

  public long parse( String aDateTimeString )
  {
    try
    {
      dateFormat = new SimpleDateFormat( DEFAULT_FORMAT );
      dateFormat.setTimeZone( TimeZone.getTimeZone( "GMT" ) );
      return dateFormat.parse( aDateTimeString ).getTime();
    }
    catch ( Exception e )
    {
      System.err.println( "Exception in date parse \"" + aDateTimeString + "\". " + e );
      return 0;
    }
  }

  public void run( long aTime )
  {
    long currentTime = System.currentTimeMillis();
    long diff = currentTime - aTime;
    long days = diff / MARS_DAY;
    long timeOfDay = diff % MARS_DAY;

    System.out.println( "Based on epoch " + dateFormat.format( aTime ) +
        " and current time on Earth " + dateFormat.format( currentTime ) +
        ", time on Mars is " + TimeUtils.outputTimeOfDay( timeOfDay, 25 ) );
  }

}

