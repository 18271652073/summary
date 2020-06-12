package com.test.summary;

import com.alibaba.fastjson.JSON;
import com.test.summary.dom.kafka.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author Administrator
 * @date 2020/4/27.
 */
public class TestMain {

//    public static void main(String[] args) {
////        List<Message> list = new ArrayList<>();
////        Message message1 = new Message();
////        Message message2 = new Message();
////        Message message3 = new Message();
//////        message1.setId("1");
//////        message1.setMsg("test1");
//////        message2.setId("2");
//////        message2.setMsg("test2");
////        list.add(message1);
////        list.add(message2);
////        list.add(message3);
//////        Map<String, Message> map = list.stream().collect(Collectors.toMap(Message::getId, Function.identity()));
////        List<String> collect = list.stream().map(Message::getId).collect(Collectors.toList());
////        for (String i : collect) {
////            System.out.println(i);//当list为空输出就为空
////        }
////        System.out.println("111111");
//////        System.out.println(map);
//
//
//
//        String content = "0713-1234567";
//        String content1 = "17131234567";
//        String content4 = "test";
//        String content2 = "I am noob " + "from runoob.com.";
//        String pattern = "^\\d{4}\\-?\\d{7}$";
//        boolean isMatch = Pattern.matches(pattern, content);
//        boolean isMatch1 = Pattern.matches(pattern, content1);
//        boolean isMatch2 = Pattern.matches(pattern, content2);
//        System.out.println(isMatch);
//        System.out.println(isMatch1);
//        System.out.println(isMatch2);
//    }
//    public static String subZeroBefore(String str) {
//        String newStr = str.replaceAll("^(0+)", "");
//        return newStr;
//    }

    public static void main(String[] args) {

        Map<String, String> h1 = new HashMap<>();
        h1.put("12", "fdsa");
        Map<String, String> h2 = new HashMap<>();
        h2.put("h12", "fdsa");
        Map<String, String> h3 = new HashMap<>();
        h3.put("h12", "fdsa");
        Map<String, String> h4 = new HashMap<>();
        h4.put("12", "fd");

        List<Map<String, String>> lists = new ArrayList<>();
        lists.add(h1);
        lists.add(h2);
        lists.add(h3);
        lists.add(h4);

        Map<String, List<String>> matting = lists.stream().flatMap(m -> m.entrySet().stream())
                        .collect(groupingBy(Map.Entry::getKey, mapping(Map.Entry::getValue, toList())));
        System.out.println(JSON.toJSONString(matting));

    }
}
