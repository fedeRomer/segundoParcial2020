package test;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import negocio.dto.Provincias;

public class ReflectionTest {

	@Test
	public void reflectionGetMethodsToString() {
		Class<Provincias> c = Provincias.class;

		Method[] methods = c.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			//System.out.println(methods[i].toString());
			Stream<Method> stream =  Arrays.stream(methods); 
			stream.forEach(str -> System.out.print(str + " \n --"));
			if(methods[i].toString().equalsIgnoreCase("caba")) {
				//System.out.println(methods[i].toString() +methods[i].getName());
			}
		}
	}

}
