public class Quaternion {
	private final double a;
	private final double b;
	private final double c;
	private final double d;

	/**
	 * Створюємо новий кватерніон зі своїх компонентів.
	 * 
	 * @param a - скалярний компонент
	 * @param b - перший компонент вектора
	 * @param c - другий компонент вектора
	 * @param d - третій компонент вектора
	 */
	public Quaternion(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}



	/**
	 * Повертаємо суму цього та вказаного кватерніонів.
	 * @param q - кватерніон, який потрібно додати
	 */
	public Quaternion add(Quaternion q) {
		return new Quaternion(a + q.getA(), b + q.getB(), c + q.getC(), d + q.getD());
	}


	/**
	 * Повертаємо різницю цього та вказаного кватерніонів.
	 * @param q - кватерніон, який потрібно відняти
	 */
	public Quaternion subtract(Quaternion q) {
		return new Quaternion(a - q.getA(), b - q.getB(), c - q.getC(), d - q.getD());
	}

	/**
	 * Повертає цей кватерніон, помножений на скаляр.
	 * @param scalar - скаляр, на який потрібно помножити кватерніон
	 */
	public Quaternion multiply(double scalar) {
		return new Quaternion(a * scalar, b * scalar, c * scalar, d * scalar);
	}

	/**
	 * Повертає добуток цього кватерніона на вказаний кватерніон
	 * @param q - кватерніон, на який потрібно помножити
	 */
	public Quaternion multiply(Quaternion q) {
		return new Quaternion(a * q.getA() - b * q.getB() - c * q.getC() - d * q.getD(),
				a * q.getB() + b * q.getA() + c * q.getD() - d * q.getC(),
				a * q.getC() - b * q.getD() + c * q.getA() + d * q.getB(),
				a * q.getD() + b * q.getC() - c * q.getB() + d * q.getA());
	}
	/**
	 * Повертає цей кватерніон, поділений на скаляр.
	 * @param scalar - скаляр, на який потрібно поділити кватерніон
	 */
	public Quaternion divide(double scalar) {
		return new Quaternion(a / scalar, b / scalar, c / scalar, d / scalar);
	}

	/**
	 * Повертає частку цього кватерніона на вказаний кватерніон
	 * @param q - кватерніон, на який потрібно поділити
	 */
	public Quaternion divide(Quaternion q) {
		return multiply(q.getInverse());
	}

	/** Повертає спряжений кватерніон цього кватерніона */
	public Quaternion getConjugate() {
		return new Quaternion(a, -b, -c, -d);
	}

	/** Повертає норму цього кватерніона в десятковій формі. */
	public double getNorm() {
		return Math.sqrt(a * a + b * b + c * c + d * d);
	}

	/** Повертає норму цього кватерніона в радикальній формі */
	public String getNormRadical() {
		double normSquared = a * a + b * b + c * c + d * d;
		return "sqrt(" + normSquared + ")";
	}

	/**
	 * Повертає обернений кватерніон у десятковій формі.
	 */
	public Quaternion getInverse() {
		return getConjugate().divide(getNorm() * getNorm());
	}

	/**
	 * Повертає обернений кватерніон у формі дробу.
	 */
	public String getInverseFraction() {
		Quaternion conj = getConjugate();
		double normSquared = getNorm() * getNorm();
		String aInv = conj.getA() + "/" + normSquared;
		String bInv = conj.getB() + "/" + normSquared;
		String cInv = conj.getC() + "/" + normSquared;
		String dInv = conj.getD() + "/" + normSquared;
		return "[" + aInv + ", " + bInv + ", " + cInv + ", " + dInv + "]";
	}
	/**
	 * Повертає скалярну складову цього кватерніона.
	 */
	public double getA() {
		return a;
	}
	/**
	 * Повертає перший компонент вектора цього кватерніона.
	 */
	public double getB() {
		return b;
	}
	/**
	 * Повертає другий компонент вектора цього кватерніона.
	 */
	public double getC() {
		return c;
	}

	/**
	 * Повертає третю векторну компоненту цього кватерніона.
	 */
	public double getD() {
		return d;
	}


	/**
	 * Вивід результату.
	 */
	@Override
	public String toString() {
		return "(" + a + ") + (" + b + ")i + (" + c + ")j + (" + d + "k)";
	}

}
