package mediaPOO;

import java.util.Objects;

public class Media {
	private int num1;
	private int num2;

	public Media(int num1, int num2) {
			this.num1 = num1;
			this.num2 = num2;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int mediaN() {
		int result = (num1 + num2) / 2;
		return result;
	}

	@Override
	public String toString() {
		return "Media [num1=" + num1 + ", num2=" + num2 + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(num1, num2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Media other = (Media) obj;
		return num1 == other.num1 && num2 == other.num2;
	};

}
