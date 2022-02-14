package method;


import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class Ejercicio08Test {
	
	
	@ParameterizedTest
	@MethodSource("parametros")
	void withMethodSource(int hora1, int min1, int seg1, int hora2, int min2, int seg2, int respuesta) {
		assertEquals(respuesta,method.Ejercicio.segundosEntre(hora1, min1, seg1, hora2, min2, seg2));
	}
	
	private static Stream<Arguments> parametros() {
		return Stream.of(
				Arguments.of(24,3,2,12,1,1,-1000),
				Arguments.of(11,2,1,11,2,2,-1000),
				Arguments.of(11,2,2,11,2,2,0),
				Arguments.of(11,2,3,11,2,2,1),
				Arguments.of(11,2,1,11,552,2,-1000),
				Arguments.of(11,2,1,11,2,1252,-1000),
				Arguments.of(11,20,1,11,2,20,1061));
	}
	
}
