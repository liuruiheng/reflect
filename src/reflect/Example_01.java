package reflect;

public class Example_01 {

	String string;
	int i,i2,i3;
	public Example_01() {
	}
	public Example_01(String string, int i) {
		this.string = string;
		this.i = i;
	}
	public Example_01(String... string) throws NumberFormatException {
		if (0 < string.length) {
			i = Integer.valueOf(string[0]);
		}
		if (1 < string.length) {
			i2 = Integer.valueOf(string[1]);
		}
		if (2 < string.length) {
			i3 = Integer.valueOf(string[2]);
		}
	}
	public void print() {
		System.out.println("s="+string);
		System.out.println("i="+i);
		System.out.println("i2="+i2);
		System.out.println("i3="+i3);
	}
}
