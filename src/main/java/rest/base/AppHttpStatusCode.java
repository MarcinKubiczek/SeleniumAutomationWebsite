package rest.base;

public enum AppHttpStatusCode {
    CONTINUE(100,"Continue"),
    OK(200,"OK"),
    BAD_REQUEST(400, "Bad Request"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404,"Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    BAD_GATEWAY(502,"Bad Gateway");

    private int code;
    private String desc;
    private String text;

    AppHttpStatusCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
        this.text = Integer.toString(code);
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getText() {
        return text;
    }
}
