# 5장 제네릭

*** 

# item26. 로타입(raw type)은 사용하지 말라
* raw type : 제네릭 타입(제네릭 클래스 or 제네릭 인터페이스)에서 타입 매개변수를 전혀 사용하지 않을 때 
ex) List<E> 의 raw type = List 
  <br />
  raw type은 제네릭 타입 정보가 전부 지워진 것처럼 동작 (제네릭이 도래하기 전의 코드와 호환되기 위해)
  <br />
  
* 제네릭 타입은 오류를 컴파일 단계에서 발견할 수 있도록 도와줌, 해당 타입 매개 변수에 엉뚱한 인스턴스를 넣을 때 컴파일 에러 발생 
<br />
  
* raw type을 쓰면 제네릭이 안겨주는 안정성과 표현력을 모두 잃게 된다. 
<br />
  
* 그렇다면 raw type은 왜 있는 것인지 ? "호환성"
<br />


List (X) - 타입 안정성을 잃음 <br /> 
List<Object> (O) - 모든 타입을 허용한다는 의사를 컴파일러에 전달하기 때문


* 제네릭 타입을 쓰고 싶지만, 실제 타입 매개변수가 무엇인지 신경쓰고 싶지 않다면 -> ?(비한정적 와일드 카드 타입?)

* 예외
  1) class 리터럴에는 raw type 사용해야함 
    <br />
ex) List.class, String[] class, int.class (O)
  List<String>.class, List<?>.class (X)
     <br />
     
    2) instanceof 연산자
    <br />
    ex)
       <code>
       if (o instanceof Set) { Set<?> s = (Set<?>) o; }
       </code>
       
