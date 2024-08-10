package api.Petstore.Data;

import java.util.ArrayList;

public class DataGetPet {
    private Integer id;
    private DataGetCategory category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<DataGetTag> tags;
    private String status;



    public DataGetPet() {
    }

    public DataGetPet(Integer id, DataGetCategory category, String name, ArrayList<String> photoUrls, ArrayList<DataGetTag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }
    public Integer getId() {
        return id;
    }

    public DataGetCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public ArrayList<DataGetTag> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategory(DataGetCategory category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setTags(ArrayList<DataGetTag> tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
