package eapli.base.app.sharedboardapp;

public class Message {
    private final int version;
    private final int code;
    private final int D_LENGTH_1;
    private final int D_LENGTH_2;
    private final String DATA;

    public Message(int version, int code, int D_LENGTH_1, int D_LENGTH_2, String DATA) {
        this.version = version;
        this.code = code;
        this.D_LENGTH_1 = D_LENGTH_1;
        this.D_LENGTH_2 = D_LENGTH_2;
        this.DATA = DATA.replaceAll("[^a-zA-Z0-9@:.\n]", "");
    }

    public int getVersion() {
        return version;
    }

    public int getCode() {
        return code;
    }

    public int getD_LENGTH_1() {
        return D_LENGTH_1;
    }

    public int getD_LENGTH_2() {
        return D_LENGTH_2;
    }

    public String getData() {
        return DATA;
    }
}
