package api_tests.rest;

import api.CarController;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllUserCarTestRest extends CarController {

    @Test
    public  void  getAllUserCarPositiveTest(){
        Assert.assertEquals(getAllUserCarResponse(tokenDto.getAccessToken()).getStatusCode(), 200);

    }
}
