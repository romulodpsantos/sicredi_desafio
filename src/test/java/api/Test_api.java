package api;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.when;
import static org.hamcrest.core.Is.is;

public class Test_api {

    private static final String FIND_TEST_ENDPOINT = "/test";

    public void vailda_status(){
        when().
                get(FIND_TEST_ENDPOINT).
        then().
                contentType(ContentType.JSON).
                statusCode(HttpStatus.SC_OK).
                body("status", is("ok"));
    }

}
