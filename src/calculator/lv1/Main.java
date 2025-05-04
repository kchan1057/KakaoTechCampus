package calculator.lv1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            int result = 0;
            System.out.print("첫 번째 숫자를 입력하세요: "); int first = scanner.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: "); char op = scanner.next().charAt(0);
            if(op !=  '+' && op != '-' && op != '*' && op != '/'){
                System.out.print("잘못된 기호입니다.\n사칙연산 기호를 입력하세요: ");
                op = scanner.next().charAt(0);
            }
            System.out.print("두 번째 숫자를 입력하세요: "); int second = scanner.nextInt();

           try{
               if(op == '+'){
                   result = first + second;
                   System.out.println("결과: " + result);
               } else if(op == '-'){
                   result = first - second;
                   System.out.println("결과: " + result);
               } else if(op == '*'){
                   result = first * second;
                   System.out.println("결과: " + result);
               } else if(op == '/'){
                   result = first / second;
                   System.out.println("결과: " + result);
               }
           }catch(ArithmeticException e){
               System.out.println("0으로 나눌 수 없습니다. 처음부터 다시 입력하시오.");
               continue;
           }
            System.out.print("더 계산하시겠습니까? (Y/Exit) "); String cont = scanner.next();
            if(cont.equals("Exit")) break;
        }
    }
}
