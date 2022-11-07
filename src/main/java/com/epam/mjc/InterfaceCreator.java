package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return result -> result.stream().allMatch(element -> element.startsWith(element.toUpperCase()));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return result -> result.addAll(result.stream().filter(element -> element % 2 == 0).collect(Collectors.toList()));
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();
            for (String element : values) {
                boolean a = Character.isUpperCase(element.charAt(0));
                boolean b = element.endsWith(".");
                boolean c = element.split(" ").length > 3;
                if (a && b && c) {
                    list.add(element);
                }
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return result -> {
            Map<String, Integer> stringIntegerMap = new HashMap<>();
            for (String element : result) {
                stringIntegerMap.put(element,element.length());
            }
            return stringIntegerMap;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toList());
    }
}
