package pl.mk.AccentureTest;

import java.util.*;

public class Exercise {

    public static List<Integer> findDuplicates(List<Integer> integerList, int numberOfDuplicates){
        if (integerList.size() == 0)
            return Collections.emptyList();
        if(numberOfDuplicates <= 0)
            throw new IllegalArgumentException("Chosen variable to number of dupicates must be greater than 0 and cannot be null. Please try once again.");

        List<Integer> integerListCopy = new ArrayList<>(integerList);            //I don't want to change original list, so I create a copy
        Collections.sort(integerListCopy);

        Map<Integer, Integer> mapOfList = new HashMap<>();
        int counter = 1;
        for (int i = 1; i <= integerListCopy.size(); i++) {
            if(i == integerListCopy.size()){
                mapOfList.put(integerListCopy.get(i - 1), counter);       //I must also handle last element of the list (i-1)
                break;
            }

            if (integerListCopy.get(i).equals(integerListCopy.get(i - 1))) {
                counter++;
                continue;
            }
            mapOfList.put(integerListCopy.get(i - 1), counter);
            counter = 1;
        }

        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mapOfList.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == numberOfDuplicates) {
                resultList.add(key);
            }
        }

        return resultList.size() > 0 ? resultList : Collections.emptyList();

    }

}
