package api.ProjectOne.Spec.Data;

public class UserNewResponse extends UserNew {
    private String updatedAt;

    public UserNewResponse() {
    }


    public UserNewResponse(String name, String job, String updatedAt) {
        super(name, job);
        this.updatedAt = updatedAt;
    }

    public UserNewResponse(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
