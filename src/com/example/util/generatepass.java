package com.example.util;

import java.security.SecureRandom;
import java.io.*;
import java.util.*;

public class generatepass{
  public static String randomstring(int length){
    Random random = new SecureRandom();
    char[] characterset="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@_".toCharArray();
    char[] result = new char[length];

    for (int i=0;i<result.length;i++){
      int randomcharindex=random.nextInt(characterset.length);
      result[i]=characterset[randomcharindex];
    }
    return new String(result);
  }
}
