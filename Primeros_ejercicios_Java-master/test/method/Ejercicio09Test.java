package method;


import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class Ejercicio09Test {
	
	
	@ParameterizedTest
	@MethodSource("parametros")
	void withMethodSource(int a, int b, int respuesta) {
		assertEquals(respuesta,method.Ejercicio.maximoComunDivisor(a,b));
	}
	
	private static Stream<Arguments> parametros() {
		return Stream.of(
				Arguments.of(656,848,16),
				Arguments.of(1728,842,2),
				Arguments.of(1728,841,1),
				Arguments.of(841,1728,1));
	}
	
}
