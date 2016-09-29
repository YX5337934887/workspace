package org.agency.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * ʹ��cglib��̬����
 */
public class BookFacadeProxy implements MethodInterceptor {
	private Object target;

	/**
	 * ������������
	 * @param target
	 * @return
	 */
	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		// �ص�����
		enhancer.setCallback(this);
		// ������������
		return enhancer.create();
	}

	@Override
	// �ص�����
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("���￪ʼ");
		Object o = proxy.invokeSuper(obj, args);
		System.out.println("�������");
		return o;

	}

}