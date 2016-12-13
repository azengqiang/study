
import javax.script.*;
import java.io.FileReader;

/**
 * Created by win on 2016/12/8.
 */
public class Nashorn {
    public static  void  main(String arg[]){
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        try {
            nashorn.eval(new FileReader("sample.js"));
            System.out.println("--------------"aaaa);
            Compilable compilable = (Compilable) nashorn;
            Bindings bindings = nashorn.createBindings();
            String script = "function add(op1,op2){return op1+op2} add(a, b)";
            CompiledScript JSFunction = compilable.compile(script);
            bindings.put("a", 1);bindings.put("b", 2);
            Object result = JSFunction.eval(bindings);
            System.out.println(result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
