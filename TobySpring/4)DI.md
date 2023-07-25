스프링을 설명할 때 IoC Container 라고 불리기도 하지만, 사실 IoC 라는 용어는 스프링이 제공하는 기능의 특징을 명확하게 설명하지 못한다. 스프링이 Servelt Container 처럼 
서버에서 동작하는 Service Container 라는 뜻인지, 아니면 또 다른 IoC 특징을 지닌 기술이라는 것인지 파악하기 힘들다. 그래서 스프링의 IoC 의 동작 원리를 설명할 수 있는 
용어인 DI 를 사용해 DI Container 라고도 불린다.
 이 DI 는 스프링이 여타 다른 프레임워크와 차별화돼서 제공해주는 개념이라고 볼 수 있다. 

#### 의존 오브젝트 란?
 만약 인터페이스를 통해 설계 시점에 두 object 가 느슨한 의존관계를 갖는 경우 runtime 시에 사용할 object 가 어떤 클래스로 만든 것인지 미리 알 수 없다. 이후 프로그램이 시작되고 
 object가 만들어지고 나서 runtime 시에 의존관계를 맺는 대상, 즉 실제 사용대상인 object 를 dependent object 라고 말한다.
-> 인터페이스를 통해 object 들이 느슨하게 의존관계를 맺고있을 때, runtime 시에 실제 의존관계를 맺게되어 사용 대상이 되는 object 를 말한다. 

# DI 란 ?
 DI 는 이렇게 구체적인 dependent object 와 그것을 사용할 주체, 보통 client 라고 부르는 object 를 runtime 시에 연결해주는 작업을 말한다.  
 정리하자면 DI 는 다음과 같은 세 가지 조건을 충족하는 작업을 말한다.

1. class model 이나 코드에는 runtime 시점의 의존관계가 드러나지 않는다. 그러기 위해서는 interface 에만 의존하고 있어야 한다.
2. runtime 시점의 의존관계는 container 나 factory 같은 제 3의 존재가 결정한다.
3. 의존관계는 사용할 object 에 대한 레퍼런스를 외부에서 제공(주입) 해줌으로써 만들어진다.

 DI 의 핵심은 설계 시점에는 알지 못했던 두 object 의 관계를 맺도록 도와주는 제 3의 존재가 있다는 것이다. 이 제 3의 존재는 바로 관계설정 책임을 가진 코드를 분리해서 만든 
 object라고 볼 수 있다. 예컨대 Application Context, Bean Factory, IoC Container 등이 모두 외부에서 object 사이의 runtime 관계를 맺어주는 책임을 지닌 제 3의 존재라고 볼 수 있다.
   
DI 는 자신이 사용할 object 에 대한 선택과 생성권을 외부로 넘기고 자신은 수동적으로 주입받은 object 를 사용한다는 점에서 IoC 의 개념에 잘 들어맞는다. Spring Container 의  
IoC 는 주로 DI 에 초점이 맞춰져 있다. 그래서 스프링을 IoC Container 외에도 DI Container 또는 DI Framework 라고도 부른다.

---

## 의존관계 검색과 주입
 스프링이 제공하는 IoC 방법에는 DI 만 있는 것이 아니다. 코드에서는 구체적인 클래스에 의존하지 않고, 런타임 시에 의존관계를 결정한다는 점에서 DI 와 비슷하지만, 의존관계를 
맺는 방법이 외부로부터의 주입이 아니라 스스로 검색을 이용하기 때문에 dependency lookup(의존관계 검색) 이라고 불리는 것도 있다. 의존관계 검색은 자신이 필요로 하는 의존 오브젝트를 
능동적으로 찾는다. 물론 자신이 어떤 클래스의 오브젝트를 이용할지 결정하지는 않는다. 그러면 IoC 라고 할 수는 없을 것이다. 의존관계 검색은 런타임 시 의존관계를 맺을 오브젝트를 결정하는 것과 
오브젝트의 생성작업은 외부 컨테이너에게 IoC 로 맡기지만, 이를 가져올 때는 메서드나 생성자를 통한 주입 대신 스스로 컨테이너에게 요청하는 방법을 사용한다.  
 예를 들면 다음과 같다.

```java
public class Test {
 public UserDao() {
  DaoFactory daoFactory = new DaoFactory();
  this.connectionMaker = daoFactory.connectionMaker();
 }
}
```

이렇게 하면 UserDao는 여전히 자신이 어떤 ConnectionMaker 오브젝트를 사용할지 미리 알지 못한다. 여전히 코드의 의존대상은 ConnectionMaker 인터페이스 뿐이다.
 스프링의 IoC Container 인 애플리케이션 컨텍스트는 getBean() 이라는 메서드를 제공한다. 스프링에서는 이 메서드를 통해 의존관계 검색을 사용할 수 있다.

```java
public class Test {
 public UserDao() {
     AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
     this.connectionMaker = context.getBean("connectionMaker", ConnectionMaker.class);
 }
}
```

의존관계 검색은 기존 DI 의 거의 모든 장점을 갖고 있다. IoC 원칙에도 잘 들어맞는다. 단, 방법만 조금 다를 뿐이다.  
 DI 와 DL 을 비교하면 DI 쪽에 훨씬 단순하고 깔끔하다. DL 은 코드 안에 오브젝트 팩토리 클래스나 스프링 API 가 나타난다. 애플리케이션 컴포넌트가 컨테이너와 같이 성격이 다른 오브젝트에 의존하게 
되는 것이므로 그다지 바람직하지 않다.  
 그런데 DL 을 사용해야 할 때가 있다. 애플리케이션 기동 시점에서는 스태틱 메서드인 main() 에서 DI 를 통해 오브젝트를 주입받을 방법이 없기 때문에 DL 을 사용해야 한다.  
서버에서도 마찬가지다. 서버에는 main() 과 같은 기동 메서드는 없지만, 사용자의 요청을 받을 때마다 main() 메서드와 비슷한 역할을 하는 서블릿에서 스프링 컨테이너에 담긴 
오브젝트를 사용하려면 한 번은 DL 방식을 사용해 오브젝트를 가져와야 한다. 다행히 이런 서블릿은 스프링이 미리 만들어서 제공하기 때문에 직접 구현할 필요는 없다.  
 DL 과 DI 의 중요한 차이점이 하나 있다. DL 방식에서는 검색하는 오브젝트는 자신이 스프링의 빈을 필요가 없다는 점이다. 위 코드를 보면, UserDao 는 굳이 스프링이 만들고 
관리하는 빈일 필요가 없다. 이 때는 ConnectionMaker 가 스프링의 빈이기만 하면 된다. 반면에 DI 에서는 UserDao 와 ConnectionMaker 사이에 DI 가 적용되려면 UserDao 도 반드시 
컨테이너가 만드는 빈 오브젝트여야 한다. 컨테이너가 UserDao 에 ConnectionMaker 오브젝트를 주입해주려면 UserDao 에 대한 생성과 초기화 권한을 갖고 있어야 하고, 그러려면 
UserDao 는 IoC 방식으로 컨테이너에서 생성되는 오브젝트, 즉 빈이어야 하기 때문이다. 이런 점에서 DI 와 DL 은 적용 방법에 차이가 있다.

    DI 를 원하는 오브젝트를 먼저 자기 자신이 컨테이너가 관리하는 빈이 돼야 한다.

---

## 의존관계 주입의 응용
#### DI 기술의 장점
코드에 런타임 클래스에 대한 의존관계가 나타나지 않고, 인터페이스를 통해 결합도가 낮은 코드를 만들므로, 다른 책임을 가진 사용 의존관계에 있는 대상이 바뀌거나 낮은 코드를 만들므로, 
다른 책임을 가진 사용 의존관계에 있는 대상이 바뀌거나 변경되더라도 자신은 영향을 받지 않으며, 변경을 통한 다양한 확장 방법에는 자유롭다는 장점이 있다.


