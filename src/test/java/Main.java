import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Main {
    public static void main(String... args) {
        // Типы данных
        // логический
        boolean varBoolean = false;
        // целочисленные
        byte varByte = 100; // -128 ... 127  (-2 ^ 7 ... (2 ^ 7) -1)
        short varShort = 1000; // -321768  ... 321767
        int varInt = 100_000_000;
        long varLong = 0L;
        // символ (под капотом тоже число)
        char varChar = 'f';
        //  числа с плавающей точкой
        float varFloat = 0.0F;
        double varDouble0 = 36.0;
        String varString0 = "Selenide";
        String varString1 = "Selenide";

        int coinNominal = 3;
        String coinCurrency = "RUB";

        // Операторы
        // Операторы математические
        int result = 10;
        result = result + 1;
        result += 1;
        result = ++result;

        // Операторы сравнения
        // > < >= <= == !=

        // Логические операторы
        // && || !, ^
        if (coinCurrency.equals("RUB")) {
            System.out.println("Это рубль!");
        } else if (coinCurrency.equals("USD")) {
            System.out.println("Это долар!");
        } else {
            System.out.println("Ничего не подошло");
        }

        switch (coinCurrency) {
            case "RUB": {
                System.out.println("Это рубль!");
                break;
            }
            case "USD": {
                System.out.println("Это долар!");
                break;
            }
            default: {
                System.out.println("Ничего не подошло");
            }
        }
        String[]arraySt = new String[]{"dima", "sasha","vasya"};

        int[] array0 = {100, 1500, -1, 90};
        int[] array1 = {100, 1500, -1, 90};
        System.out.println(array0[1]);

        for (int i = 0; i < array0.length; i++){
            System.out.println(array0[i]);
        }

        int[][] array2 = {array0, array1};

        int index = 0;
        while (index < array0.length){
            System.out.println(array0[index]);
            index++;
        }
        for (int var: array1){
            System.out.println(var);
        }
        // обртный цикл
        for(int i = array1.length - 1; i >= 0; i--){
            System.out.println(array1[i]);
        }

        for (int i = 0; i < array0.length; i++){
            if (array0[i] != -1){
                continue;
            }
            System.out.println("нашли -1" + array0[i]);
            break;
        }

        List<String> stringList = new ArrayList<>();
        stringList.add("Dima");
        stringList.addAll(Arrays.asList("sdf","dsdf"));
        stringList.get(2);
        stringList.remove("Dima");
        stringList.indexOf("sdf");

        for (String var: stringList){
            System.out.println(var);
        }

        Map<Integer, Human> aMap = new HashMap<>();
        aMap.put(3434343, new Human("Dima", 33, "M"));
        aMap.put(2342323, new Human("Petr", 30, "M"));
        aMap.put(4535355, new Human("Ivan", 20, "M"));

        Set<Integer> passportNumbers = aMap.keySet();
        Collection<Human> humans = aMap.values();
        Set<Map.Entry<Integer, Human>> entrySet = aMap.entrySet();

        for (Map.Entry<Integer, Human> entry : entrySet) {
            if (entry.getKey() == 2342323) {
                System.out.println("Нашли Петра: " + entry.getValue().getName());
            }
        }




    }
}