import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(value = Parameterized.class)
public class CalendarioTest2 {
	MainDate calendario;

	@Before
	public void before() {
		calendario = new MainDate();
	}
	@Parameterized.Parameters
	public static Iterable<Object[]> getData() {
		List<Object[]> obj = new ArrayList<>();
		obj.add(new Object[] { -1, null, 2008,"error" });
		obj.add(new Object[] { 28, "febrerow", 2016,"error" });
		obj.add(new Object[] { 28, "febrero", -1,"error" });
		obj.add(new Object[] { 32, "octubre", 1500, "error" });
		obj.add(new Object[] { 0, "octubre", 1500, "error" });
		

		return obj;
	}

	private int d, a;
	private String m;
private String exp;
	public CalendarioTest2(int d, String m, int a, String exp) {
		this.d = d;
		this.m = m;
		this.a = a;
		this.exp=exp;
	}
	@Test 
	public void sumaDiaTest() {
		Assert.assertEquals("error", exp, calendario.sumaDia(d, m, a));

	}
}
