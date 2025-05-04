package calculator.lv3;
public enum OperatorType {
    // 속성
    ADD('+'), SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/');
    private final char op;

    //생성자
    OperatorType(char op) {this.op = op;}

    // 게터
    public char getOp() {return op;}

    // 기능
    public static  OperatorType findOp(char inputOp){
        for (OperatorType choOp : OperatorType.values()){
            if(choOp.op == inputOp) return choOp;
        } throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }
}
