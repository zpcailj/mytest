package com.jswl.dao;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
@Transactional
public class AccountServiceImpl implements AccountService {

	// 业务层注入 DAO:
	private AccountDao accountDao;
	
	private  TransactionTemplate  transactionTemplate;

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	/**
	 * from:转出的账号 * to:转入的账号 * money：转账金额
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public void transfer(String from, String to, Double money) {

			
			

				// TODO Auto-generated method stub
				accountDao.outMoney(from, money);
				int a=1/0;
				accountDao.inMoney(to, money);

		
	}

}
