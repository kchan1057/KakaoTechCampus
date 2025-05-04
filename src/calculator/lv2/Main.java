package calculator.lv2;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while(true){
            System.out.print("첫 번째 숫자를 입력하세요: "); int first = scanner.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: "); char op;
            while(true){
                op = scanner.next().charAt(0);
                if(op !=  '+' && op != '-' && op != '*' && op != '/'){
                    System.out.println("잘못된 기호입니다.\n 사칙연산 기호를 입력하세요: ");
                    op = scanner.next().charAt(0);
                }else break;
            }
            System.out.print("두 번째 숫자를 입력하세요: "); int second = scanner.nextInt();

            try{
                int result = calculator.calculate(first, op, second);
                System.out.println("결과: " + result);
            } catch(ArithmeticException e){
                System.out.println("0으로 나눌 수 없습니다. 처음부터 다시 입력하시오.");
                continue;
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)"); String cont = scanner.next();
            if(cont.equals("exit")){break;}

            System.out.print("가장 오래된 결과 값을 삭제하시겠습니까?(Y/N)"); char what = scanner.next().charAt(0);
            if(what == 'Y') {
                calculator.removeResult();
                System.out.println("현재 저장된 결과 값은: " + calculator.getResults());
            } else System.out.println("현재 저장된 결과 값은: " + calculator.getResults());
        }
    }
}
