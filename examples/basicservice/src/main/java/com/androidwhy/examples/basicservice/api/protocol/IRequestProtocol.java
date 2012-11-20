package com.androidwhy.examples.basicservice.api.protocol;

/**
 * AndroidWhy.com All Rights Reserved.
 * User: gordon
 * Date: 10/19/12
 * Time: 11:14 AM
 * Description：
 */
public interface IRequestProtocol<T,S> {

    public T decode(S s);
}
