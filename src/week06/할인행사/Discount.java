package week06.할인행사;

import java.util.HashMap;

public class Discount {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> products = new HashMap<>();
        HashMap<String, Integer> discountProducts = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            products.put(want[i], number[i]);
        } //want 목록 다 넣어줌.
        System.out.println(products);
        for(int i = 0; i < 10; i++){
            discountProducts.put(discount[i], discountProducts.getOrDefault(discount[i], 0) + 1);
        }//discount의 목록 중 10개만 넣어줌.

        if(discountProducts.equals(products)){
            answer += 1;
        }//지금까지 넣은 products와 discountProducts를 비교하여 같으면 +1

        //제일 처음 인덱스 1~10 비교, 2~11 비교처럼 하나씩 차례대로 비교
        for(int i = 10; i < discount.length; i++){
            String removeProduct = discount[i-10];
            if(discountProducts.containsKey(removeProduct)) {
                if (discountProducts.get(removeProduct) - 1 == 0) {
                    discountProducts.remove(removeProduct);
                } else {
                    discountProducts.put(removeProduct, discountProducts.get(removeProduct) - 1);
                }
            }//removeProduct이 제일 첫번째로 넣은 상품 -> 빼줌. 빼고 없으면 리스트에서 제거

            String addProduct = discount[i];
            discountProducts.put(addProduct, discountProducts.getOrDefault(addProduct, 0) + 1);
            //discountProducts의 마지막 상품 추가

            //System.out.println("remove" + discountProducts);
            if(products.equals(discountProducts)){
                answer+=1;
            }//계속 sliding window 방식으로 비교해가면서 같으면 +1
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
