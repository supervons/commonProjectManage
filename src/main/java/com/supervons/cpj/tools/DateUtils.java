package com.supervons.cpj.tools;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {

    //设置NET服务器时间地址，这里是阿里云的服务器.
    public static String ServerIP = "120.25.115.20";

    //获取服务器的标准北京时间
    public static Date getStandardTime() throws IOException {

        NTPUDPClient client = new NTPUDPClient();
        //响应延迟时间
        client.setDefaultTimeout(10000);
        try {
            client.open();
            InetAddress hostAddr = InetAddress.getByName(ServerIP);
            TimeInfo info = client.getTime(hostAddr);
            Date date = new java.util.Date(info.getReturnTime());
            return date;
            // processResponse(info);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        client.close();
        return null;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(DateUtils.getStandardTime());
    }

    private DateUtils(){}

    private static DateUtils dateUtils = new DateUtils();

    public static DateUtils getInstance(){
        return dateUtils;
    }

    public static String  getFormatDate() throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return sdf.format(DateUtils.getStandardTime());
    }

}
