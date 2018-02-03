package com.yellowfortyfour.apollo.logger;

import com.yellowfortyfour.apollo.api.ansi.*;

import java.io.IOException;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import jline.console.ConsoleReader;

public class LogHandler extends Handler
{
    private final ConsoleReader console;

    public LogHandler(ConsoleReader console)
    {
        this.console = console;
    }

    public void print(String s)
    {   
        try
        {
            console.print(AnsiCodes.CursorNavigation.CLEAR_LINE + AnsiCodes.CursorNavigation.RESET_CURSOR_POS + s);
        	console.drawLine();
            console.flush();
        } 
        catch(IOException e)
        {
        	e.printStackTrace();
        }
    }

    @Override
    public void publish(LogRecord record)
    {
        if ( isLoggable(record))
        {
            print(getFormatter().format(record));
        }
    }

    @Override
    public void flush()
    {
    }

    @Override
    public void close() throws SecurityException
    {
        
    }
}


