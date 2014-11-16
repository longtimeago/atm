package com.ppol.atm.commons;

import org.springframework.util.Assert;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ppolishchuk on 8/17/14.
 */
public final class LocksRegistry<T> {
	private final ConcurrentMap<T, ReentrantLock> locks = new ConcurrentHashMap<T, ReentrantLock>();

	private LocksRegistry() {
		//use factory method
	}

	public static <T> LocksRegistry<T> createRegistry() {
		return new LocksRegistry<T>();
	}

	public boolean tryLock(T t) {
		final ReentrantLock lock = getOrCreateLock(t);
		return lock.tryLock();
	}

	public void lock(T t) {
		final ReentrantLock lock = getOrCreateLock(t);
		lock.lock();
	}

	public void unlock(T t) {
		verifyLockExists(t);
		final ReentrantLock lock = locks.get(t);
		lock.unlock();
	}

	private ReentrantLock getOrCreateLock(final T t) {
		ReentrantLock lock = locks.get(t);
		if (lock == null) {
			ReentrantLock newLock = new ReentrantLock();
			lock = locks.putIfAbsent(t, newLock);

			if (lock == null) {
				lock = newLock;
			}
		}
		return lock;
	}

	public void verifyCurrentThreadHoldsLock(T t) {
		verifyLockExists(t);
		Assert.isTrue(locks.get(t).isHeldByCurrentThread(), "Current thread is not holding the lock for " + t + "!");
	}

	private void verifyLockExists(T t) {
		Assert.isTrue(locks.containsKey(t), "No lock exists for " + t + "!");
	}

	public String getLock(T t) {
		return getOrCreateLock(t).toString();
	}
}
