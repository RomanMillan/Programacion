package method;


import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class Ejercicio12Test {
	
	
	
	@ParameterizedTest
	@MethodSource("parametros")
	void withMethodSource(String a, int respuesta) {
		assertEquals(respuesta,method.Ejercicio.decimal(a));
	}
	
	private static Stream<Arguments> parametros() {
		return Stream.of(
				Arguments.of("100",4),
				Arguments.of("101",5),
				Arguments.of("100000",32),
				Arguments.of("0",0));
	}
	
	
}
