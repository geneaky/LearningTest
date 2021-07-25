package ProxyPattern;

import java.lang.reflect.Proxy;

public class PersonBeanImpl implements PersonBean {

  //protection proxy
  String name;
  int age;

  public PersonBeanImpl(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  static PersonBean getOwnerProxy(PersonBean person) {
    return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
        person.getClass().getInterfaces(),
        new OwnerInvocationHandler(person));
  }

  static PersonBean getNonOwnerProxy(PersonBean person) {
    return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
        person.getClass().getInterfaces(),
        new NonOwnerInvocationHandler(person));
  }
}
