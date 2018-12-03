package com.ud.basic.common.util;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

/**
 * 排序工具类
 * 
 * @author lzp
 * @date 2018年9月19日
 */
public class SortUtil {

	/**
	 * 对list进行排序
	 * 
	 * @param sortList
	 *            需要排序的list
	 * @param param1
	 *            排序的参数名称
	 * @param orderType
	 *            排序类型：正序-asc；倒序-desc
	 */
	public static List<Object> sort(List<Object> sortList, String param1, String orderType) {
		Comparator<Object> mycmp1 = ComparableComparator.getInstance();
		if ("desc".equals(orderType)) {
			mycmp1 = ComparatorUtils.reversedComparator(mycmp1); // 逆序（默认为正序）
		}

		ArrayList<Object> sortFields = new ArrayList<Object>();
		sortFields.add(new BeanComparator(param1, mycmp1)); // 主排序（第一排序）

		ComparatorChain multiSort = new ComparatorChain(sortFields);
		Collections.sort(sortList, multiSort);

		return sortList;
	}

	/**
	 * 对list进行排序
	 * 
	 * @param sortList
	 *            需要排序的list
	 * @param param1
	 *            排序的参数名称:参数长度
	 * @param param2
	 *            排序的参数名称:排序参数
	 * @param orderType
	 *            排序类型：正序-asc；倒序-desc
	 */
	public static List<Object> sortParam2(List<Object> sortList, String param1, String param2, String orderType) {
		Comparator<Object> mycmp1 = ComparableComparator.getInstance();
		Comparator<Object> mycmp2 = ComparableComparator.getInstance();
		if ("desc".equals(orderType)) {
			mycmp1 = ComparatorUtils.reversedComparator(mycmp1); // 逆序（默认为正序）
		}

		ArrayList<Object> sortFields = new ArrayList<Object>();
		sortFields.add(new BeanComparator(param1, mycmp1)); // 主排序（第一排序）
		sortFields.add(new BeanComparator(param2, mycmp2)); // 主排序（第一排序）

		ComparatorChain multiSort = new ComparatorChain(sortFields);
		Collections.sort(sortList, multiSort);

		return sortList;
	}

	/**
	 * 对list进行排序
	 * 
	 * @param list
	 *            需要排序的list
	 * @param orderType
	 *            排序类型：asc升序，desc降序，默认升序
	 */
	public static List<Map<String, Object>> sort(List<Map<String, Object>> list, String orderType) {
		Collections.sort(list, new Comparator<Map<String, Object>>() {
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				Integer name1 = Integer.valueOf(o1.get("value").toString());
				Integer name2 = Integer.valueOf(o2.get("value").toString());
				if (orderType.equals("desc")) {
					return name2.compareTo(name1);
				}else if(orderType.equals("asc")) {
					return name1.compareTo(name2);
				}
				return name1.compareTo(name2);
			}
		});
		return list;
	}

	/**
	 * 对list排序
	 * 
	 * @param sortList
	 * @param param1
	 * @param orderType
	 * @return
	 */
	public static <T> List<T> commonSort(List<T> sortList, String param, String orderType) {
		Comparator<Object> mycmp1 = ComparableComparator.getInstance();
		if ("desc".equals(orderType)) {
			mycmp1 = ComparatorUtils.reversedComparator(mycmp1); // 逆序（默认为正序）
		}

		ArrayList<Object> sortFields = new ArrayList<Object>();
		sortFields.add(new BeanComparator(param, mycmp1)); // 主排序（第一排序）

		ComparatorChain multiSort = new ComparatorChain(sortFields);
		Collections.sort(sortList, multiSort);

		return sortList;
	}
	
	/**
	 * 对list排序
	 * @param sortList
	 * @param orderType
	 * @return
	 */
	public static List<String> commonSort(List<String> sortList, String orderType){
		Comparator<String> comparator = new Comparator<String>() {
			public int compare(String o1, String o2) {
				String temp = "";
				Collator collator = Collator.getInstance();
				if("desc".equals(orderType)) {
					temp = o1;
					o1 = o2;
					o2 = temp;
				}
				return collator.getCollationKey(o1).compareTo(
						collator.getCollationKey(o2));
			}
		};
		Collections.sort(sortList, comparator);
		return sortList;
	}

}
