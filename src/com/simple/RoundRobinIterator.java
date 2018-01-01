package com.simple;

import java.util.List;

/*lists
L1 1 2 3 4
L2 5 6
L3 7
*/
public class RoundRobinIterator {

	private List<List<Object>> listOfLists;

	private Integer listNumber = 0;

	public RoundRobinIterator(List<List<Object>> listOfLists) {
		this.listOfLists = listOfLists;
	}

	int i = 0;

	public Object next() {

		List<Object> listToBeTraveresed = listOfLists.get(i);

		if (listNumber > listOfLists.size()) {
			listNumber = 0;
		}

		if (listToBeTraveresed.size() == 0) {
			listNumber++;
		}

		Object next = null;

		for (Object obj : listToBeTraveresed) {
			listToBeTraveresed.remove(obj);
			break;
		}

		listNumber++;

		return next;

	}

}
