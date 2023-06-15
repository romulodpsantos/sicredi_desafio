package Steps;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Config {

    @Before
    public void setup (){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.baseURI = "https://dummyjson.com";

//        RestAssured.requestSpecification = new RequestSpecBuilder().
//                setContentType(ContentType.JSON).
//                build();

    }
}
