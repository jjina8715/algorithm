package polynomial;

public class Main {

	public static void main(String[] args) {
		polynomial();
	}

	public static void polynomial() {
		float[] a_coef = { 1, 1 };
		int[] a_exp = { 1, 0 };

		float[] b_coef = { 5, -10, 5, -10 };
		int[] b_exp = { 3, 2, 1, 0 };

		Polynomial a = new Polynomial();
		Polynomial b = new Polynomial();

		Polynomial result;
		for (int i = 0; i < a_exp.length; i++) {
			a.newTerm(a_coef[i], a_exp[i]);
		}
		for (int i = 0; i < b_exp.length; i++) {
			b.newTerm(b_coef[i], b_exp[i]);
		}
		a.print();
		b.print();
		result = a.add(b);
		System.out.print("다항식 a + 다항식 b = ");
		result.print();
		
		result = a.Mul(b);
		System.out.print("다항식 a * 다항식 b = ");
		result.print();

	}

}
