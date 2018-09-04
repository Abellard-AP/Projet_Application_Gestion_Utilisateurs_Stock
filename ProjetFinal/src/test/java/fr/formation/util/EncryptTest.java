package fr.formation.util;

import org.junit.Test;

public class EncryptTest {

	@Test
	public void testHashPwd() {
		Encrypt e = new Encrypt();
		e.hashPwd("eva");
	}

	@Test
	public void testCheckHashedPwd() {
		Encrypt e = new Encrypt();
		e.checkHashedPwd("eva", e.hashPwd("eva"));
	}

}
