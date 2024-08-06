package api.Data;

import api.Data.SuccesReg;

public class DataProvider {

    public SuccesReg getSuccessRegData(Integer id, String token) {
        return SuccesReg.builder()
                .id(id)
                .token(token)
                .build();
    }


}
