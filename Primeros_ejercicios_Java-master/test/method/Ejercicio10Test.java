package method;


import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class Ejercicio10Test {
	
	
	@ParameterizedTest
	@MethodSource("parametros")
	void withMethodSource(int a, int b, int respuesta) {
		assertEquals(respuesta,method.Ejercicio.minimoComunMultiplo(a,b));
	}
	
	private static Stream<Arguments> parametros() {
		return Stream.of(
				Arguments.of(24,36,72),
				Arguments.of(36,24,72),
				Arguments.of(32,24,96),
				Arguments.of(15,20,60));
	}
	
	
}
