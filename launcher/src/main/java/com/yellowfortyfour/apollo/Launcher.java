package com.yellowfortyfour.apollo;

import com.yellowfortyfour.apollo.api.ansi.*;

import java.io.IOException;

public class Launcher 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println("\n  --- Prometheus Project started --" );
        System.out.println(  "   The Apollo interface is loading  \n" );
    

        String prompt = AnsiCodes.CursorNavigation.CLEAR_LINE + AnsiCodes.CursorNavigation.RESET_CURSOR_POS + "-> ";
        PluginManager ph = new PluginManager();
        
        String line;
        while(!(line = ph.getConsoleReader().readLine(prompt)).equals("stop") && ph.isRunning() == true)
        {
            ph.dispatchCommand(line);
        }
        ph.shutDown(); 
    }
}
