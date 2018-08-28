class Table {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int b[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.print("  *  ");
		for (int i = 0; i < 10; i++) {
			System.out.printf(a[i] > 9 ? "|  " + a[i] + " " : "|   " + a[i] + " ");
		}
		System.out.println();
		for (int j = 0; j < 10; j++) {
			line();
			System.out.print(b[j] > 9 ? "  " + b[j] + " " : "   " + b[j] + " ");
			for (int i = 0; i < 10; i++) {
				System.out.printf(
						b[j] * a[i] > 9 ? (b[j] * a[i] > 99 ? "| " + b[j] * a[i] + " " : "|  " + b[j] * a[i] + " ")
								: "|   " + b[j] * a[i] + " ");
			}
			System.out.println();
		}
	}

	static void line() {
		for (int i = 0; i < 10; i++) {
			System.out.print("-----+");
		}
		System.out.printf("-----\n");
	}
}