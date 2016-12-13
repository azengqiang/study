import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by win on 2016/12/8.
 */
public class demo {
    private static ScriptEngineManager sem = new ScriptEngineManager();
    private static ScriptEngine engine = sem.getEngineByName("Nashorn");
    public static  void  main(String arg[]){
        try {
            FileReader reader = new FileReader("E:\\learngit\\ex.js");
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            Map<String,String> map = new HashMap<>();
            //addKeyToScriptEngine(reader, "out", printWriter);
            addKeyToScriptEngine(reader, "map", map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void addKeyToScriptEngine(Reader reader, String key,Object value) {
        if(null==reader){
            System.out.println("脚本为空");
            return;
        }
        engine.put(key,value);
        try {
            engine.eval(reader);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

    }
}
