package com.example.codingmom.domain.user.service;

import com.example.codingmom.domain.user.entity.User;
import com.example.codingmom.domain.user.entity.repository.UserRepository;
import com.example.codingmom.domain.user.presentation.dto.response.UserDto;
import com.example.codingmom.global.security.jwt.JwtTokenProvider;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class KakaoService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public String getAccessToken(String auth_code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();

            sb.append("grant_type=authorization_code");
            sb.append("&client_id=95e372793e81af183d89b707dfa1d7bd"); // 본인이 발급받은 key
            sb.append("&redirect_uri=http://localhost:3000/auth/kakao/callback"); // 본인이 설정해 놓은 경로
            sb.append("&code=" + auth_code);
            bw.write(sb.toString());
            bw.flush();

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);

            br.close();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return access_Token;
    }


    public Map<String, Object> getUserInfo(String access_token){
        String host = "https://kapi.kakao.com/v2/user/me";
        Map<String, Object> result = new HashMap<>();
        try {
            URL url = new URL(host);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Bearer " + access_token);
            urlConnection.setRequestMethod("GET");

            int responseCode = urlConnection.getResponseCode();
            System.out.println("responseCode = " + responseCode);


            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            String res = "";
            while((line=br.readLine())!=null)
            {
                res+=line;
            }

            System.out.println("res = " + res);


            JsonParser parser = new JsonParser();
            JsonObject obj = (JsonObject) parser.parse(res);
            JsonObject kakao_account = (JsonObject) obj.get("kakao_account");
            JsonObject properties = (JsonObject) obj.get("properties");


            String k_id = obj.get("id").toString();
            String k_img_url = properties.get("profile_image").toString();

            result.put("k_id", k_id);
            result.put("k_img_url", k_img_url);

            br.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    public Map<String, Object> getUserInfoById(String k_id) {
        String host = "https://kapi.kakao.com/v2/user/me";
        Map<String, Object> result = new HashMap<>();
        long a = Long.parseLong(k_id);
        try {
            URL url = new URL(host+"?secure_resource=false&property_keys=%5B%22properties.profile_image%22%5D&target_id_type=user_id&target_id="+a);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Authorization", "KakaoAK "+ "e280c0079ce7831e329a32834290e627");
            urlConnection.setRequestMethod("GET");

            int responseCode = urlConnection.getResponseCode();
            System.out.println("responseCode = " + responseCode);


            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            String res = "";
            while((line=br.readLine())!=null)
            {
                res+=line;
            }
            JsonParser parser = new JsonParser();
            JsonObject obj = (JsonObject) parser.parse(res);
            JsonObject properties = (JsonObject) obj.get("properties");
            String k_img_url = properties.get("profile_image").toString();
            result.put("k_img_url", k_img_url);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
