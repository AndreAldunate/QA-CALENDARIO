import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class CalendarioTest {
	MainDate calendario;

	@Before
	public void before() {
		calendario = new MainDate();
	}

	@Parameterized.Parameters
	public static Iterable<Object[]> getData() {
		List<Object[]> obj = new ArrayList<>();
		obj.add(new Object[] { 1, "julio", 2008, "2/julio/2008" });
		obj.add(new Object[] { 28, "junio", 2016, "29/junio/2016" });
		obj.add(new Object[] { 28, "febrero", 2015,"1/marzo/2015" });
		obj.add(new Object[] { 31, "diciembre", 1500, "1/enero/1501" });
		obj.add(new Object[] { 31, "enero", 1500, "1/febrero/1500" });
		obj.add(new Object[] { 31, "marzo", 1500, "1/abril/1500" });
		obj.add(new Object[] { 31, "mayo", 1500, "1/junio/1500" });
		obj.add(new Object[] { 31, "julio", 1500, "1/agosto/1500" });
		obj.add(new Object[] { 31, "agosto", 1500, "1/septiembre/1500" });
		obj.add(new Object[] { 31, "octubre", 1500, "1/noviembre/1500" });
		obj.add(new Object[] { 30, "abril", 1500, "1/mayo/1500" });
		obj.add(new Object[] { 30, "junio", 1500, "1/julio/1500" });
		obj.add(new Object[] { 30, "septiembre", 1500, "1/octubre/1500" });
		obj.add(new Object[] { 30, "noviembre", 1500, "1/diciembre/1500" });
		

		return obj;
	}

	private int d, a;
	private String m;
	private String exp;

	public CalendarioTest(int d, String m, int a, String exp) {
		this.d = d;
		this.m = m;
		this.a = a;
		this.exp = exp;
	}

	@Test
	public void sumaDiaTest() {
		Assert.assertEquals("error", exp, calendario.sumaDia(d, m, a));

	}

}