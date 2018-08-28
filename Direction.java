class Direction {
	public static void main(String[] args) {
		switch (args[0].charAt(0)) {
		case 'N':
			System.out.println(0);
			break;
		case 'E':
			System.out.println(90);
			break;
		case 'S':
			System.out.println(180);
			break;
		case 'W':
			System.out.println(270);
			break;
		default:
			System.out.println("Error");
			System.exit(1);
		}
	}
}