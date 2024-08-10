package api.ProjectOne.Spec.Data;

import java.util.Date;

public class UserNew {
    private String name;
    private String job;

    public UserNew(String name, String job ) {
        this.name = name;
        this.job = job;
    }

    public UserNew() {
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

}
