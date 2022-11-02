public enum TypeRepeatable {

    SINGLE("однократная"),
    DAILY("ежедневная"),
    WEEKLY("еженедельная"),
    MONTHLY("ежемесячная"),
    ANNUAL("ежегодная");
    private String title;

    TypeRepeatable(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
