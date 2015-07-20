import java.io.FileWriter;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;

public class Test {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
 
         System.out.println("=======decode=======");
                
 // String s="[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
  String s="[\"0\",{\"1\":[\"2\",\"3\"]}]";
         Object obj=JSONValue.parse(s);
  JSONArray array=(JSONArray)obj;
  System.out.println("======the 2nd element of array======");
  System.out.println(array.get(0));
  System.out.println();
/*                
  JSONObject obj2=(JSONObject)array.get(1);
  System.out.println("======field \"1\"==========");
  System.out.println(obj2.get("1"));    

                
  s="{}";
  obj=JSONValue.parse(s);
  System.out.println(obj);
                
  s="[5,]";
  obj=JSONValue.parse(s);
  System.out.println(obj);
                
  s="[5,,2]";
  obj=JSONValue.parse(s);
  System.out.println(obj);*/
    }
    
}
