package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dominio.Produto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Produto_api {

    private static final String FIND_PRODUCTS_ENDPOINT = "/auth/products";
    private static final String FIND_ADD_PRODUCT_ENDPOINT = "/products/add";
    private static final String FIND_TODOS_PRODUCTS_ENDPOINT = "/products";
    public String FIND_POR_PRODUCTS_ENDPOINT = "/products/{id}";

    public Response consulta_produto(String token){

        return given().log().all().contentType(ContentType.JSON).
                header("Authorization",token).
                when().
                        get(FIND_PRODUCTS_ENDPOINT).
                then().log().all().extract().response();
    }

    public String json_produto() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Produto produto = objectMapper.readValue(new File("arquivo/produto.json"), Produto.class);
        String json = objectMapper.writeValueAsString(produto);
        return json;
    }

    public Response add_produto(String json){
        return given().log().all().contentType(ContentType.JSON).
                    body(json).
                when().
                    post(FIND_ADD_PRODUCT_ENDPOINT).
                then().log().all().extract().response();
    }

    public Response consultar_todos_produtos(){

        return given().log().all().contentType(ContentType.JSON).
                when().
                get(FIND_TODOS_PRODUCTS_ENDPOINT).
                then().log().all().extract().response();
    }

    public Response consultar_por_id(int id){

        return given().log().all().contentType(ContentType.JSON).
                pathParam("id",id).
                when().
                get(FIND_POR_PRODUCTS_ENDPOINT).
                then().log().all().extract().response();
    }

}
