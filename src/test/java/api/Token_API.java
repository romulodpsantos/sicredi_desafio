package api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Token_API {

    private static final String FIND_TOKEN_ENDPOINT = "/auth/login";

    public Response AuteticacaoToken(String username, String password){

    String json = "{\"username\":\""+ username +"\",\"password\":\""+password+ "\"}" ;

       return   given().
                    contentType(ContentType.JSON).
                    body(json).
                when().
                    post(FIND_TOKEN_ENDPOINT).
                then().extract().response();
    }


}
