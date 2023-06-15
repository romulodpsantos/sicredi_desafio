package Steps;

import api.Produto_api;
import api.Test_api;
import api.Token_API;
import api.User_api;
import com.fasterxml.jackson.core.JsonProcessingException;
import dominio.Produto;
import dominio.users;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;


import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

public class Step_definition {

    private User_api user_api;
    private Test_api test_api;
    private Token_API token_api;

    private Produto_api produto_api;
    private List<users> listausuario;

    private Produto produto;

    public Step_definition(){
        user_api = new User_api();
        test_api = new Test_api();
        token_api = new Token_API();
        produto_api = new Produto_api();
    }
    public Response resp;
    public String token = "teste";

    @Quando("envio um request GET {word}")
    public void envioUmRequestParaValidarASaudaDaMinhaAplicacao(String endpoint) {
        switch (endpoint){
            case "/test":
                    test_api.vailda_status();
                break;
            case "/users":
                    user_api.sucesso();
                break;
            case "/auth/products":
                resp = produto_api.consulta_produto(token);
                break;
            case "/auth/products/sem_token":
                token = "";
                resp = produto_api.consulta_produto(token);
                break;
            case "/products":
                resp = produto_api.consultar_todos_produtos();
                break;
            case "/products/1":
                resp = produto_api.consultar_por_id(1);
                break;
            case "/products/102":
                resp = produto_api.consultar_por_id(102);
                break;
            default:
                System.out.println("Parâmetro não encontardo");
        }
    }

    @Entao("valido GET {word} que o status code retorna {int}")
    public void validoQueOStatusCodeRetorna(String endpoint, int arg0) {
        test_api.vailda_status();
    }

    @Entao("valido que GET {word} retorna a lista de usuario com sucesso.")
    public void validoQueGETUsersRetornaAListaDeUsuarioComSucesso(String endpoint) throws JsonProcessingException {
         listausuario = user_api.getUsers();
    }

    @E("que a lista nao esta vazia.")
    public void queAListaNaoEstaVazia() {
        assertThat(listausuario, is(not(empty())));
    }
    
    @Quando("envio um post {word} com o {string} e {string}")
    public void envioUmPostAuthLoginComOE(String endpoint, String user, String pass) {
        resp = token_api.AuteticacaoToken(user,pass);
        token = resp.jsonPath().getString("token");
    }

    @Entao("valido que o token foi obtido com sucesso.")
    public void validoQueOTokenFoiObtidoComSucesso() {
        resp.then().statusCode(HttpStatus.SC_OK).
                    body("id", is(15),
                            "token", is(not(empty())),
                            "username", is("kminchelle")
                    );
    }

    @Entao("valido que a busca de produtos com autenticação foi realizada com sucesso.")
    public void validoQueABuscaDeProdutosComAutenticaçãoFoiRealizadaComSucesso() {
        resp.then().statusCode(HttpStatus.SC_OK);
        assertThat(resp.jsonPath().getList("title"), is(not(empty())));
    }

    @Entao("valido que a busca de produtos sem autenticação não foi realizada com sucesso.")
    public void validoQueABuscaDeProdutosSemAutenticaçãoNãoFoiRealizadaComSucesso() {
        resp.then().statusCode(HttpStatus.SC_UNAUTHORIZED).
                    body("name", is("JsonWebTokenError"),
                            "message", is("Invalid/Expired Token!"));
    }

    @Entao("valido que a busca de produtos não foi realizada com sucesso por problema na autencicação.")
    public void validoQueABuscaDeProdutosNãoFoiRealizadaComSucessoPorProblemaNaAutencicação() {
        resp.then().statusCode(HttpStatus.SC_FORBIDDEN).
                body("message", is("Authentication Problem"));
    }

    @Quando("envio um Post {word} com arquivo json")
    public void envioUmPostProductsAddComArquivoJson(String endpoint) throws IOException {
        String json = produto_api.json_produto();
        resp = produto_api.add_produto(json);
    }

    @Entao("valido que o produto foi adicionado com sucesso.")
    public void validoQueOProdutoFoiAdicionadoComSucesso() {
        resp.then().statusCode(HttpStatus.SC_OK).
                body("id", is(101),
                       "title", is("Perfume Oil"),
                        "price", is(13),
                        "stock", is(65),
                        "rating", is(4.26F),
                        "thumbnail", is("https://i.dummyjson.com/data/products/11/thumnail.jpg"),
                        "description", is("Mega Discount, Impression of A..."),
                        "brand", is("Impression of Acqua Di Gio"),
                        "category", is("fragrances"));
    }

    @Entao("valido que a busca de todos os produtos foi realizada com sucesso.")
    public void validoQueABuscaDeTodosOsProdutosFoiRealizadaComSucesso() {
        resp.then().statusCode(HttpStatus.SC_OK);
        assertThat(resp.jsonPath().get("id"), is(not(empty())));
    }

    @Entao("valido que a busca foi realizada com sucesso")
    public void validoQueABuscaFoiRealizadaComSucesso() {
        resp.then().statusCode(HttpStatus.SC_OK);
        assertThat(resp.jsonPath().get("id"), is(1));
        assertThat(resp.jsonPath().get("title"), is("iPhone 9"));
    }

    @Entao("valido que a busca não foi realizada com sucesso")
    public void validoQueABuscaNãoFoiRealizadaComSucesso() {
        resp.then().statusCode(HttpStatus.SC_NOT_FOUND);
        assertThat(resp.jsonPath().get("message"), is("Product with id '102' not found"));
    }
}
