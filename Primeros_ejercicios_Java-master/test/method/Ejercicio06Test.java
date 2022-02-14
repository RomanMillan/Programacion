package method;


import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class Ejercicio06Test {
	
	
	@ParameterizedTest
	@MethodSource("parametros")
	void withMethodSource(int a, int b, boolean respuesta) {
		assertEquals(respuesta,method.Ejercicio.esMultiplo(a,b));
	}
	
	private static Stream<Arguments> parametros() {
		return Stream.of(
				Arguments.of(8,2,true),
				Arguments.of(2,8,false),
				Arguments.of(2,0,false),
				Arguments.of(0,2,false));
	}
	
}
