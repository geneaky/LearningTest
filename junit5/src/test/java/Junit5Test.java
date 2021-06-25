import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@Tag("AAAA") //플러그인 설정에서 테스트시 포함하거나 제외할 테스트를 태그로 필터링 가능 태그는 메소드, 클래스 레벨에서 가능
public class Junit5Test {

    @BeforeAll
    static void beforeAllInit(){
        System.out.println("모든 테스트 실행전 딱 한 번 실행");
    }

    @AfterAll
    static void afterAllInit(){
        System.out.println("모든 테스트 실행후 딱 한 번 실행");
    }

    @BeforeEach //각 테스트 전 실행 / 테스트간 의존을 막기 좋음 ex) 객체 초기화
    void init(TestInfo testInfo){
        String callingTest = testInfo.getTestMethod().get().getName();
        System.out.println(callingTest+" start");
    }

    @AfterEach
    void after(TestInfo testInfo){
        String callingTest = testInfo.getTestMethod().get().getName();
        System.out.println(callingTest+" end");
    }

    @Test
    @Disabled
    @DisplayName("무시될 테스트 입니다.")
    public void ignoreTest() throws Exception
    {
        //given

        //when

        //then
    }

    @Test
    @Tag("AAAA")
    @DisplayName("@Test") //테스트 이름 지정
    public void helloJUnit5() throws Exception
    {
        //given

        //when

        //then
        assertEquals(10,5+5);
    }

    @CsvSource({"cali","bali","dani"}) //인자 넘겨 주기
    @ParameterizedTest //인자 여러개의 입력에 따른 테스트
    @DisplayName("@ParameterizedTest")
    public void endsWith(String str) throws Exception
    {
        //given

        //when

        //then
        assertTrue(str.endsWith("i"));
    }

    //반복횟수, "콘솔 출력 방식"
    @Disabled
    @RepeatedTest(value = 5,name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("@RepeatedTest")
    void customDisplayName(RepetitionInfo repInfo){
        int i = 3;
        assertEquals(repInfo.getCurrentRepetition(),i);
        
    }


}
