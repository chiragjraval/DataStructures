package com.chirag.ds.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class ListUtil {

	@SafeVarargs
	public static <T> List<T> getNonNullList(T... values) {
		List<T> list = new ArrayList<>();
		Arrays.stream(values).filter(value -> Objects.nonNull(value)).forEach(value -> list.add(value));
		return list;
	}
	
	@SafeVarargs
	public static <T> void addNonNullToList(List<T> list, T... values) {
		Arrays.stream(values).filter(value -> Objects.nonNull(value)).forEach(value -> list.add(value));
	}
	
	@SafeVarargs
	public static <T> ListIterator<T> getListIterator(T... values) {
		List<T> list = new ArrayList<>();
		Arrays.stream(values).forEach(value -> list.add(value));
		return list.listIterator();
	}
	
	@SafeVarargs
	public static <T> void addNonNullToListIterator(ListIterator<T> listIterator, T... values) {
		Arrays.stream(values).filter(value -> Objects.nonNull(value)).forEach(value -> listIterator.add(value));
		Arrays.stream(values).filter(value -> Objects.nonNull(value)).forEach(value -> listIterator.previous());
	}
}
