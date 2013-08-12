package com.archer.livequote.fyp.service;

import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;

import static org.springframework.security.crypto.util.EncodingUtils.concatenate;
import static org.springframework.security.crypto.util.EncodingUtils.subArray;

/**
 * Added AES 128 support
 *
 * @author: ayang
 * @see org.springframework.security.crypto.encrypt.AesBytesEncryptor
 */
public class AesBytesEncryptor implements BytesEncryptor {
    private final SecretKey secretKey;

    private final Cipher encryptor;

    private final Cipher decryptor;

    private final BytesKeyGenerator ivGenerator;

    public AesBytesEncryptor(String password, CharSequence salt, BytesKeyGenerator ivGenerator, int length) {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray(), Hex.decode(salt), 1024, length);
        SecretKey secretKey = newSecretKey("PBKDF2WithHmacSHA1", keySpec);
        this.secretKey = new SecretKeySpec(secretKey.getEncoded(), "AES");
        encryptor = newCipher(AES_ALGORITHM);
        decryptor = newCipher(AES_ALGORITHM);
        this.ivGenerator = ivGenerator != null ? ivGenerator : NULL_IV_GENERATOR;
    }

    public AesBytesEncryptor(String password, CharSequence salt, BytesKeyGenerator ivGenerator) {
        this(password, salt, ivGenerator, 256);
    }

    public byte[] encrypt(byte[] bytes) {
        synchronized (encryptor) {
            byte[] iv = ivGenerator.generateKey();
            initCipher(encryptor, Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
            byte[] encrypted = doFinal(encryptor, bytes);
            return ivGenerator != NULL_IV_GENERATOR ? concatenate(iv, encrypted) : encrypted;
        }
    }

    public byte[] decrypt(byte[] encryptedBytes) {
        synchronized (decryptor) {
            byte[] iv = iv(encryptedBytes);
            initCipher(decryptor, Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
            return doFinal(decryptor, ivGenerator != NULL_IV_GENERATOR ? encrypted(encryptedBytes, iv.length) : encryptedBytes);
        }
    }

    /**
     * Initializes the Cipher for use.
     */
    private static void initCipher(Cipher cipher, int mode, SecretKey secretKey, AlgorithmParameterSpec parameterSpec) {
        try {
            if (parameterSpec != null) {
                cipher.init(mode, secretKey, parameterSpec);
            } else {
                cipher.init(mode, secretKey);
            }
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException("Unable to initialize due to invalid secret key", e);
        } catch (InvalidAlgorithmParameterException e) {
            throw new IllegalStateException("Unable to initialize due to invalid decryption parameter spec", e);
        }
    }

    // internal helpers

    private byte[] iv(byte[] encrypted) {
        return ivGenerator != NULL_IV_GENERATOR ? subArray(encrypted, 0, ivGenerator.getKeyLength()) : NULL_IV_GENERATOR.generateKey();
    }

    private byte[] encrypted(byte[] encryptedBytes, int ivLength) {
        return subArray(encryptedBytes, ivLength, encryptedBytes.length);
    }

    private static final String AES_ALGORITHM = "AES/CBC/PKCS5Padding";

    private static final BytesKeyGenerator NULL_IV_GENERATOR = new BytesKeyGenerator() {

        private final byte[] VALUE = new byte[16];

        public int getKeyLength() {
            return VALUE.length;
        }

        public byte[] generateKey() {
            return VALUE;
        }

    };

    /**
     * Generates a SecretKey.
     */
    private static SecretKey newSecretKey(String algorithm, PBEKeySpec keySpec) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance(algorithm);
            return factory.generateSecret(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Not a valid encryption algorithm", e);
        } catch (InvalidKeySpecException e) {
            throw new IllegalArgumentException("Not a valid secret key", e);
        }
    }

    /**
     * Constructs a new Cipher.
     */
    private static Cipher newCipher(String algorithm) {
        try {
            return Cipher.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Not a valid encryption algorithm", e);
        } catch (NoSuchPaddingException e) {
            throw new IllegalStateException("Should not happen", e);
        }
    }

    /**
     * Invokes the Cipher to perform encryption or decryption (depending on the initialized mode).
     */
    private static byte[] doFinal(Cipher cipher, byte[] input) {
        try {
            return cipher.doFinal(input);
        } catch (IllegalBlockSizeException e) {
            throw new IllegalStateException("Unable to invoke Cipher due to illegal block size", e);
        } catch (BadPaddingException e) {
            throw new IllegalStateException("Unable to invoke Cipher due to bad padding", e);
        }
    }

}
