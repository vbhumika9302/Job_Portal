package com.jobportal.util;

import java.security.MessageDigest;

public class PasswordUtil {
	 public static String encode(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            byte[] bytes = md.digest(password.getBytes());

	            StringBuilder sb = new StringBuilder();
	            for (byte b : bytes) {
	                sb.append(String.format("%02x", b));
	            }
	            return sb.toString();

	        } catch (Exception e) {
	            throw new RuntimeException("Password hashing failed");
	        }
	    }

	    public static boolean matches(String raw, String encoded) {
	        return encode(raw).equals(encoded);
	    }
}
