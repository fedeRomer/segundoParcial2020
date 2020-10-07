package test;

import org.junit.Test;

public class TestConsumoCamion {
	
	@Test
	public void calcularTanquesDeCombustible() {
		int distanciaKm=1800;
		int consumoL100km=24;
		int tanqueLitros=350;
		int tanquesAusar= 0;
		int litrosAconsumir=0;
		
		//para 100km uso 24L
		//para 1800 uso 432
		litrosAconsumir = (distanciaKm*consumoL100km)/100;
		tanquesAusar = litrosAconsumir/tanqueLitros;
		System.out.println(tanquesAusar);
	
	}

}
