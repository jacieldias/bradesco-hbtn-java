
public class Numero {
	
	public static void dividir(int a, int b) {
		try {
			int resultado = a/b;
		} catch (Exception e) {
			System.out.println("Nao eh possivel dividir por zero");
			System.out.println(String.format("%d / %d = %d", a, b, resultado));
			
		}finally {
			System.out.println(String.format("%d / %d = %d", a, b, resultado));
		}
	}

}
