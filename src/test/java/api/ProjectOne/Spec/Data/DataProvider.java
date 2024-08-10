package api.ProjectOne.Spec.Data;

public class DataProvider {

    public SuccesReg getSuccessRegData(Integer id, String token) {
        return SuccesReg.builder()
                .id(id)
                .token(token)
                .build();
    }


}
