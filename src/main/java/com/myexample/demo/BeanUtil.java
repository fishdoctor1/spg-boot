package com.myexample.demo;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.naming.NamingException;

import org.springframework.beans.BeanUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class BeanUtil {

	private static int SERIAL_MAX_LENGTH = 18;
	private static int SERIAL_MIN_LENGTH = 15;
	private static final String LOV_GET_LNG = "SER_LENGTH";
	private static final String LOV_MAX = "INSERT";
	private static final String LOV_MIN = "VIEW";

	private static BeanUtil instance = null;

	public static synchronized BeanUtil getInstance() {
		if (instance == null) {
			instance = new BeanUtil();
		}
		return instance;
	}
	
	// common
	public static Integer convertStringToInteger(String str)
	{
		Integer num = new Integer(0);
		if (isNumberic(str))
		{
			num = Integer.parseInt(str);
		}
		return num;
	}
	
	public static boolean isNumberic(String num)
	{
		try
		{
			Integer.parseInt(num);
		}
		catch (NumberFormatException nfe)
		{
			return false;
		}
		return true;
	}
	
	public static boolean isBigDecimal(String num){
		try{
			new BigDecimal(num);
		}catch (Exception e) {
			return false;
		}
		return true;
	}



	public static boolean isEmpty(String st){
		boolean b = true;
		if(st!=null && st.trim().length()>0){
			b = false;
		}
		return (b);

	}
	
	public static boolean isEmpty(Object[] st){
		boolean b = true;
		if(st!=null && st.length>0){
			b = false;
		}
		return (b);

	}

	public static boolean isEmpty(StringBuilder st){
		boolean b = true;
		if(st!=null && st.toString().trim().length()>0){
			b = false;
		}
		return (b);

	}

	public static boolean isEmpty(Collection<?> collection) {
		boolean b = true;
		if (collection != null && !collection.isEmpty()) {
			b = false;
		}
		return (b);

	}

	public static boolean isEmpty(Map<?, ?> map) {
		boolean b = true;
		if (map != null && !map.isEmpty()) {
			b = false;
		}
		return (b);
	}

	public static boolean isEmpty(Integer integer){
		boolean b = isNull(integer);
		return (b);

	}

	public static boolean isEmpty(Byte byt){
		boolean b = isNull(byt);
		return (b);

	}

	public static boolean isEmpty(Short s){
		boolean b = isNull(s);
		return (b);

	}

	public static boolean isEmpty(Long l){
		boolean b = isNull(l);
		return (b);

	}

	public static boolean isEmpty(Character c){
		boolean b = isNull(c);
		return (b);

	}

	public static boolean isEmpty(Float f){
		boolean b = isNull(f);
		return (b);

	}

	public static boolean isEmpty(Double d){
		boolean b = isNull(d);
		return (b);

	}

	public static boolean isEmpty(Number num){
		boolean b = isNull(num);
		return (b);

	}

	public static boolean isEmpty(BigDecimal d){
		boolean b = isNull(d);
		return (b);

	}

	public static boolean isNull(Object obj){
		boolean b = true;
		if(obj != null){
			b = false;
		}
		return (b);
	}

	public static Object getDefaultValueIfNull(Object value, Object defaultValue){
		Object result = defaultValue;
		if(value != null){
			result = value;
		}
		return(result);
	}

	public static boolean isNotEmpty(String st){
		boolean b = true;
		if(st ==null || st.trim().length()==0){
			b = false;
		}
		return (b);

	}

	public static boolean isNotEmpty(Collection<?> collection) {
		boolean b = false;
		if (collection != null && !collection.isEmpty()) {
			b = true;
		}
		return (b);

	}

	public static boolean isNotEmpty(Map<?, ?> map) {
		boolean b = false;
		if (map != null && !map.isEmpty()) {
			b = true;
		}
		return (b);
	}

	public static boolean isNotEmpty(Integer integer){
		boolean b = isNotNull(integer);
		return (b);

	}

	public static boolean isNotEmpty(Byte byt){
		boolean b = isNotNull(byt);
		return (b);

	}

	public static boolean isNotEmpty(Short s){
		boolean b = isNotNull(s);
		return (b);

	}

	public static boolean isNotEmpty(Long l){
		boolean b = isNotNull(l);
		return (b);

	}

	public static boolean isNotEmpty(Character c){
		boolean b = isNotNull(c);
		return (b);

	}

	public static boolean isNotEmpty(Float f){
		boolean b = isNotNull(f);
		return (b);

	}

	public static boolean isNotEmpty(Double d){
		boolean b = isNotNull(d);
		return (b);

	}

	public static boolean isNotEmpty(Number num){
		boolean b = isNotNull(num);
		return (b);

	}

	public static boolean isNotEmpty(BigDecimal d) {
		boolean b = (isNotNull(d) && d.compareTo(new BigDecimal(0)) != 0) ? true : false;
		return (b);

	}

	public static boolean isNotEmpty(Object obj){
		boolean b = false;
		if(obj != null){
			b = true;
		}
		return (b);
	}
	
	public static boolean isNotEmpty(Object []obj){
		boolean b = false;
		if(obj != null && obj.length > 0){
			b = true;
		}
		return (b);
	}

	public static boolean isNotNull(Object obj){
		boolean b = false;
		if(obj != null){
			b = true;
		}
		return (b);
	}

	public static boolean isNumber(String numStr) {
		
		// bug  D , F
		/*try {
		 * 
		 * 
			Double.parseDouble(numStr);
			return true;
		} catch (Exception e) {
			return false;
		}*/
		
		
       //fix  xxxxxEx 
		/*try {
			BigDecimal bc = new BigDecimal(numStr);
			return true;
		} catch (Exception e) {
			return false;
		}*/
		
		/*try {
			Long.valueOf(numStr);
			return true;
		} catch (Exception e) {
			return false;
		}*/
		
		if(numStr == null) {
			return false;
		}
		
		if(numStr.indexOf(".") >= 0) {
			try {
				BigDecimal bc = new BigDecimal(numStr);
				return true;
			} catch (Exception e) {
				return false;
			}
		}else {
			try {
				Long.valueOf(numStr);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
	
	public static String lPad(String value, int targetLength) {
		int valueLength = value.length();
		if(value.length() < targetLength) {
			for(int i=0;i<targetLength-valueLength;i++) {
				value = "0" + value;
			}
			return value;
		} else return value;
	}
	
	public static String lPad(Integer value, int targetLength) {
		String valueStr = value.toString();
		int valueLength = value.toString().length();
		if(valueStr.length() < targetLength) {
			for(int i=0;i<targetLength-valueLength;i++) {
				valueStr = "0" + valueStr;
			}
			return valueStr;
		} else return valueStr;
	}
	
	public static String lPad(Long value, int targetLength) {
		String valueStr = value.toString();
		int valueLength = value.toString().length();
		if(valueStr.length() < targetLength) {
			for(int i=0;i<targetLength-valueLength;i++) {
				valueStr = "0" + valueStr;
			}
			return valueStr;
		} else return valueStr;
	}
	
	public static String lPadNumber(String value, int targetLength) {
		if(isNotEmpty(value)) {
			int valueLength = value.length();
			if(isNumber(value)) {
				if(value.length() < targetLength) {
					for(int i=0;i<targetLength-valueLength;i++) {
						value = "0" + value;
					}
					return value;
				} else if(value.length() > targetLength) {
					value = removeZero(value, targetLength);
					return value;
				} else return value;
			} else return value;
		} else return value;
	}
	
	public static String lPadNumber(Integer value, int targetLength) {
		if(isNotEmpty(value)) {
			String valueStr = value.toString();
			int valueLength = value.toString().length();
			if(isNumber(valueStr)) {
				if(valueStr.length() < targetLength) {
					for(int i=0;i<targetLength-valueLength;i++) {
						valueStr = "0" + valueStr;
					}
					return valueStr;
				} else if(valueStr.length() > targetLength) {
					valueStr = removeZero(valueStr, targetLength);
					return valueStr;
				} else return valueStr;
			} else return valueStr;
		} else return (value != null)?value.toString():null;
	}
	
	public static String lPadNumber(Long value, int targetLength) {
		if(isNotEmpty(value)) {
			String valueStr = value.toString();
			int valueLength = value.toString().length();
			if(isNumber(valueStr)) {
				if(valueStr.length() < targetLength) {
					for(int i=0;i<targetLength-valueLength;i++) {
						valueStr = "0" + valueStr;
					}
					return valueStr;
				} else if(valueStr.length() > targetLength) {
					valueStr = removeZero(valueStr, targetLength);
					return valueStr;
				} else return valueStr;
			} else return valueStr;
		} else return (value != null)?value.toString():null;
	}
	
	public static String removeZero(String value, int targetLength) {
		if(isNumber(value)) {
			return value.substring(value.length() - targetLength, value.length());
		} else return value;
	}
	
	public static BigDecimal getDefaultBigDecimalIfNull(BigDecimal value) {
		BigDecimal result = new BigDecimal("0");
		if (value != null) {
			result = value;
		}
		return (result);
	}
	
	public static Collection<?> emptyToNull(Collection<?> collection) {
		if(BeanUtil.isEmpty(collection)){
			return null;
		}
		return collection;
	}
	
	public static String chkString(Object val){
		try {
			return (val != null && !"null".equals(val.toString())) ? val.toString() : "";
		} catch (Exception e) {
			// e.printStackTrace();
		}	
		return "";
	}
	
	public static String formatImei15Digit(String imei){
		try {
			if(BeanUtil.isNotEmpty(imei)){
				if(imei.length() < 15){
					return imei;
				}else{
					return imei.substring(imei.length()-15, imei.length());
				}
			}else{
				return null;
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}	
		return "";
	}
	
	
	public static boolean isDate(String strDate, String format) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
			LocalDate.parse(strDate, formatter);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String str(Object obj){
		if(BeanUtil.isNotEmpty(obj)){
			return (obj+"");
		}
		return "";
	}
	
	public static String convertSerialForSap(String serial){
		String result = "" ;
		try {
			Long.valueOf(serial);
			result = lPadNumber(serial , 18);
		}catch (Exception e) {
			result = serial ;
		}
		return result;
	}
	
	public static String convertMatSapToTDM(String matCodeSap){
		String result = "" ;
		try {
			result = Long.valueOf(matCodeSap).toString();
		}catch (Exception e) {
			result = matCodeSap ;
		}
		return result;
	}

	public static int getSerialMaxLength() {
		return SERIAL_MAX_LENGTH;
	}
	
	public static int getSerialMinLength() {
		return SERIAL_MIN_LENGTH;
	}
	
//	public static void initialSerialLength(LovMasterService lovMasterService) throws NamingException {
//		if (lovMax == null && lovMin == null) {
//			List<LovMaster> lovMaxs = lovMasterService.listLovMasterByCriteria(LOV_GET_LNG, LOV_MAX, null, null, null);
//			List<LovMaster> lovMins = lovMasterService.listLovMasterByCriteria(LOV_GET_LNG, LOV_MIN, null, null, null);
//			lovMax = (isNotEmpty(lovMaxs) ? lovMaxs.get(0) : null);
//			lovMin = (isNotEmpty(lovMins) ? lovMins.get(0) : null);
//			if (lovMax != null)
//				SERIAL_MAX_LENGTH = Integer.parseInt(lovMax.getLovVal().toString());
//			if (lovMin != null)
//				SERIAL_MIN_LENGTH = Integer.parseInt(lovMin.getLovVal().toString());
//		}
//	}
	
	public static boolean isValidCitizenId(String citizenId) {
		if (BeanUtil.isNotEmpty(citizenId) && citizenId.trim().matches("[0-9]{13}")) {
			citizenId = citizenId.trim();
			int result = 0;
			int length = 13;
			int index = 0;
			for (int i = 0; i < citizenId.length() - 1; i++) {
				result = result + Integer.parseInt(String.valueOf(citizenId.charAt(index++))) * length;
				length = length - 1;
			}
			result = 11 - (result % 11);
			String digit = String.valueOf(result).length() == 2 ? String.valueOf(result).substring(1, 2) : String.valueOf(result);
			return digit.equals(String.valueOf(citizenId.charAt(12)));
		}
		return false;
	}
	
	public static boolean isOutOfLength(String inputString, int length) {
		if (BeanUtil.isEmpty(inputString)) {
			return false;
		}

		return (inputString.length() > length);
	}
	
	public static String toString(Number number,int fraction){
		String result = "";
		DecimalFormat df = new DecimalFormat();
			df.setGroupingSize(0);
			df.setMaximumFractionDigits(fraction);
			df.setMinimumFractionDigits(fraction);
			result = df.format(number);
		return result;
	}
	
//	public static String convertNumberToStringDefaultNull(Number num) {
//		return convertNumberToStringDefaultNull(num, 0);
//	}

//	public static String convertNumberToStringDefaultNull(Number num, int digits) {
//
//		if (num == null) {
//			return null;
//		}
//
//		try {
//			return NumberUtils.toString(num, digits);
//		} catch (Exception e) {
//			return null;
//		}
//	}
	
//	public static boolean isNumber(String number, int precision) {
//		return TDMDataValidateUtil.validateNumberNoDigit(number, precision);
//	}
//
//	public static boolean isNumber(String number, int precision, int scale) {
//		return TDMDataValidateUtil.validateNumberDigit(number, precision, scale) || isNumber(number, precision); // support format without `.` (dot)
//	}
	
	public static boolean isNumeric(String text) {
		if (isEmpty(text)) {
			return false;
		}
		return text.matches("[0-9]+");
	}
	
	public static Object cloneData(Object source, Object target) {
		BeanUtils.copyProperties(source, target);
		return target;
	}
	
	public static Date toDate(String date, String format) {
		try {
			DateFormat sdf = new SimpleDateFormat(format, Locale.US);
			return sdf.parse(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		String value = null;
		if(nValue != null){
			value = nValue.getNodeValue();
		}
		return value;

	}
	
	public static String lPadZeroForNumber(String value) {
		String regexDigit = "[0-9]+";
		
		if(isNotEmpty(value) && value.matches(regexDigit)) {
			value = value.replaceFirst("^0+", "");
		}
		
		return value;
	}
	
}

