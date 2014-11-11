package at.bestsolution.framework.grid;

import java.util.Comparator;

@FunctionalInterface
	public interface ColumnComparator<R, C> {
		public int compare(R r1, C c1, R r2, C c2);

		public static <R, C> ColumnComparator<R, C> create(Comparator<C> c) {
			return new ColumnComparator<R, C>() {

				@Override
				public int compare(R r1, C c1, R r2, C c2) {
					return c.compare(c1, c2);
				}

			};
		}
	}