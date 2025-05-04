package calculator.lv3;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    //속성
    private List<Double> results;

    //생성자
    public ArithmeticCalculator(){results = new ArrayList<>();}

    // 1. 계산 기능
    public double calculate(T first, OperatorType op, T second) {
        double a = first.doubleValue();
        double b = second.doubleValue();
        double result = 0;

        if (op == OperatorType.ADD) result = a + b;
        else if (op == OperatorType.SUBTRACT) result = a - b;
        else if (op == OperatorType.MULTIPLY) result = a * b;
        else if (op == OperatorType.DIVIDE) {
            if (b == 0.0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
            result = a / b;
        }
        results.add(result);
        return result;
    }


    // 2. 삭제 기능
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
            System.out.println("가장 오래된 결과 값을 삭제하였습니다.");
        } else System.out.println("삭제할 결과 값이 존재하지 않습니다.");
    }

    // 3. 입력값 비교 기능
    public List<Double> getGreatorValue(double value){
        return results.stream()
                .filter(r -> r > value)
                .collect(Collectors.toList());
    }

    //게터
    public ArrayList<Double> getResults() {return new ArrayList<>(results);}

    //세터
    public void setResults(ArrayList<Double> results){this.results = results;}
}
