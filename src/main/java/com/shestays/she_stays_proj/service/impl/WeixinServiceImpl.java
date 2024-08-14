package com.shestays.she_stays_proj.service.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.shestays.she_stays_proj.entity.User;
import com.shestays.she_stays_proj.service.WeixinService;

@Service
public class WeixinServiceImpl implements WeixinService {
    Logger log = LoggerFactory.getLogger(WeixinServiceImpl.class);
    @Value("${weixin.appid}")
    private String appid;
    @Value("${weixin.secret}")
    private String secret;

    private static final String SESSION_KEY = "sessionKey";
    private static final String OPEN_ID = "openId";

    public Map<String, String> getsessionKeyByCode(String code) throws Exception {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={0}&secret={1}&js_code={2}&grant_type=authorization_code";
        String replaceUrl = url.replace("{0}", appid).replace("{1}",
                secret).replace("{2}", code);
        String restStr = httpRequest(replaceUrl, "GET", null);
        log.info("get-session-restStr:::::::" + restStr);
        JSONObject restJson = JSONObject.parseObject(restStr);
        String session_key = restJson.getString("session_key");
        String openId = restJson.getString("openid");

        Map<String, String> restMap = new HashMap<>();
        restMap.put(SESSION_KEY, session_key);
        restMap.put(OPEN_ID, openId);
        return restMap;
    }

    public String httpRequest(String requestUrl, String requestMethod, String output) throws Exception {
        try {
            URL url = new URL(requestUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(requestMethod);
            if (null != output) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(output.getBytes(StandardCharsets.UTF_8));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            StringBuilder buffer = new StringBuilder();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            connection.disconnect();
            return buffer.toString();

        } catch (Exception e) {
            throw e;
        }
    }

    public User getWXUserInfo(String encryptedData, String code, String vi) throws Exception {
        try {
            Map<String, String> restMap = getsessionKeyByCode(code);
            String sessionKey = restMap.get(SESSION_KEY);
            String openId = restMap.get(OPEN_ID);

            Decoder decode = java.util.Base64.getDecoder();
            byte[] encData = decode.decode(encryptedData);
            byte[] iv = decode.decode(vi);
            byte[] key = decode.decode(sessionKey);

            AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            String getInfo = new String(cipher.doFinal(encData), "UTF-8");
            JSONObject infoJson = JSONObject.parseObject(getInfo);
            // 手机号
            String purePhoneNumber = "";
            // 国家编号
            String countryCode = "";
            if (infoJson.containsKey("purePhoneNumber")) {

                purePhoneNumber = infoJson.get("purePhoneNumber").toString();
            }
            if (infoJson.containsKey("countryCode")) {

                countryCode = infoJson.get("countryCode").toString();
            }
            User user = new User();
            user.setOpenId(openId);
            user.setPhone(purePhoneNumber);
            user.setCountryCode(countryCode);
            return user;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }

    }

}
