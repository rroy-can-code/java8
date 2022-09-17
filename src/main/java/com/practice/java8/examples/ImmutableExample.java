package com.practice.java8.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImmutableExample {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "first");
        map.put("2", "second");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Music");
        hobbies.add("Cricket");
        Student s = new Student("Rahul", 101, map, hobbies);
        System.out.println(s.getName());
        System.out.println(s.getRegNo());
        System.out.println(s.getMetadata());
        System.out.println(s.getAdditionalParams());

        map.put("3", "third");
        System.out.println(s.getMetadata());
        s.getMetadata().put("4", "fourth");
        System.out.println(s.getMetadata());
        hobbies.add("Football");
        hobbies.add("Chess");

        System.out.println(s.getAdditionalParams());
    }

    final static class Student {
        private final String name;
        private final int regNo;
        private final Map<String, String> metadata;
        private final List<String> additionalParams;

        public Student(String name, int regNo,
                       Map<String, String> metadata, List<String> additionalParams) {
            this.name = name;
            this.regNo = regNo;
            Map<String, String> tempMap = new HashMap<>();
            for (Map.Entry<String, String> entry :
                    metadata.entrySet()) {
                tempMap.put(entry.getKey(), entry.getValue());
            }
            this.metadata = tempMap;
            List<String> tempList = new ArrayList<>();
            tempList.addAll(additionalParams);
            this.additionalParams = tempList;
        }

        public String getName() {
            return name;
        }

        public int getRegNo() {
            return regNo;
        }
        public Map<String, String> getMetadata() {
            Map<String, String> tempMap = new HashMap<>();
            for (Map.Entry<String, String> entry :
                    this.metadata.entrySet()) {
                tempMap.put(entry.getKey(), entry.getValue());
            }
            return tempMap;
        }
        public List<String> getAdditionalParams() {
            List<String> params = new ArrayList<>();
            for (String elt : additionalParams) {
                params.add(elt);
            }
            return params;
        }
    }


}
