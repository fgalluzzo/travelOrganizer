import javax.persistence.EntityManager;

import org.junit.Test;

import pyt.util.JPAUtil;


public class CriaBancoTest {
	
	@Test
	public void criaBanco(){
		try{
			EntityManager em = new JPAUtil().getEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
