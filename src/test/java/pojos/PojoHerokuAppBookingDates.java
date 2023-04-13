package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter ve setter leri getirir
@NoArgsConstructor //paramertesiz constructer olusturur
@AllArgsConstructor //parametreli consturterleri olusturur
public class PojoHerokuAppBookingDates {
    /*
    {
    "checkin" : "2021-06-01",
    "checkout" : "2021-06-10"
                                          },
     */
    private String checkin;
    private String checkout;

    // not:yukardaki @ isaretliler bizim icin butun islemleri hazirliyor

}
