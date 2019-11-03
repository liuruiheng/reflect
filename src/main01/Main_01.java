package main01;

import java.lang.reflect.Constructor;

public class Main_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example_01 example = new Example_01("10","20","30");
		Class<? extends Example_01> exampleC = example.getClass();
		Constructor<?>[] declaredConstructors = exampleC.getDeclaredConstructors();
		//获得所有的构造方法并循环
		for (int i = 0; i < declaredConstructors.length; i++) {
			Constructor<?> constructor = declaredConstructors[i];
			boolean varArgs = constructor.isVarArgs();
			System.out.println("查看是否允许带有可变数量的参数：" + varArgs);
			Class<?>[] parameterTypes = constructor.getParameterTypes();
			System.out.println("该构造方法的入口参数类型依次为：");
			for (int j = 0; j < parameterTypes.length; j++) {
				System.out.println(parameterTypes[j]);
			}
			Class<?>[] exceptionTypes = constructor.getExceptionTypes();
			System.out.println("该构造方法可能抛出的异常类型为：");
			for (int j = 0; j < exceptionTypes.length; j++) {
				System.out.println("\"" + exceptionTypes[j] + "\"");
			}
			Example_01 example2 = null;
			while (example2 == null) {
				try {
					if (i == 2) {
						example2 = (Example_01)constructor.newInstance();
					}
					if (i == 1) {
						example2 = (Example_01)constructor.newInstance("100",1);
					}
					if (i == 0) {
						Object[] objects = new Object[] {new String[] {"100","200","300"}};
						example2 = (Example_01)constructor.newInstance(objects);
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("在创建对象时抛出异常，下面执行setAccessible()方法");
					declaredConstructors[i].setAccessible(true);
				}
			}
			if (example2 != null) {
				example2.print();
			}
		}
	}

}
