# 6장 열거 타입과 애너테이션 

- 클래스의 일종인 <b>Enum<b/> , 인터페이스의 일종인 <b>Annotation<b/> <br />
특수한 목적의 참조 타입 두 가지

***

# item 34. int 상수 대신 enum 타입을 사용하라 
- 클래스인 Enum은 상수 하나당 자신의 인스턴스를 하나씩 만들어 public static final 필드로 공개한다 

<pre>
<code>
public enum Apple {
    FUJI(3)
}

=>

public enum Apple {
    public static final Apple FUJI = new Apple(3);
}
</code>
</pre>

- enum 상수는 값 뿐만 아니라 로직도 가지고 있을 수 있다. <i>abstract</i> 를 이용하여
<pre>
<code>
case PLUS : return x + y;

=> abstract method 사용
PLUS("+") {
    public double apply(double x, double y) { 
    return x + y;
},

=> lambda 를 쓰면 더 깔끔 
PLUS("+", (x,y) -> x+y),

public abstract double apply(double x, double y);
</code>
</pre>

- 전략 열거 타입 패턴 (strategy enum pattern)
  (기존 열거 타입에 상수별 동작을 혼합해 넣을 때는 switch문이 좋음)

***

# item 35. ordinal 메서드 대신 인스턴스 필드를 사용하라 

- Enum의 API 문서에 ordinal 메서드가 "EnumSet, EnumMap과 같이 열거 타입 기반의 범용 자료구조에 쓸 목적으로 설계되었다"
와 같이 서술되어 있는 것 처럼, 왠만하면 사용하지 말고 열거 타입 상수의 숫자 인스턴스 필드에 저장해서 위치 파악하자
