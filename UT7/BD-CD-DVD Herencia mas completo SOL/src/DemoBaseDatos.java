/**
 * 
 */
public class DemoBaseDatos {

	private BaseDatos bd;

	/**
	 * Constructor
	 */
	public DemoBaseDatos() {
		bd = new BaseDatos();

	}

	/**
	 *  
	 */
	public void demoAddArticulo() {
		CD cd1 = new CD("T�tulo 1 de CD", "artista 1", 10, 58);
		cd1.setComentario("el que m�s me gusta");
		CD cd2 = new CD("T�tulo 2 de CD", "artista 2", 13, 120);
		CD cd3 = new CD("T�tulo 3 de CD", "artista 3", 12, 100);
		cd3.setHayCopia(false);
		CD cd4 = new CD("T�tulo 4 de CD", "artista 4", 8, 135);

		bd.addArticulo(cd1);
		bd.addArticulo(cd2);
		bd.addArticulo(cd3);
		bd.addArticulo(cd4);

		DVD dvd1 = new DVD("T�tulo 1 de DVD", "director 1", 120);
		DVD dvd2 = new DVD("T�tulo 2 de DVD", "director 2", 90);
		DVD dvd3 = new DVD("T�tulo 3 de DVD", "director 3", 110);

		bd.addArticulo(dvd1);
		bd.addArticulo(dvd2);
		bd.addArticulo(dvd3);

		Video video1 = new Video("T�tulo 1 de Video", "avi", 98);
		bd.addArticulo(video1);

	}

	/**
	 *  
	 *
	 */
	public void demoListar() {
		bd.listar();
	}

	/**
	 *  
	 *
	 */
	public void demoBorrarCD() {
		bd.borrarCD();
	}

	/**
	 *  
	 *
	 */
	public void demoTotalDVD() {
		System.out.println(
				"Hay en la BD un total de " + bd.totalDVD() + " DVD's");
	}

	/**
	 *  
	 *
	 */
	public void demoDuracionCD() {
		System.out.println(
				"Duraci�n total de CD " + bd.totalDuracionCD() + " minutos");
	}

	/**
	 *  
	 *
	 */
	public void demoVideosConFormato(String formato) {
		System.out.println("V�deos con formato " + formato + " "
				+ bd.videosConFormato(formato));
	}

//     /**
//      *  
//      *
//      */
//     public void prueba()
//     {
//         List<CD> cds = new ArrayList<CD>();
//         cds.add(new CD("T�tulo 1 de CD", "artista 1", 10, 58));
//         // List<Articulo> articulos = cds;   // no compila
//         List<? extends Articulo> articulos = cds;
//         for (Articulo arti: articulos)
//         {
//             arti.print();
//         }
//         CD cd = new CD("T�tulo 2 de CD", "artista 2", 13, 120);
//         articulos.add(cd);
//     }

	public static void main(String[] args) {
		DemoBaseDatos demo = new DemoBaseDatos();
		demo.demoAddArticulo();
		demo.demoListar();
		demo.demoTotalDVD();
		demo.demoDuracionCD();
		demo.demoVideosConFormato("avi");
		demo.demoBorrarCD();
		demo.demoListar();

	}

}
