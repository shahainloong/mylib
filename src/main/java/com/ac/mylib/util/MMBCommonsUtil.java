package com.ac.mylib.util;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.BaseEncoding;

/**
 * 这是我自己为旧MMB写的工具包
 *  
 * @author hailong.sha
 *
 */
public class MMBCommonsUtil {
    // spring官方提供的log写法
    private final static Logger logger = LoggerFactory.getLogger(MMBCommonsUtil.class);

    /**
     * 这是为MMB写的获取支付签名的方法，通过私钥和K-V键值对来生成签名
     * 
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @return String
     */
    public static String mmbGetHMACSignature() throws InvalidKeyException, NoSuchAlgorithmException {
        
        String HMAC_KEY = "53BC5F6A368DDAB4699E0BC3BED680BC4A424F71E5DBC898CE951136503EE025";
        Map<String, String> pairs = new HashMap<>();
        pairs.put("shopperLocale", "en_GB");
        pairs.put("merchantReference", "paymentTest:143522\\64\\39255");
        pairs.put("merchantAccount", "TestMerchant");
        pairs.put("sessionValidity", "2018-07-25T10:31:06Z");
        pairs.put("shipBeforeDate", "2018-07-30");
        pairs.put("paymentAmount", "1995");
        pairs.put("currencyCode", "EUR");
        pairs.put("skinCode", "vjajJZXc");
        pairs.put("merchantReturnData", "http://cep-admin-cit.cathaypacific.com/cx/en_HK.html");
        pairs.put("shopperEmail", "hailong_sha@cathaypacific.com");
        
        // 1. Sort the key-value pairs by key.
        SortedMap<String, String> sortedPairs = new TreeMap<>(pairs);
        // 2. Replace null values with an empty string ("") and escape the
        // following characters in the value of each pair:
        // "\" (backslash) as "\\"
        // ":" (colon) as "\:"
        SortedMap<String, String> escapedPairs = sortedPairs.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(),
                        e -> (e.getValue() == null) ? "" : e.getValue().replace("\\", "\\\\").replace(":", "\\:"),
                        (k, v) -> k, TreeMap::new));
        // 3. Concatenate the key names, first, followed by the values. Use a
        // colon (“:”) to delimit the key names and values to obtain the signing
        // string.
        String signingString = Stream.concat(escapedPairs.keySet().stream(), escapedPairs.values().stream())
                .collect(Collectors.joining(":"));
        // 4. Convert the HMAC key to the binary representation. Note that the
        // HMAC key is considered as hexadecimal value.
        // import from com.google.common.io.BaseEncoding;
        byte[] binaryHmacKey = BaseEncoding.base16().decode(HMAC_KEY);
        // 5. Calculate the HMAC with the signing string, in binary
        // representation given the UTF-8 charset, using the cryptographic hash
        // function SHA-256.
        // Create an HMAC SHA-256 key from the raw key bytes
        SecretKeySpec signingKey = new SecretKeySpec(binaryHmacKey, "HmacSHA256");

        // Get an HMAC SHA-256 Mac instance and initialize with the signing key
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);

        // calculate the hmac on the binary representation of the signing string
        byte[] binaryHmac = mac.doFinal(signingString.getBytes(Charset.forName("UTF8")));
        // 6. Encode the result using the Base64 encoding scheme to obtain the
        // signature.
        String signature = Base64.getEncoder().encodeToString(binaryHmac);

        return signature;
    }

    /**
     * Utility classes should not have public constructors 
     */
    private MMBCommonsUtil() {
        super();
    }
    
}
