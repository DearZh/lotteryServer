package javautils.deal;

import java.util.Random;
import java.util.UUID;

public class OrderUtil
{
  public static String getBillno(int length, boolean isNumber)
  {
    String uuid = UUID.randomUUID().toString().replace("-", "");
    if (isNumber) {
      uuid = uuid.replace("a", "1").replace("b", "2").replace("c", "3").replace("d", "4").replace("e", "5").replace("f", "6");
    }
    if (uuid.length() < length) {
      uuid = uuid + getBillno(length - uuid.length(), isNumber);
    } else {
      uuid = uuid.substring(0, length);
    }
    return uuid;
  }
  
  public static String createString(int length)
  {
    StringBuffer sb = new StringBuffer();
    char[] ch = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1' };
    Random random = new Random();
    if (length > 0)
    {
      int index = 0;
      char[] temp = new char[length];
      int num = random.nextInt();
      for (int i = 0; i < length % 5; i++)
      {
        temp[(index++)] = ch[(num & 0x3F)];
        num >>= 6;
      }
      for (int i = 0; i < length / 5; i++)
      {
        num = random.nextInt();
        for (int j = 0; j < 5; j++)
        {
          temp[(index++)] = ch[(num & 0x3F)];
          num >>= 6;
        }
      }
      sb.append(new String(temp, 0, length));
    }
    return sb.toString();
  }
  
  public static String createString(Object[] config)
  {
    StringBuffer sb = new StringBuffer();
    Object[] arrayOfObject = config;int j = config.length;
    for (int i = 0; i < j; i++)
    {
      Object key = arrayOfObject[i];
      if ((key instanceof Integer)) {
        sb.append(createString(((Integer)key).intValue()));
      }
      if ((key instanceof String)) {
        sb.append(key);
      }
    }
    return sb.toString();
  }
}
