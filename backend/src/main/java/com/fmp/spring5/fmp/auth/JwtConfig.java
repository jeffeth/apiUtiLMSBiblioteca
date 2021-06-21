package com.fmp.spring5.fmp.auth;

public class JwtConfig {
	
	public static final String LLAVE_SECRETA="";
	
	public static final String RSA_PRIVADA="-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEowIBAAKCAQEAymL/I5cpIyUIDkNJzMw2+UajVaj/CrUtOGavlIeOIgury9kq\r\n" + 
			"fJZ6zx/pWHYoUR3PUnhPdKts1S0/bO10qmFs43IFy6nqWs3llTDNDi3umusuF6Mq\r\n" + 
			"JHCzxreVWjfskKa+jWEHnkQ4s2wHbFRfxxyD/thuIgziYBDwR5/g/q6steUv1K2k\r\n" + 
			"41+wvc4rZx5HfHEybufKmZbUJo9rvWyDlPKAC3tMfPBeW69RHTHO//AzgifK1zsa\r\n" + 
			"krZMNTLC8AmsTNvYZTIbgEoKsxg+JSvUe87vyVM+w+ONTiHu7LdrHLtbnlNS+Jys\r\n" + 
			"L27GDWU+VNR9JbyREjY0m7OdYF55r6Fbv8nP0QIDAQABAoIBAEPmEJj9JrT+wIQg\r\n" + 
			"eQr3XF4nH7cmWmJaRFCOyss26y1q4vkh44om5g7FMwEVqxMDwEF30ZhfxsSCSKwf\r\n" + 
			"witDQkfQQjeAyvop56M02yatrEZXLoCJoiLVmMrLXpUE/B3Pg1BlRCwJ0UgIrzjd\r\n" + 
			"2cAwRexi6hgMYIpARIyTC+YF7jWblMM2JmP3Mk5PvmMDv78guQGcw2cn8Myc1XLm\r\n" + 
			"3UPaI4xAvy2MkSDWr7HA91mXm9Wt9tKwNAZu6TXkPAFccFNDMDvhBfP58nFBNr75\r\n" + 
			"jFSguF3mpPm1VnmiFxRvqnPhVUqodAx5amCQBC0mrW7SiBvN32eGM2DCxqNftzuC\r\n" + 
			"lcCOXR0CgYEA5Vi1vZSBzVRzrOuTwReCWtv/xFtsBnLraMb6T7v1bPtN1h5DViUG\r\n" + 
			"Tl67ao8fnIXNerLPOz9jhoUBKNmoqjyf7GI7fRXZNKcQ8N5bUdpRnGjCVkbFvKNZ\r\n" + 
			"4hF4zcIHsSz5vJJA1V5t7hKafibJFLO5sYpHnar6OBkFBcnnfuRtxIMCgYEA4eg0\r\n" + 
			"efEV0b4pjKTBsYW0B87TPbNXPw3Mb6rF5Gi4PyDY53ULqRVf06RWx5yAMC8nk90J\r\n" + 
			"TdL4DV3KEkYQgqSq9S+H28yJSDTmesO7PwQ2R1eun4cvKVGxQY8rrCKGkctMBsr8\r\n" + 
			"Y7kkRvAU+DaFcQ60yoiZqjjUOojcoU2q2f2xshsCgYBBBi646mMG6TvGuh/xLg4q\r\n" + 
			"Xpecf2MYTPrLgSa09pB17qY53+itgt/P1nICm0OWKCWC9TFmFenM2ObkQxnb8kZR\r\n" + 
			"SeSd6VTk5b0a3aA8i855rwXyWixz+EhinRuIEswFgr/no/u3wwcd6a5dt/do5C/w\r\n" + 
			"00jMvg4lW4qeAomc43zvqwKBgQCKt965XmwKjl3PKkByNOrWvI8EXULeyidWDqRT\r\n" + 
			"3GX/BbmLb1kIq8JbIJfVHOmuLNZ9uoYDDuAYvRXfYLy0rE76HgSr2I4YE7vPeK9b\r\n" + 
			"Q8fcyR/Gf+la0vooirTDj7PYhOCbbzvKNJ7tHHGT9U69nM0xbO4HE7xmcTIhrqKS\r\n" + 
			"F3FtLwKBgAUx0bB7vuo15JrqPPvenoRtcnVlpQd7Lz49GVjdeomc0fJeQuHryeIY\r\n" + 
			"lAAyQGvB/ToRTKXtHmXFhFnvyhAmlTm5+bOaa8FFg7ZkBy2JQSmKVY48TGUefznL\r\n" + 
			"mM7qPY5gFpXy/Ptk9Y1gP+aJil9CM5WR1SPU/ePoZ/DE8/a8RUTU\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA="-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAymL/I5cpIyUIDkNJzMw2\r\n" + 
			"+UajVaj/CrUtOGavlIeOIgury9kqfJZ6zx/pWHYoUR3PUnhPdKts1S0/bO10qmFs\r\n" + 
			"43IFy6nqWs3llTDNDi3umusuF6MqJHCzxreVWjfskKa+jWEHnkQ4s2wHbFRfxxyD\r\n" + 
			"/thuIgziYBDwR5/g/q6steUv1K2k41+wvc4rZx5HfHEybufKmZbUJo9rvWyDlPKA\r\n" + 
			"C3tMfPBeW69RHTHO//AzgifK1zsakrZMNTLC8AmsTNvYZTIbgEoKsxg+JSvUe87v\r\n" + 
			"yVM+w+ONTiHu7LdrHLtbnlNS+JysL27GDWU+VNR9JbyREjY0m7OdYF55r6Fbv8nP\r\n" + 
			"0QIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";

}
