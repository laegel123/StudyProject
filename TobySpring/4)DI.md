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
