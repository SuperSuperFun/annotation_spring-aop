package com.wangli.util;

import com.wangli.util.entity.LongitudeAndLatitude;
import net.sf.json.JSONObject;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DistanceUtil {

    public static LongitudeAndLatitude getLngAndLat(String address) {
        LongitudeAndLatitude lngAndLat = new LongitudeAndLatitude();
        String url = "http://api.map.baidu.com/geocoder/v2/?address=" + address + "&output=json&ak=自己注册的ak值";
        String json = loadJSON(url);
        if (StringUtils.isEmpty(json)) {
            return lngAndLat;
        }
        int len = json.length();
        // 如果不是合法的json格式
        if (json.indexOf("{") != 0 || json.lastIndexOf("}") != len - 1) {
            return lngAndLat;
        }
        JSONObject obj = JSONObject.fromObject(json);
        if (obj.get("status").toString().equals("0")) {
            Double lng = obj.getJSONObject("result").getJSONObject("location").getDouble("lng");
            Double lat = obj.getJSONObject("result").getJSONObject("location").getDouble("lat");
            lngAndLat.setLat(lat);
            lngAndLat.setLng(lng);
        }
        return lngAndLat;
    }

    public static String loadJSON(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL urlObj = new URL(url);
            URLConnection uc = urlObj.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine = null;
            while ((inputLine = br.readLine()) != null) {
                json.append(inputLine);
            }
            br.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return json.toString();
    }

    /**
     * 测试方法 说明：把代码中的ak值（红色字部分）更改为你自己的ak值，在百度地图API中注册一下就有。
     * 百度路径：http://lbsyun.baidu.com/index.php?title=webapi/guide/changeposition
     */
    public static void main(String[] args) {
        LongitudeAndLatitude latAndLng = DistanceUtil.getLngAndLat("天安门");
        System.out.println("经度：" + latAndLng.getLng() + "---纬度：" + latAndLng.getLat());
    }

    /**
     * 补充：计算两点之间真实距离
     * @return 米
     */
    public static double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        // 维度
        double lat1 = (Math.PI / 180) * latitude1;
        double lat2 = (Math.PI / 180) * latitude2;

        // 经度
        double lon1 = (Math.PI / 180) * longitude1;
        double lon2 = (Math.PI / 180) * longitude2;

        // 地球半径
        double R = 6371;

        // 两点间距离 km，如果想要米的话，结果*1000就可以了
        double d = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * R;

        return d * 1000;
    }
}
