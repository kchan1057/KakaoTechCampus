package calculator.lv3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while(true){
            System.out.print("첫 번째 숫자를 입력하세요: "); double first = scanner.nextDouble();

            OperatorType op;
            while(true){
                System.out.print("사칙연산 기호를 입력하세요: ");
                char inputOp;
                while(true){
                    inputOp = scanner.next().charAt(0);
                    if(inputOp != '+' && inputOp != '-' && inputOp != '*' && inputOp != '/'){
                        System.out.print("잘못된 기호입니다.\n사칙연산 기호를 입력하세요: ");
                    } else break;
                }
                op = OperatorType.findOp(inputOp);
                break;
            }
            System.out.print("두 번째 숫자를 입력하세요: "); double second = scanner.nextDouble();

            try{
                double result = calculator.calculate(first, op, second);
                System.out.println("결과: " + result);
            } catch(ArithmeticException e){
                System.out.println("0으로 나눌 수 없습니다. 처음부터 다시 입력하시오.");
                continue;
            }
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)"); String cont = scanner.next();
            if(cont.equals("exit")){break;}

            System.out.print("가장 오래된 결과 값을 삭제하시겠습니까?(Y/N) "); char what1 = scanner.next().charAt(0);
            if(what1 == 'Y') {
                calculator.removeResult();
                System.out.println("현재 저장된 결과 값은: " + calculator.getResults());
            } else System.out.println("현재 저장된 결과 값은: " + calculator.getResults());

            System.out.print("Scanner로 입력받은 값보다 큰 결과값들을 출력하시겠습니까?(Y/N): "); char what2 = scanner.next().charAt(0);
            if(what2 == 'Y'){
                System.out.print("기준 값을 입력해주세요: "); double value = scanner.nextDouble();
                System.out.println(calculator.getGreatorValue(value));
            }
        }
    }
}
