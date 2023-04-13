package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data :
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
   */


@Test
    public void put01(){

    // 1- url ve body
    specJsonPlace.pathParams("pp1","posts","pp2",70);

    TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();

    HashMap<String,Object> reqBody=testDataJsonPlaceHolder.reqBodyOlusturMap();

    // 2- Expected data hazurla

    HashMap<String,Object> expBody=testDataJsonPlaceHolder.reqBodyOlusturMap();

    // 3- Response kaydet

    Response response=given().
            spec(specJsonPlace).contentType(ContentType.JSON).when().body(expBody).put("/{pp1}/{pp2}");
    response.prettyPeek();

    //Assertion
    HashMap<String,Object> respMap=response.as(HashMap.class);

  assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
  assertEquals(expBody.get("id"),respMap.get("id"));
  assertEquals(expBody.get("title"),respMap.get("title"));
  assertEquals(expBody.get("body"),respMap.get("body"));
  assertEquals(expBody.get( "userId"),respMap.get( "userId"));









}
}
