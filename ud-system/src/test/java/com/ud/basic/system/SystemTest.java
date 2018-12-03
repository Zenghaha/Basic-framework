package com.ud.basic.system;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.primitives.Ints;
import com.ud.basic.system.util.RightsHelper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.ud.basic.common.util.DateUtil;
import com.ud.basic.common.util.IdGenUtil;

public class SystemTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
		String pwd = encoder.encode("123456".trim());
		System.out.println(pwd); 
//		
//		List<Integer> list = Arrays.asList(1,2,3);
//		String jsonStr = JSON.toJSONString(list);
//		System.out.println(jsonStr);
//		List<String> strs = JSON.parseArray(jsonStr, String.class);
//		Set<Integer> s = new HashSet<>();
//		s.addAll(list);
//		System.out.println(JSON.toJSONString(new int[] {1}));
//		JSONArray ja = JSON.parseArray(JSON.toJSONString(new int[] {1}));
//		ja.add(2);
//		System.out.println(JSON.toJSONString(ja));
//		Ints.asList(new int[] {1});
//		
//		BigInteger right = RightsHelper.sumRights(s);
//		BigInteger right2 = RightsHelper.sumRights(new String[] {"1","2","3"});
//		System.out.println(right.toString());
//		System.out.println(right2.toString());
//		
//		System.out.println(IdGenUtil.getId());
//		Long l = Long.valueOf(1);
//		if(l == 1) {
//			System.out.println("sfasdfd");
//		}
		String[] strs1 = new String[] {"1","2"};
		BigInteger right1 = RightsHelper.sumRights(strs1);
		System.out.println(right1);
		String[] strs2 = new String[] {"4","5","6"};
		BigInteger right2 = RightsHelper.sumRights(strs2);
		System.out.println(right2);
		String[] strs3 = new String[] {"4","5","6","7"};
		BigInteger right3 = RightsHelper.sumRights(strs3);
		System.out.println(right3);
		System.out.println("+++"+new BigInteger("242").testBit(7));
		String right = RightsHelper.sumRights(right1.toString(), strs2); //242
		right = RightsHelper.sumRights(right.toString(), strs3);
		System.out.println(right);
		
		String[] strs4 = new String[] {"1","4","5","6","7"};
		BigInteger right4 = RightsHelper.sumRights(strs4);
		System.out.println(right4);
		BigInteger bigInteger  =new BigInteger("7");
		System.out.println(bigInteger.setBit(7));
		Map<String, String> map = new HashMap<>();
		map.put("a", "1");
		System.out.println(map.get("b"));
		
		
		
		String[] strs5 = new String[] {"236","237","238","239","240","241","242","243","244","245","246","247","248","249","250","251","252","253","254","255","256","257","258","259","260","261","262","263","264","265","266","267","268","269","270","271","272","273","274","275","276","277","278","279","280","281","282","283","284","285","286","287","288","289","290","291","292","293","294","295","296","297","298","299","300","301","302","303","304","305","306","307","308","309","310","311","312","313","314","315","316","317","318","319","320","321","322","323","324","325","326","327","328","329","330","331","332","333","334","335","336","337","338","339","340","341","342","343","344","345","346","347","348","349","350","351","352","353","354","355","356","357","358","359","360","361","362","363","364","365","366","367","368","369","370","371","372","373","374","375","376","377","378","379","380","381","382","383","384","385","386","387","388","389","390","391","392","393","394","395","396","397","398","399","400","401","402","403","404","405","406","407","408","409","410","411","412","413","414","415","416","417","418","419","420","421","422","423","424","425","426","427","428","429","430","431","432","433","434","435","436","437","438","439","440","441","442","443","444","445","446","447","448","449","450","451","452"};
		BigInteger right5 = RightsHelper.sumRights(strs5);
		System.out.println(right5);
		HttpServletRequest request;
				
		List<String> subs = Arrays.asList("admin", "1");
		String sub = JSON.toJSONString(subs);
		String token = Jwts.builder()
		           .setSubject(sub)
		           .setExpiration(DateUtil.addDate("yy", 12, Calendar.getInstance().getTime()))
		           .signWith(SignatureAlgorithm.HS512, "ud_es")
		           .compact();
		System.out.println(token);
	}
	
	
}
