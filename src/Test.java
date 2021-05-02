import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {


    //    输入一个字符串，打印出该字符串中字符的所有排列。
//
//
//
//    你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
   public static void main(String[] args){

       Field[] fields = TestType.class.getFields();
       for (Field field : fields) {
           field.setAccessible(true);

       }


   }


   static class TestType{

       List<List<String>> list;

   }
}
