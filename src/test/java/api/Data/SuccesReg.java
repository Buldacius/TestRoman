package api.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuccesReg {
    private Integer id;
    private String token;

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public SuccesReg setId(Integer id) {
        this.id = id;
        return this;
    }

    public SuccesReg setToken(String token) {
        this.token = token;
        return this;
    }
}
