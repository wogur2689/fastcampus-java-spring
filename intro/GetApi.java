package com.example.demo.controller;

@RestController //REST API 컨트롤러 선언
@RequestMapping("/api") // http://localhost:8080/api/
public class GetApiController {
   
   @GetMapping(path = "/hi") // http://localhost:8080/api/hi
   public String getHi() {
         return "get hi"; //문자리턴
   }
   /* 실행후 브라우저에서 http://localhost:8080/get/hi에 접속시
    * 메소드가 실행되고 get hi라는 문자가 출력됨.
    */
   @RequestMapping(path = "/h1", method = RequestMethod.GET) // get / post / put / delete 모두 지정 가능.
   public String h1() {
         return "h1";
   }
   /* 실행후 브라우저에서 http://localhost:8080/get/h1에 접속시
    * 메소드가 실행되고 hi라는 문자가 출력됨.
    */

    // http://localhost:8080/api/query-param01?키=값
    // Map를 이용해서 받는 방법
    @GetMapping(path = "query-param")
    public String queryParam01(@RequestParam @Map<String, String> queryParam) {

        StringBuilder stringBuilder = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            stringBuilder.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });
        return stringBuilder.toString();
    }
    
    //명시적으로 받는 방법
    @GetMapping("query-param02")
    public String queryParam02 (
        @RequestParam String id,
        @RequestParam String email,
        @RequestParam int age
    ){
        System.out.println(id);
        System.out.println(email);
        System.out.println(age);

        return id + " " + email + " " + age;
    }

    //dto에 객체를 만들어서 이용하는 방법(가장 많이 사용)
    @GetMapping("query-param03")
    public String queryParam03 (Member member){
        System.out.println(member.getId());
        System.out.println(member.getEmail());
        System.out.println(member.getAge());

        return member.toString();
    }

}

public class Member {
    private String id;
    private String email;
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
