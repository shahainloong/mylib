package com.ac.mylib.java.collection;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang.StringEscapeUtils;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>(16);
        System.out.println("Lee".hashCode());
//        System.out.println(map.size());
//        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
//
//        map.put("key1", "value1");
//
//        map.put("key1", "value2");
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("张无忌", "明教");
        map.put("赵敏", "朝廷");
        map.put("周芷若", "峨嵋派");
        map.put("小昭", "波斯总教");
        map.put("谢逊", "明教");
        map.put("张三丰", "武当派");
        map.put("殷素素", "天鹰教");
        map.put("空见", "少林");
//        map.put("空见1", "少林");
//        map.put("空见2", "少林");
//        map.put("空见3", "少林");
//        map.put("空见4", "少林");
//        map.put("空见5", "少林");
//        map.put("空见6", "少林");
//        map.put("空见7", "少林");
//        map.put("空见8", "少林");
//        map.put("空见9", "少林");
//        map.put("空见10", "少林");
//        map.put("空见11", "少林");
//        map.put("空见12", "少林");
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println(map);

        System.out.println("=\"");
        String sql="1' or '1'='1";
        System.out.println("防SQL注入:"+StringEscapeUtils.escapeSql(sql)); //防SQL注入

        System.out.println("转义HTML,注意汉字:"+StringEscapeUtils.escapeHtml("<img src=\"\" onerror=\"alert(4)\">"));    //转义HTML,注意汉字
        System.out.println("反转义HTML:"+StringEscapeUtils.unescapeHtml("&amp;lt;<&lt;p&gt;&lt;img src=&quot;&quot; onerror=&quot;alert(4)&quot;&gt;&lt;/img&gt;&lt;/p&gt;"));  //反转义HTML

        System.out.println("转成Unicode编码："+StringEscapeUtils.escapeJava("陈磊兴"));     //转义成Unicode编码

        System.out.println("转义XML："+StringEscapeUtils.escapeXml("<name>陈磊兴</name>"));   //转义xml
        System.out.println("反转义XML："+StringEscapeUtils.unescapeXml("&lt;name&gt;&#38472;&#30922;&#20852;&lt;/name&gt;"));    //转义xml

    }
}
