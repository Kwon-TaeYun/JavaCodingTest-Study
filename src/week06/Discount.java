package week06;

import java.util.HashMap;

public class Discount {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> products = new HashMap<>();
        HashMap<String, Integer> discountProducts = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            products.put(want[i], number[i]);
        }
        System.out.println(products);
        for(int i = 0; i < 10; i++){
            discountProducts.put(discount[i], discountProducts.getOrDefault(discount[i], 0) + 1);
        }

        if(discountProducts.equals(products)){
            answer += 1;
        }

        for(int i = 10; i < discount.length; i++){
            String removeProduct = discount[i-10];
            if(discountProducts.containsKey(removeProduct)) {
                if (discountProducts.get(removeProduct) - 1 == 0) {
                    discountProducts.remove(removeProduct);
                } else {
                    discountProducts.put(removeProduct, discountProducts.get(removeProduct) - 1);
                }
            }
            String addProduct = discount[i];
            discountProducts.put(addProduct, discountProducts.getOrDefault(addProduct, 0) + 1);
            //System.out.println("remove" + discountProducts);
            if(products.equals(discountProducts)){
                answer+=1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        int output = solution(want, number, discount);
        System.out.println(output);
    }
}
