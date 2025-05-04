    package calculator.lv2;

    import java.util.ArrayList;
    public class Calculator {

        //속성
        private ArrayList<Integer> results;

        //생성자
        public Calculator(){results = new ArrayList<>();}
        //기능
        // 1. 계산 기능
        public int calculate(int first, char op, int second){
            int result = 0;
            if(op == '+') result = first + second;
            else if(op == '-') result = first - second;
            else if(op == '*') result = first * second;
            else if(op == '/') result = first / second;
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
        //게터
        public ArrayList<Integer> getResults() {return new ArrayList<>(results);}

        //세터
        public void setResults(ArrayList<Integer> results){this.results = results;}
    }
