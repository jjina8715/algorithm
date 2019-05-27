package polynomial;

public class Polynomial {
	Term termArray[];
	int terms;

	public Polynomial() {
		this.terms = 0;
		this.termArray = new Term[10];
		for (int i = 0; i < termArray.length; i++) {
			termArray[i] = new Term();
		}
	}

	void print() {
		String result = "";
		for (int i = 0; i < this.termArray.length; i++) {
			if (this.termArray[i].coef == 0) {
				continue;
			} else {
				if (i != 0) {
					result = result + " + " + this.termArray[i].coef + "x^" + this.termArray[i].exp;
				} else {
					result = this.termArray[i].coef + "x^" + this.termArray[i].exp;
				}
			}
		}
		if (result == "")
			System.out.println("0");
		else
			System.out.println(result);
	}

	void newTerm(float coef, int exp) {
		if (this.termArray.length == this.terms) {
			Term temp[] = new Term[this.termArray.length * 2];
			for (int i = 0; i < this.termArray.length; i++) {
				temp[i] = termArray[i];
			}
			this.termArray = temp;
		}
		this.termArray[this.terms].coef = coef;
		this.termArray[this.terms++].exp = exp;
	}

	public Polynomial add(Polynomial b) {
		Polynomial result = new Polynomial();
		int idx = 0, idxB = 0, exp, expB;
		float tmp;
		
		for (; idx < this.terms && idxB < b.terms;) {
			expB = b.termArray[idxB].exp;
			exp = this.termArray[idx].exp;
			if (exp < expB) {
				result.newTerm(b.termArray[idxB].coef, expB);
				idxB++;
			} else if (exp == expB) {
				if((tmp = this.termArray[idx].coef + b.termArray[idxB].coef)!=0)
					result.newTerm(tmp, expB);
				idx++;
				idxB++;
			} else if (exp > expB) {
				result.newTerm(this.termArray[idx].coef, exp);
				idx++;
			}
		}

		while (idx < this.terms)
			result.newTerm(this.termArray[idx++].coef, this.termArray[idx].exp);
		while (idxB < b.terms)
			result.newTerm(b.termArray[idxB++].coef, b.termArray[idxB].exp);
		return result;
	}

	public Polynomial Mul(Polynomial b) {
		Polynomial temp = null;
		Polynomial result = null;
		float coef;
		int exp;
		for (int i = 0; i < this.terms; i++) {
			temp = new Polynomial();
			coef = this.termArray[i].coef;
			exp = this.termArray[i].exp;
			for (int j = 0; j < b.terms; j++) {
				temp.newTerm(coef * b.termArray[j].coef, exp + b.termArray[j].exp);
			}
			if (i == 0) result = temp;
			else result = result.add(temp);
		}
		return result;
	}
}
