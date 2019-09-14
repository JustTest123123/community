package life.majiang.community.community.provider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import life.majiang.community.community.dto.AccessTokenDto;
import life.majiang.community.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

//componet就相当于new ....不需要实例化对象，直接拿到对象即可，发一个请求到GitHub中
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDto accessTokenDto) {
        MediaType mediaType
                = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(string);
            String[] split = string.split("&");
            String tokenstring = split[0];
            String[] split1 = tokenstring.split("=");
            String token = split1[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token=" + accessToken)
                    .build();
        try  {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            System.out.println(string);
            JSONObject obj= (JSONObject) JSON.parse(string);//将字符串转为json对象

            Object dataobj= obj.get("login");//取得data的值

            GithubUser githubUser = JSON.parseObject(string,GithubUser.class);
            githubUser.setName((String) dataobj);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
