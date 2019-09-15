# JAVA_JUnit

- 전체적으로 테스트된 소프트웨어는 완벽한 제품이지만 세분화했을 때도 각 개별 요소들을 데스트할 수 있어야 한다. 이런 상태를 '테스트 가능해진'이라고 한다

- 테스트를 거쳐 완성된 빌드는 항상 올바르게 작동할 것이 생각하는데, 알 수 없는 이유로 테스트에 문제가 발생한다면 새로 작성한 코드가 시스템의 어딘가에서 버그를 일으켰다는 것이며, 이는 회귀(regression)이라고 한다.

- 테스트는 개발 프로세스의 시작 단계부터 고려하는 것이 좋다. 테스트를 할 때 자바용으로 테스팅에 필요한 모든 기능이 있는 도구를 많이 사용하게 된다

- 이 중 가장 많이 알려지고 널리 사용되는 것이 `JUnit`이다.

  - 단위 테스트, 시스템 테스트, UI 테스트 등 모든 수준의 테스트를 만들 수 있는 가볍고 단순한 인터페이스를 제공
  - 앤트나 메이븐, 그래들 등 다양한 빌드 도구에 기본으로 포함되어 있다
  - 그래서 테스트에 문제가 생기면 자동으로 빌트를 멈추고 에러를 표현

  ### JUnit의 가치

  - JUnit은 보통 TDD(Test-Driven Development) 개발 방법론에 기반을 둔다.
  - 코드가 어떻게 작동하길 바라는지에 관한 예상이나 가정을 기반으로 짧은 실행을 반복하는 데스트를 만드는 절차
    - 보통 테스트에 관한 코드는 처음부터 없기에 테스트에 문제가 발생할 수 있다
    - 위의 예상이나 가정을 통해 테스트가 통과하도록 코드를 작성
    - 통과하면 다른 기능에도 테스트에 관한 코드를 작성하는 절차를 반복
    - 테스트하려는 기능 모두에 테스트를 작성했다면 모든 테스트가 통과하는지 확인
    - 테스트가 통과하면 코드가 올바르게 작동하리라
  - 테스트를 기능과 관계없는 다른 요구사항을 충족하는지도 확인할 수 있다.
  - 적정 규모의 모든 프로젝트는 빌드 시스템을 이용 → 작성하는 코드는 반드시 빌드에 통합 → 코드를 변경했을 때 테스트에 통과하지 못하면 빌드가 중지 → 문제가 된 코드를 수정, 다시 빌드
    - 메이븐에서 테스트는 빌드과정의 일부로 작동
    - 앤트에서 테스트는 명령어 하나로 동합되어 있다
  - 즉, 코드가 올바르게 작동한다고 확신한다는 건 자동화된 도구를 더 믿을 수 있다는 의미
  - 서버 측 아키텍처를 개발 할 때 지속적인 배포(continuous delivery) 모델을 구축할 수 있는 기반

  ### JUnit 테스트 실행

  - JUnit은 많은 IDE에 잘 통합되어 있지만 JUnit 라이브러리인 JUnitCore 클래스의 지원으로 커맨드라인에서 직접 호출할 수도 있다

    - JUnitCore 클래스에는 커맨드라인에서 테스트를 시작하는 데 사용하는 `main 메서드` 가 있다.
    - 테스트하려는 클래스의 리스트가 매개변수

    ```shell
    $ /path/to/java -cp /path/to/junit.jar:. [classes to test]
    ```

  - 메이븐에서 프로젝트가 지정된 구조를 따르면 프로젝트의 루트 디렉터리에서 mvn test를 실행해 프로젝트의 모든 테스트를 찾아 실행 가능

    - JUnit 라이브러리의 의존성만 지정하면 테스팅하는데 JUnit 사용 가능

    - ex) 시스템 속성인 SystemTest를 설정해 해당 속성에 지정된 테스트만 실행

      ```shell
      mvn test -Dtest=SystemTest
      ```

    - 테스트 매개변수는 와일드카드로 사용 가능

    - IntergrationTest라는 접미사를 가진 테스트가 모두 실행되도록 `-Dtest=*IntergrationTest`라고 시스템 속성을 설정할 수 있다

### JUnit 시스템 생명주기

- 테스트 세트를 실행할 때 각 테스트는 지정된 단계를 따른다.
- 이런 단계들은 테스트를 모듈화하고 가능한 한 많은 코드를 재사용할 수 있게 해준다.
- 테스트 세트는 대개 클래스에 한정
  - 테스트 세트처럼 일부 코드를 실행하려면 void 타입을 반환하는 public으로 정의한정적 메서드를 지정하고 @BeforeClass를 표시
  - 모든 테스트가 완료된 후에 실행할  수 있는 어노테이션은 @AfterClass
- @BeforeClass 메서드의 테스트가 성공하면 테스트 실행기는 테스트 세트에서 각 테스트에 다음 단계를 수행
  1. 테스트 세트(클래스는 단일 생성자)의 새로운 인스턴스가 생성
  2. @Before 어노테이션과 void 타입을 반환하는 모든 public메서드가 실행
     - @Before 어노테이션으로 선언한 메서드에서 설정을 하고, @After 어노테이션으로 선언한 메서드를 이용해 대칭성을 유지
  3. 테스트가 실행 @Test 어노테이션으로 정의된 테스트는 public 이고 void 타입값으로 반환
  4. 테스트가 성공하거나 실패한 후에 @After 어노테이션으로 선언한 메서드(public void)가 호출
- @Before, @After, @Test 어노테이션으로 선언된 각 메서드의 실행 순서는 보장하지 않는다.
- 테스트는 독립적이고 원자적이어야만 한다.
- 다음 예는 두 개의 테스트를 가진 테스트 세트의 모든 수행 단계를 보여준다

```java
public class JUnitLifecycle{
    private static int counter = 0;
    //정적 변수 b/c @Test 어노테이션이 선언된 메서드를 한 번씩 실행할 때마다 JUnitLifecycle인스턴스를 두번 초기화    
    @BeforeClass
    public static void suitSetup(){
        assertEquals(0, counter);
        counter++;
    }
    
    public JUnitLifecycle(){
        assertTrue(Arrays.asList(1, 5).contains(counter));
        counter++;
    }
    
    @Before
    public void prepareTest(){
     	assertTrue(Arrays.asList(2, 6).contains(counter));
        counter++;
    }
    
    @Test
    public void performFirstTest(){
        assertTrue(Arrays.asList(3, 7).contains(counter));
        counter++;
    }
    
    @Test
    public void performSecondTest(){
        assertTrue(Arrays.asList(3, 7).contains(counter));
        counter++;
    }
    
    @After
    public void cleanupTest(){
        assertTrue(Arrays.asList(4, 8).contains(counter));
        counter++;
    }
    
    @AfterClass
    public static void suiteFinished(){
        assertEquals(9, counter)
    }
}
```

- @Ignore 어노테이션을 선언한 모든 테스트 메서드는 무시
  - 테스트에 문제가 있거나 지속적인 통합(continuous intergration) 빌드에 문제를 발생시키는 테스트에 자주 사용
  - 종종 코드 냄새를 표시하기도 한다
    - code smell, 프로그램 코드의 설계 문제, 심각한 문제를 암시하는 징후
  - 테스트로 커버할 수 없는 코드를 알려줄 수도 있고, 코드 안 내용이 올바를 것이라는 확신을 감소
  - 제출용일 시 주의

### Assert 클래스

- 가정을 표현하는 데 사용하는 많은 정적 메서드를 보유, 가정이 참이라는 것을 증명

- 메서드, 함수

  - assertEquals : 두 개의 객체가 자신들의 equals 메서드에 따라 같은지 비교
  - assertTrue, assertFalse : 주어진 상태를 Boolean 예상치와 비교
  - assertNotNull : 객체가 null이 아니다
  - assertArrayEquals : 두 배열에 같은 값이 있다. Object 배열의 비교라면 equals 메서드로 동일성을 검사

- 가정이 맞지 않으면 예외가 발생

- fail : 테스트 실패 단계에 사용할 수 있는 메서드

- 모든 assertXxxx메서드들은 추가 String 매개변수와 짝을 지어 오버로드

  - String 매개변수 :  가정에 문제가 있을 때 나타날 메시지

- 간단한 사용법

  ```java
  @Test
  public void assertionWithMessage(){
      final List<Integer> numbers = new ArrayList<>();
      numbers.add(1);
      
      assertTrue("The numbers list should not be empty", numbers.isEmpty());
  }
  junit.framework.AssertionFailedError: The list is not Empty
  ```


### 예외 예상

- 코드에 문제가 있어서 예외가 발생하는 상황을 테스트하는 중이라면
  - 해당 테스트에 예상되는 예외 종류를 알려줄 수 있다
  - 데스트에서 해당 예외가 발생하면 이 예외를 처리
  - @Test 어노테이션의 매개변수는 이 테스트가 예외를 처리해야만 한다고 테스트 실행기에 알려준다
  - 다만 예상되는 예외와 다른 경우의 문제를 구분하기는 어렵다
- checkString : 메서드에 전달된 String 타입 값이 null이라면 예외를 처리하는 유틸리티 메서드
- @Test 어노테이션의 매개변수
  - expected
    - 특정 타입의 예외가 발생했을 때 테스트를 통과하게 한다
    - 많이 사용하지 않는 것이 좋다
  - timeout
    - long타입의 값을 받는다, 밀리세컨드 단위
    - 테스트가 지정된 시간보다 오래 실행되면 테스트가 실패하게 된다
- @RunWith 어노테이션
  - 클래스 수준의 어노테이션
  - 테스트 실행기의 기본 동작을 변경 가능하게
  - 매개변수
    - Runner 클래스의 하위 클래스
      - 일반적으론 Parameterized 클래스를 선택
      - @RunWith(Parameterized.class)

### 사용자화

- 실행중인 테스트들을 사용자화하려면 테스트 실행기를 직접 만드는 것이 좋다

- 단위 테스트 세트의 좋은 속성 중 하나는 테스트들이 독립적이어야 한다는 것

- JUnit 실행기는 Runner 추상 클래스의 실제 구현이다

  ```java
  public abstract class Runner implements Describable{
      public abstract Description getDescription();
      public abstract void run(RunNotifier notifier);
      
      public int testCount(){
          return getDescription().testCount();
      }
  }
  ```

  - 구현시 Class 캑체를 받는 하나의 매개변수만 전달받는 생성자를 제공해야 한다
  - 구현해야 하는 메서드
    - getDescription 
      - 어떤 메서드가 어떤 순서로 실행되어야 하는지 알려주는 메서드
      - 반환값 : Description
        - 무슨 테스트가 어떤 순서를 실행되어야 하는지를 직접 정의하는 클래스
    - run : 실제로 테스트를 실행하는 메서드



















