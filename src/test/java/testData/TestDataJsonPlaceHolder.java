package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataJsonPlaceHolder {

     public int basariliStatusCode=200;

     public JSONObject expectedBodyOlusturJson(){

         //expected data hazirla
      /*  {
            "userId":3,
                "id":22,
                "title":"dolor sint quo a velit explicabo quia nam",
                "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
            um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
     */

         JSONObject expectedBody=new JSONObject();
         expectedBody.put("userId",3);
         expectedBody.put( "id",22);
         expectedBody.put("title","dolor sint quo a velit explicabo quia nam");
         expectedBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear um mollitia molestiae aut atque rem suscipit\nnam impedit esse");

         return  expectedBody;
     }

public HashMap reqBodyOlusturMap(){

         /*
           Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
          */

    HashMap<String,Object>  reqBody=new HashMap<>();

       reqBody.put("title","Ahmet");
       reqBody.put("body","Merhaba");
       reqBody.put("userId",10.0);
       reqBody.put( "id",70.0);

       return reqBody;

}

}
