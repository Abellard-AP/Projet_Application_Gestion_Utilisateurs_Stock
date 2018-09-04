package fr.formation.util;

import org.apache.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

public class Encrypt {
	private static final Logger logger = Logger.getLogger(Encrypt.class);
	public static String hashPwd(String pwd) {
		logger.info("In hashPwd (" + pwd +")");
		String hashed = BCrypt.hashpw(pwd, BCrypt.gensalt());
		logger.info("Out of hashPwd (" + pwd +"), returns : " +hashed);
		return hashed;
	}
	
	public static boolean checkHashedPwd(String pwd, String hashed) {
		logger.info("In checkHashedPwd (" + pwd +", "+hashed +")");
		if (BCrypt.checkpw(pwd,hashed)) {
			logger.debug("It matches");
			return true;
		}
		else {
			logger.debug("It does not match");
			return false;
		}
	}
}
