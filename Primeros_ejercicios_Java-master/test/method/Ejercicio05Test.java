package method;


import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class Ejercicio05Test {
	
	
	@ParameterizedTest
	@MethodSource("parametros")
	void withMethodSource(Double r,Double respuesta) {
		assertEquals(respuesta,method.Ejercicio.longitudCirculo(r));
	}
	
	private static Stream<Arguments> parametros() {
		return Stream.of(
				Arguments.of(0.0,0.0),
				Arguments.of(1.0 ,6.28),
				Arguments.of(-1.0,-6.28),
				Arguments.of(3.0,18.84));
	}
	
}
