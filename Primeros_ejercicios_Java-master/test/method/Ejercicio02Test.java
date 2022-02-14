package method;


import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class Ejercicio02Test {
	
	@ParameterizedTest
	@MethodSource("parametros")
	void withMethodSource(int c1,int c2, int c3 , Double respuesta) {
		assertEquals(respuesta, method.Ejercicio.solucionSumaEcuacionSegundoGrado(c1, c2, c3));
	}
	
	private static Stream<Arguments> parametros() {																									
		return Stream.of(
				Arguments.of(2,-7,3,3.0),
				Arguments.of(-1,7,-10,2.0),
				Arguments.of(0,2,-2,-1000.0),
				Arguments.of(1,-2,1,1.0),
				Arguments.of(1,1,1,-1000.0),
				Arguments.of(1,-4,4,2.0),
				Arguments.of(-1,4,-4,2.0),
				Arguments.of(7,21,-28,1.0),
				Arguments.of(-1,4,-7,-1000.0)
				);
	}
	
}
