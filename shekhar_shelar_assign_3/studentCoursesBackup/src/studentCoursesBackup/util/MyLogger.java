package studentCoursesBackup.util;

public class MyLogger {

	// FIXME: Add more enum values as needed for the assignment
    public static enum DebugLevel { CONSTRUCTOR, FILE_PROCESSOR, CLONNING, CHANGEINPOOL,
                                   NONE};

    private static DebugLevel debugLevel;


    // FIXME: Add switch cases for all the levels
    public static void setDebugValue (int levelIn) {

    	switch (levelIn) {
    	    case 4: debugLevel = DebugLevel.CHANGEINPOOL; break;
    	    case 3: debugLevel = DebugLevel.CLONNING; break;
    		case 2: debugLevel = DebugLevel.CONSTRUCTOR; break;
			case 1: debugLevel = DebugLevel.FILE_PROCESSOR; break;
			default: debugLevel = DebugLevel.NONE; break;
    	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
    	debugLevel = levelIn;
    }

    public static void writeMessage (String message, DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    @Override
    public String toString() {
	return "The debug level has been set to the following " + debugLevel;
    }
    
}
