package method;


import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class Ejercicio11Test {
	
	
	@ParameterizedTest
	@MethodSource("parametros")
	void withMethodSource(int a, String respuesta) {
		assertEquals(respuesta,method.Ejercicio.binario(a));
	}
	
	private static Stream<Arguments> parametros() {
		return Stream.of(
				Arguments.of(4,"100"),
				Arguments.of(5,"101"),
				Arguments.of(32,"100000"),
				Arguments.of(0,"0"));
	}
	
	
}
