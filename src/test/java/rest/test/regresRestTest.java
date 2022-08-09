package rest.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rest.base.DataProvider;
import static org.assertj.core.api.Assertions.assertThat;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public class regresRestTest {
    private static ObjectMapper mapper = new ObjectMapper();
    private static DataProvider dataProvider;

    @BeforeAll
    public static void prepareTestData(){
        dataProvider = new DataProvider();
    }
    @Test
    public void test001_verifyUserInfo(){
        String apiBodyService = "/api/users?page=2";
        Map userDataMap =  dataProvider.getRestDataMap(apiBodyService);
        assertThat(userDataMap.get("page")).isEqualTo(2);
        List userList = (List) userDataMap.get("data");
        assertThat(userList.get(0)).asString().contains("michael.lawson@reqres.in");
        assertThat(userDataMap.get("per_page")).isEqualTo(6);
        assertThat(userDataMap.get("data")).asList().hasSize(6);
        }
     @Test
    public void test002_verifySingleUserInfo(){
        String apiBodyService = "";
        Map singleUserDataMap = dataProvider.getRestDataMap(apiBodyService);

     }
}
