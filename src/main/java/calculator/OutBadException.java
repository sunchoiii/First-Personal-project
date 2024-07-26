package calculator;

public class OutBadException extends Exception{

    public OutBadException (String s) {
        super("나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘 못 들어왔습니다.");
    }

}
