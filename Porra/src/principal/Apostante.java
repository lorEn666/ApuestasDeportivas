package principal;

public class Apostante {
	private String nombre;
	private String partido;
	private int resultadoLocal;
	private int resultadoVisitante;

	public Apostante(String nombre, String partido, int resultadoLocal, int resultadoVisitante) {
		this.nombre = nombre;
		this.partido = partido;
		this.resultadoLocal = resultadoLocal;
		this.resultadoVisitante = resultadoVisitante;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPartido() {
		return partido;
	}

	public int getResultadoLocal() {
		return resultadoLocal;
	}

	public int getResultadoVisitante() {
		return resultadoVisitante;
	}

	@Override
	public String toString() {
		return nombre + "\t" + partido + "\t" + resultadoLocal + "   -   " + resultadoVisitante + "\n";
	}

}
