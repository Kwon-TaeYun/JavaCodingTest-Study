package week01.배열의평균값;

public class SortAvg {
    public static double solution(int[] numbers) {
        double answer = 0;
        for (int number : numbers) {
            answer += number;
        }
        answer = answer / numbers.length;
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
        System.out.println(solution(numbers));
    }
}
