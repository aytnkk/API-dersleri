package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine
    bir GET request yolladigimizda donen response body’sinin
    asagida verilen ile ayni oldugunu test ediniz
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
        String url="https://jsonplaceholder.typicode.com/posts/22";
      //expected data hazirla
        JSONObject expectedBody=new JSONObject();
        expectedBody.put("userId",3);
        expectedBody.put( "id",22);
        expectedBody.put("title","dolor sint quo a velit explicabo quia nam");
        expectedBody.put(  "body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear um mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        Response response=given().when().get(url);
        response.prettyPrint();
        //NOT: Donen responsen Body'si ile islem yapmak istiyorsak bunu jsonPath objesine donusturmemiz gerekiyor
        JsonPath resJsPath=response.jsonPath();
        Assert.assertEquals(expectedBody.get("userId"),);
        }
    }

