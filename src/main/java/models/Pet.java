package models;

public class Pet {
    private int id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tags[] tags;
    private String status;


    //default constructor
    public Pet() {
    }

    //constructor for put request
    public Pet(int id, Category category, String name, String[] photoUrls, Tags[] tags, String status) {
        setId(id);
        setCategory(category);
        setName(name);
        setPhotoUrls(photoUrls);
        setTags(tags);
        setStatus(status);
    }


    //getters and setters for each body parameter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Tags[] getTags() {
        return tags;
    }

    public void setTags(Tags[] tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
