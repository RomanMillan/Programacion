package method;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class Ejercicio04Test {
	
	
	@ParameterizedTest
	@MethodSource("parametros")
	void withMethodSource(Double r,Double respuesta) {
		assertEquals(respuesta,method.Ejercicio.areaCirculo(r));
	}
	
	private static Stream<Arguments> parametros() {
		return Stream.of(
				Arguments.of(0.0,0.0),
				Arguments.of(1.0 ,3.14),
				Arguments.of(-1.0,3.14),
				Arguments.of(4.0,50.24));
	}
	
}