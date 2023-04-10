package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JsonObjectVerileriCagirma{
    /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
    },
    "phoneNumbers": [
        {
            "type": "iPhone",
            "number": "0123-4567-8888"
        },
        {
            "type": "home",
            "number": "0123-4567-8910"
        }
    ]
}
     */

    @Test
    public void jsonPath01(){

        JSONObject cepTel=new JSONObject();

        cepTel.put( "type", "iPhone");
        cepTel.put( "number","0123-4567-8888");

        JSONObject evTel=new JSONObject();

        evTel.put("type","home");
        evTel.put("number","0123-4567-8910");

        JSONArray phoneNumbers=new JSONArray();
        phoneNumbers.put(1,evTel);
        phoneNumbers.put(0,cepTel);

        JSONObject adress=new JSONObject();
        adress.put( "streetAddress","naist street");
        adress.put ( "city", "Nara");
        adress.put("postalCode","630-0192");

        JSONObject  kisiBilgisi=new JSONObject();
        kisiBilgisi.put("firstName", "John");
        kisiBilgisi.put("lastName","doe");
        kisiBilgisi.put(  "age",26);
        kisiBilgisi.put( "address", adress);
        kisiBilgisi.put( "phoneNumbers", phoneNumbers);
        System.out.println("kisi bilgisi : " +kisiBilgisi);


        System.out.println("Isim :" +kisiBilgisi.get("firstName"));
        System.out.println("SoyIsim :" + kisiBilgisi.get("lastName"));
        System.out.println("Yas:" + kisiBilgisi.get("age"));
        System.out.println("sehir:" + kisiBilgisi.getJSONObject("address").get("city"));
        System.out.println("Posta kodu :" + kisiBilgisi.getJSONObject("address").get("postalCode"));
        System.out.println("sokak adi :" + kisiBilgisi.getJSONObject("address").get("streetAddress"));
        System.out.println("Cep tel no : "
                + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        System.out.println("tel turu: " + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));
        System.out.println("tel turu: " + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(1).get("type"));
        System.out.println("Cep tel no : "
                + kisiBilgisi.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));
    }
}
