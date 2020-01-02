package com.ac.mylib.java.collection;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang.StringEscapeUtils;

import java.util.HashMap;

public class MyHashMap {
    public static void main(String[] args) {
//        HashMap<String, String> map = new HashMap<>();
//        System.out.println(map.size());
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();

        map.put("key1", "value1");

        map.put("key1", "value2");
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
