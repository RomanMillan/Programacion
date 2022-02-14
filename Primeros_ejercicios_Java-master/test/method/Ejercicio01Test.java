package method;


import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class Ejercicio01Test {
	
	
	@ParameterizedTest
	@MethodSource("parametros")
	void withMethodSource(int c1,int c2, int c3, int respuesta) {
		assertEquals(respuesta,method.Ejercicio.numeroSolucionesEcuacionSegundoGrado(c1, c2, c3));
	}
	
	private static Stream<Arguments> parametros() {
		return Stream.of(
				Arguments.of(2,2,2,0),
				Arguments.of(0,2,-2,-1),
				Arguments.of(2,2,-2,2),
				Arguments.of(2,0,0,1),
				Arguments.of(2,0,5,0),
				Arguments.of(-2,0,5,2),
				Arguments.of(-22,-5,5,2),
				Arguments.of(-22,-5,-85,0),
				Arguments.of(-22,0,9,2)
				);
	}
	
}
