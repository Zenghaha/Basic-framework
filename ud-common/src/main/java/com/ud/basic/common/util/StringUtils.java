package com.ud.basic.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.Collection;
import java.util.Set;
import java.util.StringTokenizer;

@SuppressWarnings("rawtypes")
public class StringUtils {
	
	public static final String STR_ZERO = "0";
	
	public static final String DEFAULT_NUM = STR_ZERO;

	/**
	 * 把字节数组转换为对象
	 * 
	 * @param bytes
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	/*
	 * public static final Object bytesToObject(byte[] bytes) throws
	 * IOException, ClassNotFoundException { ByteArrayInputStream in = new
	 * ByteArrayInputStream(bytes); ObjectInputStream oi = new
	 * ObjectInputStream(in); Object o = oi.readObject(); oi.close(); return o;
	 * }
	 */

	/**
	 * 把可序列化对象转换成字节数组
	 * 
	 * @param s
	 * @return
	 * @throws IOException
	 */
	public static final byte[] objectToBytes(Serializable s) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream ot = new ObjectOutputStream(out);
		ot.writeObject(s);
		ot.flush();
		ot.close();
		return out.toByteArray();
	}

	public static final String objectToHexString(Serializable s) throws IOException {
		return bytesToHexString(objectToBytes(s));
	}

	/**
	 * @函数功能: BCD码转为10进制串(阿拉伯数据)
	 * @输入参数: BCD码
	 * @输出结果: 10进制串
	 */
	public static String bcd2Str(byte[] bytes) {
		StringBuffer temp = new StringBuffer(bytes.length * 2);

		for (int i = 0; i < bytes.length; i++) {
			temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
			temp.append((byte) (bytes[i] & 0x0f));
		}
		return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp.toString().substring(1) : temp.toString();
	}

	/**
	 * @函数功能: 10进制串转为BCD码
	 * @输入参数: 10进制串
	 * @输出结果: BCD码
	 */
	public static byte[] str2Bcd(String asc) {
		int len = asc.length();
		int mod = len % 2;

		if (mod != 0) {
			asc = "0" + asc;
			len = asc.length();
		}

		byte abt[] = new byte[len];
		if (len >= 2) {
			len = len / 2;
		}

		byte bbt[] = new byte[len];
		abt = asc.getBytes();
		int j, k;

		for (int p = 0; p < asc.length() / 2; p++) {
			if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
				j = abt[2 * p] - '0';
			} else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
				j = abt[2 * p] - 'a' + 0x0a;
			} else {
				j = abt[2 * p] - 'A' + 0x0a;
			}

			if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
				k = abt[2 * p + 1] - '0';
			} else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
				k = abt[2 * p + 1] - 'a' + 0x0a;
			} else {
				k = abt[2 * p + 1] - 'A' + 0x0a;
			}

			int a = (j << 4) + k;
			byte b = (byte) a;
			bbt[p] = b;
		}
		return bbt;
	}

	/**
	 * @函数功能: BCD码转ASC码
	 * @输入参数: BCD串
	 * @输出结果: ASC码
	 */
	public static String BCD2ASC(byte[] bytes) {
		StringBuffer temp = new StringBuffer(bytes.length * 2);

		String[] BToA = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		for (int i = 0; i < bytes.length; i++) {
			int h = ((bytes[i] & 0xf0) >>> 4);
			int l = (bytes[i] & 0x0f);

			temp.append(BToA[h]).append(BToA[l]);
		}
		return temp.toString();
	}

	/**
	 * MD5加密字符串，返回加密后的16进制字符串
	 * 
	 * @param origin
	 * @return
	 */
	public static String MD5EncodeToHex(String origin) {
		return bytesToHexString(MD5Encode(origin));
	}

	/**
	 * MD5加密字符串，返回加密后的字节数组
	 * 
	 * @param origin
	 * @return
	 */
	public static byte[] MD5Encode(String origin) {
		return MD5Encode(origin.getBytes());
	}

	/**
	 * MD5加密字节数组，返回加密后的字节数组
	 * 
	 * @param bytes
	 * @return
	 */
	public static byte[] MD5Encode(byte[] bytes) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			return md.digest(bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return new byte[0];
		}

	}

	public static String getFormattedNum(String num, int len) {
		int numLen = num == null ? 0 : num.length();
		StringBuffer buf = new StringBuffer();
		len = len - numLen;
		for (int i = 0; i < len; i++) {
			buf.append(DEFAULT_NUM);
		}

		return numLen > 0 ? buf.append(num).toString() : buf.toString();
	}

	public static String getRepeatSpace(int len) {
		return getRepeatString(" ", len);
	}

	public static String getRepeatZero(int len) {
		return getRepeatString("0", len);
	}

	public static String getRepeatString(String s, int len) {
		StringBuffer buf = new StringBuffer(len);
		for (int i = 0; i < len; i++) {
			buf.append(s);
		}
		return buf.toString();
	}

	public static byte[] toByteArray(String hexStr) {
		byte[] bytes = null;

		if (hexStr != null) {
			if (hexStr.startsWith("0x") || hexStr.startsWith("0X")) {
				hexStr = hexStr.substring(2);
			}
			int len = hexStr.length();

			if (len % 2 != 0) {
				throw new IllegalStateException("invalid hex string: " + hexStr);
			}

			len = len / 2;
			bytes = new byte[len];
			int idx = 0;

			for (int i = 0; i < len; i++) {
				bytes[i] = (byte) (0xff & Integer.parseInt(hexStr.substring(idx, idx + 2), 16));
				idx += 2;
			}
		}

		return bytes == null ? new byte[0] : bytes;
	}

	public static String toHexString(byte[] bytes) {
		StringBuffer buf = new StringBuffer();
		int len = bytes == null ? 0 : bytes.length;

		String str = null;

		for (int i = 0; i < len; i++) {
			str = Integer.toHexString(0xff & bytes[i]);
			buf.append(str.length() < 2 ? STR_ZERO.concat(str) : str);
		}

		return buf.toString();
	}

	public static String toBinString(byte[] bytes) {
		StringBuffer buf = new StringBuffer();
		for (int j = 0; j < bytes.length; j++) {
			for (int i = 7; i >= 0; i--) {
				if (((1 << i) & bytes[j]) != 0) {
					buf.append("1");
				} else {
					buf.append("0");
				}
			}
		}
		return buf.toString();
	}

	public static String[] split(String source, String delim) {
		int i = 0;
		int l = 0;
		if (source == null || delim == null)
			return new String[0];
		if (source.equals("") || delim.equals(""))
			return new String[0];

		StringTokenizer st = new StringTokenizer(source, delim);
		l = st.countTokens();
		String[] s = new String[l];
		while (st.hasMoreTokens()) {
			s[i++] = st.nextToken();
		}
		return s;
	}

	public static String bytesToHexString(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	public static byte[] hexString2Bytes(String hexStr) {
		byte[] baKeyword = new byte[hexStr.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(hexStr.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return baKeyword;
	}

	public static String addZero(String str, int len) {
		for (int i = 0; i < len - str.length(); i++) {
			str = "0" + str;
		}
		return str;
	}

	/** 字符串转字节数组 * */
	public static byte[] Str2Hex(String str) {
		char[] ch = str.toCharArray();
		byte[] b = new byte[ch.length / 2];
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == 0)
				break;
			if (ch[i] >= '0' && ch[i] <= '9') {
				ch[i] = (char) (ch[i] - '0');
			} else if (ch[i] >= 'A' && ch[i] <= 'F') {
				ch[i] = (char) (ch[i] - 'A' + 10);
			}
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (((ch[2 * i] << 4) & 0xf0) + (ch[2 * i + 1] & 0x0f));
		}
		return b;
	}

	/**
	 * 转成16进制
	 * 
	 * @param b
	 * @return
	 */
	public static String Hex2Str(byte[] b) {
		StringBuffer d = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			char hi = Character.forDigit((b[i] >> 4) & 0x0F, 16);
			char lo = Character.forDigit(b[i] & 0x0F, 16);
			d.append(Character.toUpperCase(hi));
			d.append(Character.toUpperCase(lo));
		}
		return d.toString();
	}

	public static String SetToString(Set value) {
		String b = "";
		if (null != value && value.size() > 0) {
			String a = value.toString();
			int len = a.length();
			b = a.substring(1, len - 1);
		}
		return b;
	}

	/**
	 * 将Collection转换成字符串
	 * @param value 顺序集合
	 * @param delim 分隔的字符，默认为英文逗号
	 * @return
	 */
	public static String CollectionToString(Collection value,Character delim) {
		char del=',';//默认用英文逗号分隔
		if(delim!=null)del=delim;
		Object[] a = value.toArray();
		String b = "";
		if (null != a && a.length > 0) {
			for (int i = 0; i < a.length; i++) {
				b += a[i] + ""+del;
			}
		}
		if(b.length()>0)b=b.substring(0,b.length()-1);
		return b;
	}

	/**
	 * 按length填充String 不足左补零
	 */
	public static String fillString(String value, int length) {
		int len;
		String a = "";
		if (value != null) {
			value = value.trim();
			len = value.length();
		} else {
			return null;
		}
		if (len < length) {
			for (int i = 0; i < length - len; i++) {
				a += "0";
			}
		}
		return a + value;
	}

	/**
	 * 按length填充String 不足右补零
	 */
	public static String rightFillString(String value, int length) {
		int len;
		String a = "";
		if (value != null) {
			value = value.trim();
			len = value.length();
		} else {
			return null;
		}
		if (len < length) {
			for (int i = 0; i < length - len; i++) {
				a += "0";
			}
		}
		return value + a;
	}

	/**
	 * 左去0
	 */
	public static String lRemoveZero(String value) {
		if (value == null) {
			return null;
		}
		value = value.replaceAll("^(0+)", "");
		return value;
	}

	// 按length填充String 不足前补空格
	public static String blankFillString(String value, int length) {
		String a = "";
		int len = value.length();
		if (len < length) {
			for (int i = 0; i < length - len; i++) {
				a += " ";
			}
		}
		return a + value;
	}

	public static byte[] fillByteArray(byte[] a, int length) {
		byte[] msg = new byte[length];
		if (a.length < length) {
			int len = length - a.length;
			byte[] b = new byte[len];
			for (int i = 0; i < len; i++) {
				b[i] = 0;
			}
			System.arraycopy(a, 0, msg, 0, a.length);
			System.arraycopy(b, 0, msg, a.length, b.length);
		}
		return msg;
	}

	/**
	 * 10进制转2进制
	 * 
	 * @param value
	 * @return
	 */
	public static byte[] StringTobyte(int sizeItr) {
		int lenFieldLen = 8;
		byte[] body = new byte[lenFieldLen];
		byte byteLen = 0;
		for (int i = lenFieldLen - 1; i >= 0; i--) {
			byteLen = (byte) (sizeItr % 256);
			body[lenFieldLen - i - 1] = byteLen;
			sizeItr = sizeItr / 256;
		}
		return body;
	}

	/** Common Method：Print the data with HEX format **/
	public static void OutputDataHex(String sInfo, byte[] byteIn, int nDataLen) {
		int i, j, n, prev;
		StringBuffer sb = new StringBuffer();
		sb.append("[").append(sInfo).append("] length [").append(nDataLen).append("]");
		prev = n = 0;
		for (i = 0; i < nDataLen; i++) {
			if (i == (prev + 16)) {
				sb.append("    ;");
				for (j = prev; j < prev + 16; j++) {
					if (Character.isLetter((char) (byteIn[j] & 0xff)) == true) {
						sb.append((char) byteIn[j]);
					} else {
						sb.append(" ");
					}
				}
				prev += 16;
				sb.append("\n");
			}
			if (Integer.toHexString(byteIn[i] & 0xff).length() == 1) {
				sb.append("0").append(Integer.toHexString(byteIn[i] & 0xff)).append(" ");
			} else {
				sb.append(Integer.toHexString(byteIn[i] & 0xff)).append(" ");
			}
		}
		if (i != prev) {
			n = i;
			for (; i < prev + 16; i++) {
				sb.append("   ");
			}
		}
		sb.append("    ;");
		for (i = prev; i < n; i++) {
			if (Character.isLetter((char) byteIn[i]) == true) {
				sb.append((char) byteIn[i]);
			} else {
				sb.append(" ");
			}
		}
		sb.append("\n");
	}

	public static boolean Str2Hex(byte[] in, byte[] out, int len) {
		byte[] asciiCode = { 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f };

		if (len > in.length) {
			return false;
		}

		if (len % 2 != 0) {
			return false;
		}

		byte[] temp = new byte[len];

		for (int i = 0; i < len; i++) {
			if (in[i] >= 0x30 && in[i] <= 0x39) {
				temp[i] = (byte) (in[i] - 0x30);
			} else if (in[i] >= 0x41 && in[i] <= 0x46) {
				temp[i] = asciiCode[in[i] - 0x41];
			} else if (in[i] >= 0x61 && in[i] <= 0x66) {
				temp[i] = asciiCode[in[i] - 0x61];
			} else {
				return false;
			}
		}

		for (int i = 0; i < len / 2; i++) {
			out[i] = (byte) (temp[2 * i] * 16 + temp[2 * i + 1]);
		}

		return true;
	}

	public static boolean Hex2Str(byte[] in, byte[] out, int len) {
		byte[] asciiCode = { 0x41, 0x42, 0x43, 0x44, 0x45, 0x46 };

		if (len > in.length) {
			return false;
		}

		byte[] temp = new byte[2 * len];

		for (int i = 0; i < len; i++) {
			temp[2 * i] = (byte) ((in[i] & 0xf0) / 16);
			temp[2 * i + 1] = (byte) (in[i] & 0x0f);
		}

		for (int i = 0; i < 2 * len; i++) {
			if (temp[i] <= 9 && temp[i] >= 0) {
				out[i] = (byte) (temp[i] + 0x30);
			} else {
				out[i] = asciiCode[temp[i] - 0x0a];
			}
		}

		return true;
	}

	/** Convert bye to HEX **/
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";

		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;

			}
			if (n < b.length - 1) {
				hs = hs + " ";
			}
		}

		return hs.toUpperCase();
	}
}
