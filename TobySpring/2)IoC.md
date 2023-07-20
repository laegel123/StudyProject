## IoC
IoC 란 간단히 프로그램 제어 흐름 구조가 뒤바뀌는 것이라고 설명할 수 있다.  
 일반적으로 프로그램의 흐름은 main() 메서드와 같이 프로그램이 시작되는 지점에서 다음에 사용할 오브젝트를 결정하고, 결정한 오브젝트를 생성하고, 만들어진 오브
젝트에 있는 메서드를 호출하고, 그 오브젝트 메서드 안에서 다음에 사용할 것을 결정하고 호출하는 식의 작업이 반복된다. 이런 프로그램 구조에서 각 오브젝트는
프로그램의 흐름을 결정하거나 사용할 오브젝트를 구성하는 작업에 능동적으로 참여한다.  
 IoC 는 이런 제어 흐름의 개념을 거꾸로 뒤집는 것이다.
IoC 는 오브젝트가 자신이 사용할 오브젝트를 스스로 선택하거나 생성하지 않고, 또 자신도 어떻게 만들어지고 어디서 사용되는지를 알 수 없다. 모든 제어 권한을
자신이 아닌 다른 대상에게 위임하기 때문이다. 프로그램의 시작을 담당하는 main() 과 같은 엔트리 포인트를 제외하면 모든 오브젝트는 이렇게 위임받은 제어 권한을
갖는 특별한 오브젝트에 의해 결정되고 만들어진다.

## 예시
1. Servlet  
   일반적인 자바 프로그램은 위 설명과 같이 main() 메서드에서 시작해 개발자가 미리 정한 순서를 따라 오브젝트가 생성되고 실행된다. 그런데 서블릿은 개발해서 서버에
    배포할 수는 잇지만, 그 실행을 개발자가 직접 제어할 수 있는 방법은 없다. 대신 서블릿에 대한 제어 권한을 가진 Container 가 적절한 시점에 서블릿 클래스의 오브젝트를 만들고
    그 안의 메서드를 호출한다. 이렇게 서블릿이나 JSP 처럼 Container 안에서 동작하는 구조는 간단한 방식이긴 하지만 제어의 역전 개념이 적용되어 있다고 볼 수 있다.
2. Template Method Pattern  
    Design Pattern 중 하나인 Template Method Pattern 에서도 IoC 개념을 찾아볼 수 있다.

## Bean
Bean 은 스프링이 IoC 방식으로 관리하는 객체이다. 스프링이 직접 생성과 제어를 담당하는 객체들을 Bean 이라고 부른다.

## Bean Factory
스프링의 IoC 를 담당하는 핵심 컨테이너를 가리킨다. Bean을 등록하고, 생성하고, 조회하고, 반환하고, 그 외 부가적인 Bean 을 관리하는 기능을 담당한다.  
보통은 이런 팩토리를 바로 사용하지 않고, 이를 확장한 Application Context 를 이용한다.

## Application Context
Bean Factory를 확장한 IoC Container 이다. Bean을 등록하고 관리하는 기본적인 기능은 동일하고, 그 외 스프링이 제공하는 각종 부가 서비스를 추가로 제공한다.

## Configuration Metadata
스프링의 설정정보란 "Application Context" 또는 "Bean Factory" 가 IoC 를 적용하기 위해 사용하는 메타정보를 말한다. 실제로 스프링의 설정정보는 Container 에 어떤 기능을 세팅하거나
조정하는 경우에도 사용하지만, 그보다는 IoC Container 에 의해 관리되는 Application Object 를 생성하고 구성할 때 사용된다. Application 의 형상정보라고 부르기도 하고, Application 의
전체 그림이 그려진 blueprints 라고도 한다.

## Container 또는 IoC Container
IoC 방식으로 Bean 을 관리한다는 의미에서 Application Context 나 Bean Factory 를 Container 또는 IoC Container 라고도 한다.

---

Application Context 에 의해 만들어지는 Object 는 동일성이 보장이 된다. -> Application Context 는 singleton registry 이기 때문이다.
