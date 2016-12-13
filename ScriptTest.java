import com.hand.hap.hr.dto.HrOrgUnit;
import com.hand.hap.script.service.IScriptService;
import com.hand.hap.script.service.impl.ScriptServiceImpl;
import org.junit.Test;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ScriptTest {
    @Test
    public void test() throws Exception {
        IScriptService iScriptService = new ScriptServiceImpl();
        FileReader reader = new FileReader("E:\\learngit\\ex.js");
        String script = "print(\"nashorn\");\n" +
                "org.setName(\"i am script\");\n" +
                "var orgName = org.getName();\n" +
                "print(orgName);\n" +
                "\n" +
                "var dataSource = applicationContext.getBean(\"dataSource\");\n";
        HrOrgUnit org = new HrOrgUnit();
        Map<String, Object> map = new HashMap<>();
        map.put("org", org);
        iScriptService.execute("ex.js",reader,map);
    }
}