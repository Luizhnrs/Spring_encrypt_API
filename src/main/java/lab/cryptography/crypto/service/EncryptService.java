package lab.cryptography.crypto.service;

import org.jasypt.util.text.StrongTextEncryptor;

public class EncryptService {
  private static final StrongTextEncryptor encryptor;

  static {
      encryptor = new StrongTextEncryptor();
      encryptor.setPassword(System.getenv("APP_KEY"));
  }
}
