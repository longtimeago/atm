package com.ppol.atm.commons;

import org.springframework.stereotype.Service;

/**
 * Created by ppolishchuk on 8/17/14.
 */
@Service
public class CardLocker {

	private final LocksRegistry<String> registry = LocksRegistry.createRegistry();

	public boolean tryLock(String string) {
		return registry.tryLock(string);
	}

	public void lock(String string) {
		registry.lock(string);
	}

	public void unlock(String string) {
		registry.unlock(string);
	}

	public void verifyCurrentThreadHoldsLock(String string) {
		registry.verifyCurrentThreadHoldsLock(string);
	}

	public String getLock(String string) {
		return registry.getLock(string);
	}
}
