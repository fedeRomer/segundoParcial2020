package test;

import org.junit.Test;

public class TestConsumoCamion {
	
	@Test
	public void calcularTanquesDeCombustible() {
		int distancia=1800;
		int consumo=24;
		int tanqueLitros=350;
		
		/*
			24 L/100Km
			(800km / 350km)*24L
			(800/100)*24 = cantidad de litros a consumir 
			24*8?
		 */
		int tanquesAusar= 0;
		int litrosAconsumir=0;
		tanquesAusar = distancia/tanqueLitros;
		//distancia a recorrer = 800
		//tanque litros = 350
		//consumo Litros cada 100km 24
		// (distancia * 24L) / 100 = cantidad de litros a consumir en viaje
		
		litrosAconsumir= (distancia*consumo)/100;
		tanquesAusar = litrosAconsumir/tanqueLitros;
		
		/*800/350 = X CANTIDAD DE TANQUES
		 * //(gastoFinal*tanque)/cantidadQueLleva
		 */
		System.out.println(tanquesAusar);
	
	}

}
