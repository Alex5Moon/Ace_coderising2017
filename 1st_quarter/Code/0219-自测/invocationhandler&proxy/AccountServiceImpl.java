public class AccountServiceImpl implements AccountService {

	@Override
	public void transfer(String fromAccount, String toAccount, int ammount) {
		// TODO Auto-generated method stub
		System.out.println("Transfer " + ammount + " from " + fromAccount + " to " + toAccount );
	}

	@Override
	public void query(String accountId) {
		// TODO Auto-generated method stub
		System.out.println("query account id:" +accountId);
	}

}
