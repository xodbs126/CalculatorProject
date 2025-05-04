package lv3;

public enum OperatorType {
    PLUS('+'), MINUS('-'), MULTIPLY('*'), DIVIDE('/');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public static OperatorType fromChar(char c) {
        for (OperatorType op : values()) {
            if (op.symbol == c)
                return op;
        }
        throw new IllegalStateException();
    }
}