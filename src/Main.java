import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] input = {22, 33, 44, 55, 55, 55, 2, 3, 5, 5};
        System.out.println(findMostFrequent(input));
    }
    
    //    pradinis masyvas, su skaičiais, turi surasti, kuris iš tų skaičių dažniausiai kartojasi
//    ir grąžinti to skaičiaus indeksą pradiniame masyve
//    pvz int[] input = {1, 3, 4, 5, 3, 6, 3}, tai turi grąžinti 6
//    paskutinę jo vietą pradiniame masyve
//    int[] input = {1, 2, 3} -1 turėtų grąžinti
    public static int findMostFrequent(int[] input) {
        if (input.length == 0) return -1;
        int maxCount = 0, maxIndex = -1;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int value = input[i];
            int count = counts.getOrDefault(value, 0) + 1;
            counts.put(value, count);
            if (count > maxCount) {
                maxCount = count;
                maxIndex = i;
            }
        }
        if (maxIndex == 0) return -1;
        return maxIndex;
//One-liner
//return IntStream.range(0, input.length).reduce((i, j) -> input[i] == input[j] ? j : (input[i] > input[j] ? i : j)).orElse(-1);
//Mano variantas
//        int max = 0;
//        int maxIndex = -1;
//        Map<Integer, Integer> map = new HashMap<>();
//        Map<Integer, Integer> indexMap = new HashMap<>();
//
//        for (int i = 0; i < input.length; i++) {
//            int key = input[i];
//            if (map.containsKey(key)) {
//                int count = map.get(key);
//                map.put(key, ++count);
//            } else {
//                map.put(key, 1);
//                indexMap.put(key, i);
//            }
//        }
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            int key = entry.getKey();
//            int value = entry.getValue();
//            if (value > max) {
//                max = value;
//                maxIndex = indexMap.get(key);
//            }
//        }
//        if (maxIndex == 0) return -1;
//        return maxIndex;
    }
}

