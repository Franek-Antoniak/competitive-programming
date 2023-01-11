package com.leetcode;

import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator {
	interface NestedInteger {
		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		List<NestedInteger> getList();
	}

	class NestedIterator implements Iterator<Integer> {
		Iterator<NestedInteger> list;
		NestedIterator nestedIterator;
		NestedInteger currentInteger;

		public NestedIterator(List<NestedInteger> nestedList) {
			this.list = nestedList.iterator();
		}

		public void clear() {
			nestedIterator = null;
			currentInteger = null;
		}

		@Override
		public boolean hasNext() {
			if (nestedIterator == null && !list.hasNext() && currentInteger == null) {
				return false;
			} else if (nestedIterator != null && nestedIterator.hasNext()) {
				return true;
			}
			if (currentInteger == null) {
				currentInteger = list.next();
			}
			if (currentInteger.isInteger()) {
				return true;
			}
			nestedIterator = new NestedIterator(currentInteger.getList());
			boolean isNestedHasNext = nestedIterator.hasNext();
			if (isNestedHasNext)
				return true;
			clear();
			return hasNext();
		}

		@Override
		public Integer next() {
			if (currentInteger.isInteger()) {
				int result = currentInteger.getInteger();
				clear();
				return result;
			}
			if (nestedIterator == null) {
				nestedIterator = new NestedIterator(currentInteger.getList());
				if (nestedIterator.hasNext()) {
					return nestedIterator.next();
				}
			}
			if (nestedIterator.hasNext()) {
				int result = nestedIterator.next();
				if (!nestedIterator.hasNext()) {
					clear();
				}
				return result;
			}
			return next();
		}
	}
}

