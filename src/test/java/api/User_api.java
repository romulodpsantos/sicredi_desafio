package api;

import dominio.users;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;

import java.util.List;
import static io.restassured.RestAssured.when;


public class User_api {
    private static final String FIND_USERS_ENDPOINT = "/users";

    public void sucesso(){
        when().
                get(FIND_USERS_ENDPOINT).
        then().
                contentType(ContentType.JSON).
                statusCode(HttpStatus.SC_OK);
    }
    public List<users> getUsers(){

        return when().
                    get(FIND_USERS_ENDPOINT).
                then().
                    extract().body().jsonPath().getList("users", users.class);
    }


}
