package model;

public class File {

    private String title;
    private Long size;
    private String type;

    public File(String titlle, Long size, String type) {
        this.title = titlle;
        this.size = size;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public Long getSize() {
        return size;
    }

    public String getType() {
        return type;
    }
}
