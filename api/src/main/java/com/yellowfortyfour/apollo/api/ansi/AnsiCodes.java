package com.yellowfortyfour.apollo.api.ansi;

public final class AnsiCodes 
{
	 
	public final static String RESET = "\u001b[0m";
	
	public class TextFgColor
	{
		public final static String RESET = "\u001b[0m";
		
		public final static String BLACK = "\u001b[30m";
		public final static String RED = "\u001b[31m";
		public final static String GREEN = "\u001b[32m";
		public final static String YELLOW = "\u001b[33m";
		public final static String BLUE = "\u001b[34m";
		public final static String MAGENTA = "\u001b[35m";
		public final static String CYAN = "\u001b[36m";
		public final static String WHITE = "\u001b[37m";
		
		public final static String BRIGHT_BLACK = "\u001b[30;1m";
		public final static String BRIGHT_RED = "\u001b[31;1m";
		public final static String BRIGHT_GREEN = "\u001b[32;1m";
		public final static String BRIGHT_YELLOW = "\u001b[33;1m";
		public final static String BRIGHT_BLUE = "\u001b[34;1m";
		public final static String BRIGHT_MAGENTA = "\u001b[35;1m";
		public final static String BRIGHT_CYAN = "\u001b[36;1m";
		public final static String BRIGHT_WHITE = "\u001b[37;1m";
		
	}
	
	public class TextBgColor
	{
		public final static String RESET = "\u001b[0m";
		
		public final static String BLACK = "\u001b[40m";
		public final static String RED = "\u001b[41m";
		public final static String GREEN = "\u001b[42m";
		public final static String YELLOW = "\u001b[43m";
		public final static String BLUE = "\u001b[44m";
		public final static String MAGENTA = "\u001b[45m";
		public final static String CYAN = "\u001b[46m";
		public final static String WHITE = "\u001b[47m";
		
		public final static String BRIGHT_BLACK = "\u001b[40;1m";
		public final static String BRIGHT_RED = "\u001b[41;1m";
		public final static String BRIGHT_GREEN = "\u001b[42;1m";
		public final static String BRIGHT_YELLOW = "\u001b[43;1m";
		public final static String BRIGHT_BLUE = "\u001b[44;1m";
		public final static String BRIGHT_MAGENTA = "\u001b[45;1m";
		public final static String BRIGHT_CYAN = "\u001b[46;1m";
		public final static String BRIGHT_WHITE = "\u001b[47;1m";
		
	}
	
	public class TextDecoration
	{
		public final static String RESET = "\u001b[0m";
		
		public final static String BOLD  = "\u001b[1m";
		public final static String Underline = "\u001b[4m";
		public final static String Reversed = "\u001b[7m";
	}
	
	public class CursorNavigation
	{
		public final static String UP = "\u001b[1A";
		public final static String DOWN = "\u001b[1B";
		public final static String RIGHT = "\u001b[1C";
		public final static String LEFT = "\u001b[1D";
		
		
		public final static String CLEAR_SCREEN_TO_END = "\u001b[0J";
		public final static String CLEAR_SCREEN_TO_START = "\u001b[1J";
		public final static String CLEAR_SCREEN = "\u001b[2J";
		
		public final static String CLEAR_LINE_TO_END = "\u001b[0K";
		public final static String CLEAR_LINE_TO_START  = "\u001b[1K";
		public final static String CLEAR_LINE = "\u001b[2K";
		
		public final static String RESET_CURSOR_POS = "\u001b[0G";
	}
}
