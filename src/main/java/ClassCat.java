public class ClassCat {
    private String id;
    private String text;
    private String type;
    private String user;
    private Integer uptoves;

    public ClassCat(String id, String text, String type, String user, Integer uptoves) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.uptoves = uptoves;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public Integer getUptoves() {
        return uptoves;
    }

    @Override
    public String toString() {
        return "ClassCat{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", uptoves='" + uptoves + '\'' +
                '}';
    }

}

