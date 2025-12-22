package ir.aminahmadi24.model;

public class Category {
    private int id;
    private String title;

    public Category(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
