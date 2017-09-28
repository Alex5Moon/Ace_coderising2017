import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionHandler implements InvocationHandler {
	
	private Object target;
	Transaction t = new Transaction();
	
	public TransactionHandler(Object target) {
		// TODO Auto-generated constructor stub
		super();
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		if("transfer".equals(method.getName())){
			t.beginTx();
			Object result = method.invoke(target, args);
			t.commitTx();
			return result ;
		}else{
			Object result = method.invoke(target, args);
			return result;
		}
	}
	
	public static void main(String [] args){
		AccountService as = new AccountServiceImpl();
		
		TransactionHandler handler = new TransactionHandler(as);
		
		AccountService userServiceProxy = (AccountService)Proxy.newProxyInstance(handler.getClass().getClassLoader(),
		as.getClass().getInterfaces(),handler);
		
		userServiceProxy.transfer("A100", "B200", 233);
		
		userServiceProxy.query("A100");
	}

}
