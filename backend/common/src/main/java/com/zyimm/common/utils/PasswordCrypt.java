package com.zyimm.common.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * @author zyimm
 */
public class PasswordCrypt {
    

    public static String  hash(String password){
       return  BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public static Boolean  hashVerify(String password, String ciphertext){
        return   BCrypt.verifyer().verify(password.toCharArray(), ciphertext).verified;
     }
}
