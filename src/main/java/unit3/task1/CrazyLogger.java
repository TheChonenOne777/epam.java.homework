package unit3.task1;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.*;
import java.util.regex.Pattern;

public class CrazyLogger {

    private StringBuilder logContainer;
    private static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy : HH-mm");
    private static Date date;

    private CrazyLogger(){
        logContainer = new StringBuilder();
    }

    public static CrazyLogger getCrazyLogger(){
        return new CrazyLogger();
    }

    public StringBuilder getLogContainer() {
        return logContainer;
    }

    public void writeLog(String message){
        if(!"".equals(message)){

            date = new Date();
            logContainer.append("\n" + dateFormat.format(date) + " - " + message);

        }
    }

    public List<String> findLogMessages(String phrase){
        List<String> output = new ArrayList<>();
        Pattern messageBreaker = Pattern.compile("\\n[012][0-9]-[01][0-9]-[\\d]{4}\\s:\\s[0-5][0-9]-[0-5][0-9]\\s-\\s");

        for(String message : messageBreaker.split(logContainer)){
            if(message.contains(phrase)){
                output.add(message);
            }
        }

        return output;
    }

    public static void main(String[] args) {

        CrazyLogger cl = CrazyLogger.getCrazyLogger();

        cl.writeLog("first message");
        cl.writeLog("second message");
        cl.writeLog("lalala");

        System.out.println(cl.getLogContainer());

        System.out.println(cl.findLogMessages("message"));

    }
}
