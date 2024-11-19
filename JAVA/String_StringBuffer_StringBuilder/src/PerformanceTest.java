public class PerformanceTest {
    public static void main(String[] args) {
        int iterations = 100000; // 문자열 조작을 반복할 횟수 설정
        int numTests = 10; // 테스트를 10회 반복

        // 평균값을 저장할 변수
        double totalTimeStringBuilder = 0;
        double totalMemoryStringBuilder = 0;
        double totalTimeStringBuffer = 0;
        double totalMemoryStringBuffer = 0;
        double totalTimeString = 0;
        double totalMemoryString = 0;

        for (int i = 0; i < numTests; i++) { // 10회 반복
            System.out.println("테스트 " + (i + 1) + "회차:");
            double[] result;

            // StringBuilder 성능 측정
            result = measurePerformance(new StringBuilder(), iterations, "StringBuilder");
            totalTimeStringBuilder += result[0];
            totalMemoryStringBuilder += result[1];

            // StringBuffer 성능 측정
            result = measurePerformance(new StringBuffer(), iterations, "StringBuffer");
            totalTimeStringBuffer += result[0];
            totalMemoryStringBuffer += result[1];

            // String 성능 측정
            result = measurePerformance(new String(), iterations, "String");
            totalTimeString += result[0];
            totalMemoryString += result[1];

            System.out.println();
        }

        // 평균값 계산 및 출력
        System.out.println("=== 평균값 ===");
        System.out.println("StringBuilder 평균 시간: " + (totalTimeStringBuilder / numTests) + " ms");
        System.out.println("StringBuilder 평균 메모리 사용: " + (totalMemoryStringBuilder / numTests) + " KB");
        System.out.println("StringBuffer 평균 시간: " + (totalTimeStringBuffer / numTests) + " ms");
        System.out.println("StringBuffer 평균 메모리 사용: " + (totalMemoryStringBuffer / numTests) + " KB");
        System.out.println("String 평균 시간: " + (totalTimeString / numTests) + " ms");
        System.out.println("String 평균 메모리 사용: " + (totalMemoryString / numTests) + " KB");
    }

    public static double[] measurePerformance(Object obj, int iterations, String type) {
        // 가비지 컬렉션 강제 호출 (테스트 전 메모리 정리)
        System.gc();

        Runtime runtime = Runtime.getRuntime();
        long startMemory = runtime.totalMemory() - runtime.freeMemory(); // 시작 메모리 측정
        long startTime = System.nanoTime(); // 시작 시간 측정

        // 문자열 조작 수행
        if (obj instanceof StringBuilder) {
            StringBuilder sb = (StringBuilder) obj;
            for (int i = 0; i < iterations; i++) {
                sb.append("test");
            }
        } else if (obj instanceof StringBuffer) {
            StringBuffer sb = (StringBuffer) obj;
            for (int i = 0; i < iterations; i++) {
                sb.append("test");
            }
        } else if (obj instanceof String) {
            String str = (String) obj;
            for (int i = 0; i < iterations; i++) {
                str += "test";
            }
        }

        long endTime = System.nanoTime(); // 끝난 시간 측정
        long endMemory = runtime.totalMemory() - runtime.freeMemory(); // 끝 메모리 측정

        // 결과 출력
        double time = (endTime - startTime) / 1e6; // 시간을 밀리초로 변환
        double memory = (endMemory - startMemory) / 1024.0; // 메모리를 KB로 변환
        System.out.println(type + " 시간: " + time + " ms");
        System.out.println(type + " 메모리 사용: " + memory + " KB");

        // 시간과 메모리 사용량 반환
        return new double[]{time, memory};
    }
}
