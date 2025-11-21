public enum TestType {
    PUBLIC("public"),
    HIDDEN("hidden");

    private final String type;

    TestType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
