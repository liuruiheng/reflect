package main01;

import java.lang.reflect.Field;

public class Main_02 {

	public static void main(String[] args) {
		Example_02 example = new Example_02();
		Class<? extends Example_02> exampleC = example.getClass();
		Field[] declaredFields = exampleC.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			Field field = declaredFields[i];
			String name = field.getName();
			System.out.println("名称为：" + name);
			Class<?> fieldType = field.getType();
			System.out.println("类型为：" + fieldType);
			boolean isTurn = true;
			while (isTurn) {
				try {
					isTurn = false;
					if (fieldType.equals(int.class)) {
						System.out.println("利用方法setInt()修改成员变量的值");
						field.setInt(example, 6666);
					}
					System.out.println("修改前的值为：" + field.get(example));
				} catch (Exception e) {
					System.out.println("在设置成员变量时抛出异常，"
							+ "下面执行setAccessible()方法");
					field.setAccessible(true);
					isTurn = true;
				}
			}
		}
	}
}
