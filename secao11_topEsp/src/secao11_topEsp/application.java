package secao11_topEsp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class application {
	public static void main (String[] args) throws ParseException{
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Date x1 = new Date();
		Date x2 = new Date(System.currentTimeMillis());
		Date x3 = new Date(0L);
		Date x4 = new Date(1000L*60L*60L*5L);
		
		
		Date y1 = sdf1.parse("10/10/2019");
		Date y2 = sdf2.parse("10/10/2019 10:40:25");
		Date y3 = Date.from(Instant.parse("2019-10-10T10:47:56Z"));
		
		
		System.out.println("----------------------");
		System.out.println("x1: "+x1);
		System.out.println("x2: "+sdf2.format(x2));
		System.out.println("x3: "+sdf2.format(x3));
		System.out.println("----------------------");
		System.out.println("y1: "+sdf2.format(y1));
		System.out.println("y2: "+sdf2.format(y2));
		System.out.println("----------------------");
		System.out.println("x4: "+sdf2.format(x4));
		System.out.println("y3: "+sdf2.format(y3));
		System.out.println("y3: "+sdf3.format(y3));
		
		
		//Calendar (geralmente sistemas legado)
		System.out.println("----------------------");
		
		SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date d = Date.from(Instant.parse("2019-10-10T10:54:45Z"));//horário de Greenwich
		
		System.out.println(sdf4.format(d));// retorna valor do Brasil em relação ao que foi passado para Greenwich
		
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.HOUR_OF_DAY, 4); //acrescentando horas no dia
		d = cal.getTime();
		
		System.out.println(sdf4.format(d));
		
		int min = cal.get(Calendar.MINUTE);
		int month = 1 + cal.get(Calendar.MONTH);
		
		System.out.println("Minutos: "+min);
		System.out.println("Mês: "+month);
		
	}
}
