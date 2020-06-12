package newpackage;

import static org.junit.Assert.*;

import java.util.HashMap;

import net.nurigo.java_sdk.api.Message;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Test;

public class SMS {

    @Test
    public void Message(String UserPhoneNumber) throws Exception {

        String api_key = "NCSJPHS6YFMWD0MO";
        String api_secret = "PHB3O1AOPMZ0LPY2DBQEDEVAAEOVZRNI";

        Message message = new Message(api_key, api_secret);

        String authkey = new TempKey().getKey(5);

        JSONObject result;
        HashMap<String, String> params = new HashMap<String, String>();

        try {
            // send
            params.put("to", UserPhoneNumber);
            params.put("from", "01032042646");
            params.put("type", "SMS");
            params.put("text", "로그인 인증키는 [" + authkey + "] 입니다.");
            params.put("mode", "test");

            result = message.send(params);
            assertNotNull(result.get("group_id"));

            // balance
            result = message.balance();
            assertNotNull(result.get("cash"));

            // sent
            params.clear();
            try {
                result = message.sent(params);
                assertNotNull(result.get("data"));
            } catch (Exception e) {
                result = (JSONObject) JSONValue.parse(e.getMessage());
                assertEquals(result.get("code"), "NoSuchMessage");
            }

            // status
            result = message.getStatus(params);

            // cancel
            params.put("mid", "MIDTEST");
            result = message.cancel(params);
            assertTrue(!result.isEmpty());
        } catch (Exception e) {

        }
    }
}
