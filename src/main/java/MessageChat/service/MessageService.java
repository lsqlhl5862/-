package MessageChat.service;

import MessageChat.Model.Message;
import MessageChat.Translate.TransApi;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import com.alibaba.fastjson.JSON;

@Service
public class MessageService {

    public ArrayList<Message> list= new ArrayList<>();
    private static final String APP_ID = "20180428000151397";
    private static final String SECURITY_KEY = "FfxzS8bzfxqZx7hUe360";
    private static final TransApi api = new TransApi(APP_ID, SECURITY_KEY);
    private  boolean ready=true;
    public void AddMessage(String text) throws UnsupportedEncodingException {
        ready=false;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        JSONObject succesResponse = JSON.parseObject( api.getTransResult(text, "auto", "en"));    //先转换成Object
        JSONArray result=(JSONArray)succesResponse.get("trans_result");
        list.add(new Message(df.format(new Date()),text,((Map)result.get(0)).get("dst").toString()));
        ready=true;
    }

    public ArrayList ListMessage()
    {
        while(!ready)
        {

        }
        return list;
    }
}
