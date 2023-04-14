package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;// * kullanildiginda butun methodlar icin kullanilabilir demektir

public class C07_Get_BodyTekrarlardanKurtulma {
     /*
                https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve response body’sindeki
                    "firstname“in,"Jim",
                    ve "lastname“in, "Wilson",
                    ve "totalprice“in, 609,
                    ve "depositpaid“in,false,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */

    //not:bilgiler anlik degistirilebilir o yuzden her zaman ayni gelmeyebilir

    @Test
    public void get01(){
        String url=" https://restful-booker.herokuapp.com/booking/10";

        // expected data hazirla
        // Response kaydet
        Response response=given().when().get(url);

      /* response.then().assertThat()
          .contentType(ContentType.JSON)
               .statusCode(200)
               .body("firstname", Matchers.equalTo("Mark"),
                       "lastname",Matchers.equalTo("Jackson"),
                       "totalprice",Matchers.equalTo(233),
                       "depositpaid",Matchers.equalTo(false),
                       "additionalneeds",Matchers.equalTo("Breakfast"));

       */
        response.then().assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("firstname", equalTo("Mark"),
                        "lastname",equalTo("Jackson"),
                        "totalprice",equalTo(233),
                        "depositpaid",equalTo(false),
                        "additionalneeds",equalTo("Breakfast"));
    }
}
