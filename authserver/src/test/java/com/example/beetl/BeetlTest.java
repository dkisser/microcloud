package com.example.beetl;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WenChen on 2019/6/24.
 */
public class BeetlTest {

    @Test
    public void testBeetlString () throws IOException {
        StringTemplateResourceLoader loader = new StringTemplateResourceLoader();
        Configuration config = Configuration.defaultConfiguration();
        GroupTemplate template = new GroupTemplate(loader,config);
        String testTemplate = "<html>\n" +
                "<head>\n" +
                "\t<title>${title}</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<h1>${name}</h1>\n" +
                "<%" +
                " for(entry in map){" +
                "   print(entry.key+\":\"+entry.value);}%>"+
                "</body>\n" +
                "</html>";
        Template tpl = template.getTemplate(testTemplate);
        tpl.binding("title","This is a test Title");
        tpl.binding("name","testName");
        Map<String,String> map = new HashMap<>();
        map.put("aaa","111");
        map.put("bbb","222");
        tpl.binding("map",map);
        String str = tpl.render();
        System.out.println(str);
    }

}
