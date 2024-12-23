package com.example.demo.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

    public static String toMd5(String input) {
        try {
            //MessageDigest取得
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            //入力文字列をバイト文字列に変換し、MD5ハッシュを計算
            byte[] hashBytes = md.digest(input.getBytes());
            
            //ハッシュ結果(バイト列)を16進数文字列に変換
            StringBuilder hexStr = new StringBuilder();
            for(byte b: hashBytes) {
                String hex = String.format("%02x", b);
                hexStr.append(hex);
            }
            //16進数文字列のハッシュ結果を返す
            return hexStr.toString();
        }catch(NoSuchAlgorithmException e) { //アルゴリズムが存在しないエラーの場合
            throw new RuntimeException(); //Errorの時はRuntimeExceptionを出力する。
        }
    }
}