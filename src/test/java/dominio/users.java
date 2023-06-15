package dominio;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class users {

    @Builder.Default
    private int id = 10;
    @Builder.Default
    private String firstName = "Romulo";
    @Builder.Default
    private String lastName = "Santos";
    @Builder.Default
    private String maidenName = "romulo_santos";
    @Builder.Default
    private int age = 39;
    @Builder.Default
    private String gender = "Teste";
    @Builder.Default
    private String email = "Teste";
    @Builder.Default
    private String phone = "Teste";
    @Builder.Default
    private String username = "Teste";
    @Builder.Default
    private String password = "Teste";
    @Builder.Default
    private String birthDate = "Teste";
    @Builder.Default
    private String image = "Teste";
    @Builder.Default
    private String bloodGroup = "Teste";
    @Builder.Default
    private int height = 3;
    @Builder.Default
    private float weight = 4;
    @Builder.Default
    private String eyeColor = "Teste";
    @Builder.Default
    private Hair hair = new Hair();
    @Builder.Default
    private String domain = "Teste";
    @Builder.Default
    private String ip = "Teste";
    @Builder.Default
    private Address address = new Address();
    @Builder.Default
    private String macAddress = "Teste";
    @Builder.Default
    private String university = "Teste";
    @Builder.Default
    private Bank bank = new Bank();
    @Builder.Default
    private Company company = new Company();
    @Builder.Default
    private String ein = "Teste";
    @Builder.Default
    private String ssn = "Teste";
    @Builder.Default
    private String userAgent = "Teste";

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Company {

        @Builder.Default
        private Address_Company address = new Address_Company();
        @Builder.Default
        private String department = "teste";
        @Builder.Default
        private String name = "teste";
        @Builder.Default
        private String title = "teste";

    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Address_Company {

        @Builder.Default
        private String address = "teste";
        @Builder.Default
        private String city = "teste";
        @Builder.Default
        private dominio.Coordinates coordinates = new dominio.Coordinates();
        @Builder.Default
        private String postalCode = "teste";
        @Builder.Default
        private String state = "teste";
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Address {

        @Builder.Default
        private String address = "teste";
        @Builder.Default
        private String city = "teste";
        @Builder.Default
        private dominio.Coordinates coordinates = new dominio.Coordinates();
        @Builder.Default
        private String postalCode = "teste";
        @Builder.Default
        private String state = "teste";

    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Hair {

        @Builder.Default
        private String color = "teste";
        @Builder.Default
        private String type = "teste";
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Bank {

        @Builder.Default
        private String cardExpire = "teste";
        @Builder.Default
        private String cardNumber = "teste";
        @Builder.Default
        private String cardType = "teste";
        @Builder.Default
        private String currency = "teste";
        @Builder.Default
        private String iban = "teste";
    }


}
