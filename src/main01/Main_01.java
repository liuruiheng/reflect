package main01;

import java.lang.reflect.Constructor;

import reflect.Example_01;

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
		}
	}

}
