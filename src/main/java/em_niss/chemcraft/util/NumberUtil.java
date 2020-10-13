package em_niss.chemcraft.util;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberUtil
{
	public static String CommaSeparateNumber(long number)
	{
		String out = NumberFormat.getInstance(Locale.US).format(number);
		return out;
	}
}
