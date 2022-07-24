# 8장. 메서드
(메서드 설계할 때 주의할 점, ex- 매개변수, 반환값, 메서드 시그니처 설계, 문서화)

***

# item 49. 매개변수가 유효한지 검사하라.
- @throws, @exception 태그 - 이름이 다를 뿐 동일하게 사용
  <pre>
  <code>
    /**
     * 파일 삭제
     *
     * @throws java.lang.SecurityException 보안 관련
     * @exception FileNotFoundException 지정된 파일을 찾을 수 없습니다
     */
    public void deleteFile() throws SecurityException {

    }
  </code>
  </pre>
- requireNonNull
: null체크를 위한 메소드, <br />
  입력된 값이 null 이면 NPE를 발생시키며, 그렇지 않으면 입력값을 반환 <br />
  <b>사용 이유 </b> <br />
  - 빠른 실패 (오류는 가능한 한 빨리)
  - 명시성과 가독성 
  
- assert 
: private 메소드 시에는 유효한 값만이 메서드에 넘겨질 것을 보장할 수 있으므로, 
  assert를 사용하여 매개변수 유효성을 검증할 수 있다고 하였는데,<br />
  <pre>
  <code>
  /**
  * Assert that an object is null.
  * Assert.isNull(value, "The value must be null");
  * Params:
  * object – the object to check
  * message – the exception message to use if the assertion fails
  * Throws:
  * IllegalArgumentException – if the object is not null
  */
  public static void isNull(@Nullable Object object, String message) {
    if (object != null) {
  	  throw new IllegalArgumentException(message);
    }
  }

  /**
  * Assert that an object is {@code null}.
  * Assert.isNull(value, () -&gt; "The value '" + value + "' must be null");
  * @param object the object to check
  * @param messageSupplier a supplier for the exception message to use if the
  * assertion fails
  * @throws IllegalArgumentException if the object is not {@code null}
  * @since 5.0
  */
    public static void isNull(@Nullable Object object, Supplier<String> messageSupplier) {
      if (object != null) {
        throw new IllegalArgumentException(nullSafeGet(messageSupplier));
      }
    }

  /**
  * Assert that an object is {@code null}.
  * @deprecated as of 4.3.7, in favor of {@link #isNull(Object, String)}
  */
    @Deprecated
    public static void isNull(@Nullable Object object) {
      isNull(object, "[Assertion failed] - the object argument must be null");
    }
  </code>
  </pre>

=> 메서드나 생성자를 작성할 때에, 유효성 검사 비용이 지나치게 높거나(Collection.sort(list)) 계산 과정에서 암묵적으로
  검사가 수행될 때 제외하고, 위의 두 태그를 사용해 제약들을 문서화하고 메서드 코드 시작 부분에 명시적으로 검사하는 습관을 기르자.

***
# item 50.적시에 방어적 복사본을 만들라. 
=> 클라이언트 단으로 객체값을 리턴해줄때, 객체 레퍼런스를 함께 넘기면 레퍼런스를 통해 내부 값을 변경할 수 있으니 복사본을 만들어 사용 및 리턴해야한다. <br/>

외부 공격으로부터 Period 인스턴스의 내부를 보호하려면, 
1) 생성자에서 받은 가변 매개변수 각각을 방어적으로 복사해야함
2) 가변 필드의 방어적 복사본을 반환 

해당 예시가 setter보다 builder를 써야하는 이유의 예가 되는지..?

*** 
# item 51. 메서드 시그니처를 신중히 설계하라. 
### 메서드 이름을 신중히 짓자.
- 명명규칙 (item 68)
  - 클래스, 인터페이스 - (철자규칙) Pascal, (문법규칙) 명사(구)
  - 메서드, 필드 - (철자규칙) camel, (문법규칙) 동사 
  ... 

### 편의 메서드를 너무 많이 만들지 말자.

### 매개변수 목록은 짧게 유지 (4개 이하가 좋다). 
- 매개변수가 4개 이상이 넘어가면 아래 방법 고려
  - 여러 메서드로 쪼갠다. (직교성이 높도록.?)
  - 매개변수 여러 개를 묶어주는 도우미 클래스 
  - 빌더 패턴을 사용하여 매소드 호
***
# item 52. 다중정의는 신중히 사용하라
컴파일 타임, 런타임 

***

Q. 파라미터 null 체크 보통 어떻게 하세요 ? ( 이건 질문 아니구 걍 스터디 시간에 모든 분들께 들어보고 싶은 내용임당 )
<pre>
<code>

</code>
</pre>

Q. clone( ) 메소드의 주의사항에 대해서 알고 싶어요!!

Q. 코드 49-2 재귀 정렬용 private 도우미 함수에서 assert가 어떻게 동작하는지 시연을 보고 싶습니다. 

Q. P.308 편의 메서드에 대한 설명

Q. P.310 카드게임을 클래스로 만든다고 가정했을 때 rank, suit매개변수를 묶는 도우미 클래스를 만들어 하나의 매개변수로 주고받는 API의 샘플이 궁금합니다.

Q. p.317 다중정의 해소 알고리즘(?)을 고려할 사항이 위의 예시말고 다른것이 있을지 궁금합니다.