package com.yellowfortyfour.apollo.logger;

import com.yellowfortyfour.apollo.api.ansi.*;

import java.sql.Time;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;


public final class LogFormatter extends Formatter
{
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    @Override
    public String format(LogRecord record) 
    {
		StringBuilder sb = new StringBuilder();
		
		String prefixColor = "";
		String sufixColor = AnsiCodes.RESET;
		if(record.getLevel() == Level.INFO)
		{
			prefixColor = AnsiCodes.TextFgColor.BRIGHT_BLUE;
		}
		else if(record.getLevel() == Level.SEVERE)
		{
			prefixColor = AnsiCodes.TextFgColor.BRIGHT_RED;
		}
		else if(record.getLevel() == Level.WARNING)
		{
			prefixColor = AnsiCodes.TextFgColor.BRIGHT_YELLOW;
		}
			
		sb.append("[" + prefixColor + new Time(record.getMillis()) + " " + record.getLevel().getLocalizedName() + sufixColor + "]: ");
		sb.append(record.getMessage());
		sb.append(LINE_SEPARATOR);
		 
		return  sb.toString();
    }

}