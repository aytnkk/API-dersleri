package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {
    /*
  https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
  request yolladigimizda donen response’in status kodunun 200 ve
  response body’sinin asagida verilen ile ayni oldugunu test ediniz
   Response body :
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */

    @Test
    public void get01(){

       specJsonPlace.queryParams("pp1","posts","pp2",22);

     // expectted data hazirla
        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();
        JSONObject expData= testDataJsonPlaceHolder.expectedBodyOlusturJson();

        //response kaydet
        Response response=given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

        //Assertion

       JsonPath respJp= response.jsonPath();

       assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        assertEquals(expData.get("userId"),respJp.get("userId"));
        assertEquals(expData.get("id"),respJp.get("id"));
        assertEquals(expData.get("title"),respJp.get("title"));
        assertEquals(expData.get("body"),respJp.get("body"));

        

    }
}
