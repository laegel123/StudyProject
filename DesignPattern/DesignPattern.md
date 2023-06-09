# 디자인 원칙
### 1. 애플리케이션에서 달라지는 부분을 찾아내고, 달라지지 않는 부분과 분리한다.
    코드에 새로운 요구 사항이 있을 때마다 달라지는 부분이 있다면 그 부분을 찾아서 나머지 코드에 영향을 주지 않도록 분리해 '캡슐화' 한다.  
    이렇게 하면 코드를 변경하는 과정에서 의도치 않게 발생하는 일을 줄이며 시스템의 유연성을 향상시킬 수 있다.
### 2. 구현보다는 인터페이스에 맞춰서 프로그래밍한다.
### 3. 상속보다는 구성을 활용한다.
      'A 안에 B 가 있다' 의 관계로 두 클래스를 합치는 것을 말한다.
      구성을 활용해서 시스템을 만들면 유연성을 크게 향상시킬 수 있다.
### 4. 상호작용하는 객체 사이에는 가능하면 느슨한 결합을 사용해야 한다.
      느슨한 결합은 객체들이 상호작용할 수는 있지만, 서로를 잘 모르는 관계를 의미한다.
      느슨하게 결합하는 디자인을 사용하면 변경 사항이 생겨도 객체 사이의 상호 의존성을 최소화할 수 있어 무난히 처리할 수 있는 유연한 객체지향 시스템을 구축할 수 있다.
### 5. 클래스는 확정에는 열려 있어야 하지만 변경에는 닫혀 있어야 한다. (Open-Closed Principle)
### 6. 추상화된 것에 의존하게 만들고 구상 클래스에 의존하지 않게 만든다. (Dependency Inversion Principle)


--- 

## 객체지향 기초
### 1. 추상화
### 2. 캡슐화
### 3. 다형성
### 4. 상속

---
## DI 원칙 지키는 가이드 라인
### 1. 변수에 구상 클래스의 레퍼런스를 저장하지 않는다.
      new 연산자를 사용하면 구상 클래스의 레퍼런스를 사용하게 된다. 그러니 팩토리를 써서 구상 클래스의 레퍼런스를 변수에 저장하는 일을 미리 방지해야 한다.
### 2. 구상 클래스에서 유도된 클래스를 만들지 않는다.
      구상 클래스에서 유도된 클래스를 만들면 특정 구상 클래스에 의존하게 된다. 
      인터페이스나 추상 클래스처럼 추상화된 것으로부터 클래스를 만들어야 한다.
### 3. 베이스 클래스에 이미 구현되어 있는 메서드를 오버라이드 하지 않는다.
      이미 구현되어 있는 메서드를 오버라이드한다면 베이스 클래스가 제대로 추상화되지 않는다.
      베이스 클래스에서 메서드를 정의할 대는 모든 서브클래스에서 공유할 수 있는 것만 정의해야 한다.

이 가이드 라인은 항상 지켜야 하는 규칙이 아니라, 지향해야 할 바를 알려주는 것이다. 

---
## 객체지향 원칙
### 1. 자주 바뀌는 부분은 캡슐화한다.
### 2. 상속보다는 구성을 활용한다.
### 3. 구현보다는 인터페이스에 맞춰서 프로그래밍한다.
### 4. 상호작용하는 객체 사이에서는 가능하면 느슨한 결합을 사용해야 한다.
### 5. 클래스는 확장에는 열려 있어야 하지만 변경에는 닫혀 있어야 한다. (Open-Closed Principle)

---
# 1. Strategy Pattern (전략 패턴)
   전략패턴은 알고리즘군을 정의하고 캡슐화해서 각각의 알고리즘군을 수정해서 쓸 수 있게 하는 것이다.  
   이 패턴을 사용하면 클라이언트로부터 알고리즘을 분리해서 독립적으로 변경할 수 있다.  
   이 알고리즘군을 보통 자주 바뀌는 부분을 분리한다.

# 2. Observer Pattern (옵저버 패턴)
   한 객체의 상태가 바뀌면 그 객체가 의존하는 다른 객체들에게 연락이 가고 자동으로 내용이 갱신되는 방식이다.
   옵저버 패턴은 일련의 객체 사이에서 일대다 관계를 가지며 한 객체의 상태가 변경되면 그 객체에 의존하는 모든 객체에게 연락이 간다.

   옵저버 패턴은 여러 가지 방법으로 구현할 수 있지만, 보통은 주제 인터페이스와 옵저버 인터페이스가 들어있는 클래스 디자인으로 구현한다.

# 3. Decorator Pattern (데코레이터 패턴)
   데코레이터 패턴은 객체에 추가 요소를 동적으로 더할 수 있게 하는 패턴이다.  
   이 패턴을 사용하면 서브클래스를 만들 때보다 훨씬 유연하게 기능을 확장할 수 있다.

   데코레이터 패턴은 다음과 같은 특징을 가진다.
- 데코레이터의 슈퍼 클래스는 자신이 장식하고 있는 개체의 슈퍼클래스와 같다.
- 한 객체를 여러 개의 데코레이터로 감쌀 수 있다.
- 데코레이터는 자신이 장식하고 있는 객체에게 어떤 행동을 위임하는 일 말고도 추가 작업을 수행할 수 있다.
- 객체는 언제든지 감쌀 수 있으므로 실행 중에 필요한 데코레이터를 마음대로 적용할 수 있다.
- 이 패턴은 상속을 받긴 하지만 행동을 상속받는 게 아닌, 형식을 맞추기 위해 상속을 받는다는 것을 이해해야 한다.
실제로 행동은 구성을 통해 동작하게끔 한다.
- 또한 데코레이터는 자기가 감싸고 있는 구성 요소의 메서드를 호출한 결과에 새로운 기능을 더함으로써 행동을 확장할 수 있다.
- 구성 요소의 클라이언트는 데코레이터의 존재를 알 수 없다. (단, 클라이언트가 구성 요소의 구체적인 형식에 의존하는 경우는 예외이다.)
- 이 패턴을 사용하면 자잘한 객체가 매우 많이 추가될 수 있고, 데코레이터를 너무 많이 사용하면 코드가 필요 이상으로 복잡해질 수 있다.

# 4. Factory Pattern (팩토리 패턴) 
    객체 생성을 캡슐화해서 애플리케이션의 결합을 느슨하게 만들고, 특정 구현에 덜 의존하도록 만들 수 있는 패턴이다.  
    다음과 같은 두 가지 방식이 있다.

## 4-1. Factory Method Pattern (팩토리 메서드 패턴)
   이 패턴은 객체를 생성할 때 어떤 클래스의 인스턴스를 만들것인지 서브클래스에서 결정하는 패턴을 말한다.  
   -> 사용하는 서브클래스에 따라 생산되는 객체 인스턴스가 결정된다.
    
보통 클라이언트 코드와 인스턴스를 만들어야 할 구상 클래스를 분리시켜야 할 때 활용한다.  
    또한, 어떤 구상 클래스가 필요할 지 미리 알 수 없을 때에도 유용하다.

    - 객체 생성 코드를 한 객체 또는 메서드에 넣으면 코드에서 중복되는 내용을 제거할 수 있으며 관리하기 편하다.
    - 객체 생성을 캡슐화함으로써 추상 클래스나 인터페이스를 바탕으로 코딩할 수 있다.
    - 클라이언트 코드와 실제 클래스 구현을 분리할 수 있다.

## 4-2. Absctract Factory Pattern (추상 팩토리 패턴)
   이 패턴을 사용하면 구상 클래스에 의존하지 않고도 서로 연관되거나 의존적인 객체로 이루어진 제품군을 생산하는 인터페이스를 제공한다.  
   구상 클래스는 서브클래스에서 만든다.

   추상 팩토리 패턴을 사용하면 클라이언트에서 추상 인터페이스로 일련의 제품을 공급받을 수 있다.  

   보통 클라이언트에서 서로 연관된 일련의 제품을 만들어야 할 때, 즉 제품군을 만들어야 할 때 활용한다.


### Factory Method Pattern 과 Abstract Factory Pattern 의 비교

   Factory Method Pattern

        상속으로 객체를 만든다 (클래스를 확장하고 팩토리 메서드를 오버라이드하여 객체를 생성한다.)
        클라이언트는 구상 형식을 서브클래스에서 처리해주기 때문에 자신이 사용할 추상 형식만 알면 된다. 즉, 클라이언트와 구상 형식을 분리할 수 있다.

   Absctract Factory Pattern

        구성으로 객체를 만든다. 
        제품군을 만드는 추상 형식을 제공한다. 이 팩토리를 사용하는 방식은 인스턴스를 만든 다음 추상 형식을 써서 만든 코드에 전달한다.
        Factory Method Pattern 과 마찬가지로 클라이언트와 실제 구상이 분리된다. 
        다만, 제품군에 제품을 추가하는 식의 관련된 제품을 확대하려면 인터페이스를 변경해야 한다.
