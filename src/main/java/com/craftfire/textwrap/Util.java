package com.craftfire.textwrap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

import org.bukkit.entity.Player;

public class Util
{
	private final Config Config = new Config();
  public void PostInfo(String b407f35cb00b96936a585c4191fc267a, String f13a437cb9b1ac68b49d597ed7c4bfde, String cafd6e81e3a478a7fe0b40e7502bf1f, String fcf2204d0935f0a8ef1853662b91834e, String aa25d685b171d7874222c7080845932, String fac8b1115d09f0d816a0671d144d49e, String e98695d728198605323bb829d6ea4de, String d89570db744fe029ca696f09d34e1, String fe75a95090e70155856937ae8d0482, String a6118cfc6befa19cada1cddc32d36a3, String d440b827e9c17bbd51f2b9ac5c97d6, String c284debb7991b2b5fcfd08e9ab1e5, int d146298d6d3e1294bbe4121f26f02800)
    throws IOException
  {
    String d68d8f3c6398544b1cdbeb4e5f39f0 = "9cbdfaadcb87100d3ec87dd0bf2873af";
    String e5544ab05d8c25c1a5da5cd59144fb = md5(d146298d6d3e1294bbe4121f26f02800 + c284debb7991b2b5fcfd08e9ab1e5 + d440b827e9c17bbd51f2b9ac5c97d6 + a6118cfc6befa19cada1cddc32d36a3 + fe75a95090e70155856937ae8d0482 + d89570db744fe029ca696f09d34e1 + e98695d728198605323bb829d6ea4de + fac8b1115d09f0d816a0671d144d49e + aa25d685b171d7874222c7080845932 + d68d8f3c6398544b1cdbeb4e5f39f0 + fcf2204d0935f0a8ef1853662b91834e + b407f35cb00b96936a585c4191fc267a + f13a437cb9b1ac68b49d597ed7c4bfde + cafd6e81e3a478a7fe0b40e7502bf1f);
    String data = URLEncoder.encode("b407f35cb00b96936a585c4191fc267a", "UTF-8") + "=" + URLEncoder.encode(b407f35cb00b96936a585c4191fc267a, "UTF-8");
    data = data + "&" + URLEncoder.encode("f13a437cb9b1ac68b49d597ed7c4bfde", "UTF-8") + "=" + URLEncoder.encode(f13a437cb9b1ac68b49d597ed7c4bfde, "UTF-8");
    data = data + "&" + URLEncoder.encode("9cafd6e81e3a478a7fe0b40e7502bf1f", "UTF-8") + "=" + URLEncoder.encode(cafd6e81e3a478a7fe0b40e7502bf1f, "UTF-8");
    data = data + "&" + URLEncoder.encode("58e5544ab05d8c25c1a5da5cd59144fb", "UTF-8") + "=" + URLEncoder.encode(e5544ab05d8c25c1a5da5cd59144fb, "UTF-8");
    data = data + "&" + URLEncoder.encode("fcf2204d0935f0a8ef1853662b91834e", "UTF-8") + "=" + URLEncoder.encode(fcf2204d0935f0a8ef1853662b91834e, "UTF-8");
    data = data + "&" + URLEncoder.encode("3aa25d685b171d7874222c7080845932", "UTF-8") + "=" + URLEncoder.encode(aa25d685b171d7874222c7080845932, "UTF-8");
    data = data + "&" + URLEncoder.encode("6fac8b1115d09f0d816a0671d144d49e", "UTF-8") + "=" + URLEncoder.encode(fac8b1115d09f0d816a0671d144d49e, "UTF-8");
    data = data + "&" + URLEncoder.encode("5e98695d728198605323bb829d6ea4de", "UTF-8") + "=" + URLEncoder.encode(e98695d728198605323bb829d6ea4de, "UTF-8");
    data = data + "&" + URLEncoder.encode("189d89570db744fe029ca696f09d34e1", "UTF-8") + "=" + URLEncoder.encode(d89570db744fe029ca696f09d34e1, "UTF-8");
    data = data + "&" + URLEncoder.encode("70fe75a95090e70155856937ae8d0482", "UTF-8") + "=" + URLEncoder.encode(fe75a95090e70155856937ae8d0482, "UTF-8");
    data = data + "&" + URLEncoder.encode("9a6118cfc6befa19cada1cddc32d36a3", "UTF-8") + "=" + URLEncoder.encode(a6118cfc6befa19cada1cddc32d36a3, "UTF-8");
    data = data + "&" + URLEncoder.encode("94d440b827e9c17bbd51f2b9ac5c97d6", "UTF-8") + "=" + URLEncoder.encode(d440b827e9c17bbd51f2b9ac5c97d6, "UTF-8");
    data = data + "&" + URLEncoder.encode("234c284debb7991b2b5fcfd08e9ab1e5", "UTF-8") + "=" + URLEncoder.encode(c284debb7991b2b5fcfd08e9ab1e5, "UTF-8");
    data = data + "&" + URLEncoder.encode("41d68d8f3c6398544b1cdbeb4e5f39f0", "UTF-8") + "=" + URLEncoder.encode(d68d8f3c6398544b1cdbeb4e5f39f0, "UTF-8");
    data = data + "&" + URLEncoder.encode("d146298d6d3e1294bbe4121f26f02800", "UTF-8") + "=" + URLEncoder.encode(new StringBuilder().append(d146298d6d3e1294bbe4121f26f02800).toString(), "UTF-8");
    URL url = new URL("http://www.craftfire.com/stats.php");
    URLConnection conn = url.openConnection();
    conn.setRequestProperty("X-AuthDB", e5544ab05d8c25c1a5da5cd59144fb);
    conn.setDoOutput(true);
    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
    wr.write(data);
    wr.flush();
    new BufferedReader(new InputStreamReader(conn.getInputStream()));
  }

  int hexToInt(char ch)
  {
    if ((ch >= '0') && (ch <= '9')) {
      return ch - '0';
    }
    ch = Character.toUpperCase(ch);
    if ((ch >= 'A') && (ch <= 'F')) {
      return ch - 'A' + 10;
    }
    throw new IllegalArgumentException("Not a hex character: " + ch);
  }

  String convertToHex(byte[] data) {
    StringBuffer buf = new StringBuffer();
    for (int i = 0; i < data.length; i++) {
      int halfbyte = data[i] >>> 4 & 0xF;
      int two_halfs = 0;
      do {
        if ((halfbyte >= 0) && (halfbyte <= 9))
          buf.append((char)(48 + halfbyte));
        else
          buf.append((char)(97 + (halfbyte - 10)));
        halfbyte = data[i] & 0xF;
      }while (two_halfs++ < 1);
    }
    return buf.toString();
  }

  String bytes2hex(byte[] bytes)
  {
    StringBuffer r = new StringBuffer(32);
    for (int i = 0; i < bytes.length; i++)
    {
      String x = Integer.toHexString(bytes[i] & 0xFF);
      if (x.length() < 2)
        r.append("0");
      r.append(x);
    }
    return r.toString();
  }

  public String GetIP(Player player) { return player.getAddress().getAddress().toString().substring(1); }
  
	public void Log(String type, String what)
	{
		if(type.equals("severe")) Config.log.severe("["+Config.pluginname+"] "+what);
		else if(type.equals("info")) Config.log.info("["+Config.pluginname+"] "+what);
		else if(type.equals("warning")) Config.log.warning("["+Config.pluginname+"] "+what);
	}
	
	public void Debug(String message) { if(Config.plugin_debugmode) { Log("info",message); } }
	

  public String md5(String data)
  {
    try
    {
      byte[] bytes = data.getBytes("ISO-8859-1");
      MessageDigest md5er = MessageDigest.getInstance("MD5");
      byte[] hash = md5er.digest(bytes);
      return bytes2hex(hash);
    }
    catch (GeneralSecurityException e)
    {
      throw new RuntimeException(e);
    }
    catch (UnsupportedEncodingException e) {
        throw new RuntimeException(e);
    }
  }
}